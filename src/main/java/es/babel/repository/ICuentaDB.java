package es.babel.repository;

import es.babel.model.Cuenta;

import java.util.List;

public interface ICuentaDB {


    Cuenta obtenerCuenta(int id);
    void agregarCuenta(Cuenta cuenta);
    void modificarCuenta(int id);
    void borrarCuenta(int id);

    List<Cuenta> listarCuenta();


}
