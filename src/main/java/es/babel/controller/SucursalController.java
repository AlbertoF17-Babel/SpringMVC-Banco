package es.babel.controller;

import es.babel.model.Sucursal;
import es.babel.service.SucursalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.function.SupplierUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/sucursales")
    public String listarSucursales(Model model) {
        List<Sucursal> sucursales = sucursalService.listarSucursales();
        model.addAttribute("sucursales", sucursales);
        return "sucursales";
    }

    @PostMapping("/sucursal")
    public String crearSucursal(@ModelAttribute Sucursal sucursal, Model model) {
        sucursalService.agregarSucursal(sucursal);
        List<Sucursal> sucursales = sucursalService.listarSucursales();
        model.addAttribute("sucursales", sucursales);
        return "sucursales";
    }

    @PostMapping("/{id}/delete")
    public String eliminarSucursal(@PathVariable int id, Model model) {
        sucursalService.borrarSucursal(id);
        List<Sucursal> sucursales = sucursalService.listarSucursales();
        model.addAttribute("sucursales", sucursales);
        return "sucursales";
    }

    @PostMapping("/sucursal/{id}")
    public String detalleSucursal(@PathVariable int id, Model model) {
        Sucursal sucursal = sucursalService.detalleSucursal(id);

        model.addAttribute("sucursal", sucursal);
        return "detalleSucursal";
    }





}
