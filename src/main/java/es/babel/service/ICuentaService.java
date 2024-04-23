package es.babel.service;

import es.babel.model.Cuenta;

import java.util.List;

public interface ICuentaService {

    List<Cuenta> obtenerCuentas(int idCliente);
    Cuenta agregarCuenta (Cuenta cuenta);
    void modificarCuenta(int idCuenta);
    void borrarCuenta(int idCuenta);

    List<Cuenta> listarCuenta();

}
