package es.babel.repository;

import es.babel.model.Sucursal;

import java.util.List;

public interface ISucursalDB {
    void inicializarSucursales();

    List<Sucursal> listarSucursales();

    void agregarSucursal(Sucursal sucursal);

    void borrarSucursal(int id);

    Sucursal buscarSucursal(int id);
}
