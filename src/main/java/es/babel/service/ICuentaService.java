package es.babel.service;

import es.babel.model.Cuenta;

import java.util.List;

public interface ICuentaService {

    Cuenta obtenerCuenta(int id);
    Cuenta agregarCuenta(Cuenta cuenta);
    void modificarCuenta();
    void borrarCuenta(int id);

    List<Cuenta> listarCuenta();

}
