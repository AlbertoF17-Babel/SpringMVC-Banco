package es.babel.service;

import es.babel.model.Sucursal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ISucursalService {
    List<Sucursal> listarSucursales();

    Sucursal detalleSucursal(@PathVariable int id);

    void agregarSucursal(@ModelAttribute Sucursal sucursal);

    void modificarSucursal(@PathVariable int id, @ModelAttribute Sucursal sucursal);

    void borrarSucursal(@PathVariable int id);
}
