package es.babel.service;

import es.babel.model.Cuenta;

import java.util.List;

public interface ICuentaService {

    List<Cuenta> obtenerCuentas(int idCliente);
    void agregarCuenta (Cuenta cuenta);
    void modificarCuenta(int idCuenta);
    void borrarCuenta(Cuenta cuenta);

    List<Cuenta> listarCuenta();

    Cuenta obtenerCuenta(int id);
}
