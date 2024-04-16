package es.babel.repository;

import es.babel.model.Cuenta;

import java.util.List;

public interface ICuentaDB {


    Cuenta obtenerCuenta(int id);
    Cuenta agregarCuenta(Cuenta cuenta);
    void modificarCuenta();
    void borrarCuenta(int id);

    List<Cuenta> listarCuenta();


}
