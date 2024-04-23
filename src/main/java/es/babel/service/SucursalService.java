package es.babel.service;

import es.babel.model.Sucursal;
import es.babel.repository.ISucursalDB;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SucursalService implements ISucursalService {

    private final ISucursalDB iSucursalDB;

    public SucursalService(ISucursalDB iSucursalDB) {
        this.iSucursalDB = iSucursalDB;
    }

    @Override
    public List<Sucursal> listarSucursales() {
        return this.iSucursalDB.listarSucursales();
    }

    @Override
    public Sucursal detalleSucursal(@PathVariable int id) {
        return this.iSucursalDB.buscarSucursal(id);
    }

    @Override
    public void agregarSucursal(@ModelAttribute Sucursal sucursal) {
        this.iSucursalDB.agregarSucursal(sucursal);
    }

    @Override
    public void modificarSucursal(@PathVariable int id, @ModelAttribute Sucursal sucursal) {
        Sucursal sucursalAModificar = this.iSucursalDB.buscarSucursal(id);
        sucursalAModificar.setNombre(sucursal.getNombre());
        sucursalAModificar.setDireccion(sucursal.getDireccion());
        sucursalAModificar.setDirector(sucursal.getDirector());
    }

    @Override
    public void borrarSucursal(@PathVariable int id) {
        iSucursalDB.borrarSucursal(id);
    }



}
