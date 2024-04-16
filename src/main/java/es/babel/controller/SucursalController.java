package es.babel.controller;

import es.babel.model.Sucursal;
import es.babel.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/sucursales")
    public String listarSucursales(@ModelAttribute Model model) {
        List<Sucursal> sucursales = sucursalService.listarSucursales();
        model.addAttribute("sucursales", sucursales);
        return "sucursales";
    }



}
