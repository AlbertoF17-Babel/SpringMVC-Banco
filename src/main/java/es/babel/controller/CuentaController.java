package es.babel.controller;

import es.babel.model.Cliente;
import es.babel.model.Cuenta;
import es.babel.model.Sucursal;
import es.babel.service.IClienteService;
import es.babel.service.ICuentaService;
import es.babel.service.ISucursalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/cuentas")
public class CuentaController {

    private final ICuentaService cuentaService;
    private final ISucursalService sucursalService;

    public CuentaController(ICuentaService cuentaService, ISucursalService sucursalService) {
        this.cuentaService = cuentaService;
        this.sucursalService = sucursalService;
    }

    @GetMapping
    public void cuenta(Model model) {
        List<Cuenta> listaCuentas = cuentaService.listarCuenta();
        List<Sucursal> listaSucursales = sucursalService.listarSucursales();
        model.addAttribute("sucursales", listaSucursales);
        model.addAttribute("cuentas", listaCuentas);
    }

    @PostMapping
    public String agregarCuenta(@ModelAttribute("cuentas") Cuenta cuenta){
        cuentaService.agregarCuenta(cuenta);
        return "redirect:/cuentas";
    }

    @PostMapping("/{id}/delete")
    public String borrarCuenta(@ModelAttribute("cuentas") int id){
        Cuenta cuenta = cuentaService.obtenerCuenta(id);
        cuentaService.borrarCuenta(cuenta);
        return "redirect:/cuentas";
    }

    @PostMapping(value= "/{id}/update")
    public String modificarCuenta(@ModelAttribute("cuentas") Cuenta cuenta){
        cuentaService.modificarCuenta(cuenta);
        return "redirect:/cuentas";
    }

    @GetMapping(value = "/{id}")
    public String getCuentaByID(@PathVariable int id, Model model){
        Cuenta cuenta = cuentaService.obtenerCuenta(id);
        model.addAttribute("cuentas", cuenta);
        List<Sucursal> sucursales = sucursalService.listarSucursales();
        model.addAttribute("sucursales", sucursales);
        return "detalleCliente";
    }

}
