package es.babel.repository;

import es.babel.model.Cuenta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaDB implements ICuentaDB {

    List<Cuenta> listaCuentas;

    @Override
    public Cuenta obtenerCuenta(int id) {
        return null;
    }

    @Override
    public Cuenta agregarCuenta(Cuenta cuenta) {
        return null;
    }

    @Override
    public void modificarCuenta() {

    }

    @Override
    public void borrarCuenta(int id) {

    }

    @Override
    public List<Cuenta> listarCuenta() {
        return null;
    }

    /*
    @Override
    public Cuenta obtenerCuenta(int id) {
        Cuenta cuenta = null;
        for (Cuenta cuentaItem : listaCuentas) {
            if (id == cuentaItem.getId()) {
                cuenta= cuentaItem;
                break;
            }
        }
        return cuenta;
    }

    @Override
    public Cuenta agregarCuenta(Cuenta cuenta) {
        listaCuentas.add(cuenta);
        return cuenta;
    }

    @Override
    public void modificarCuenta() {

    }

    @Override
    public void borrarCuenta(int id) {
        try{
            Cuenta cuenta = obtenerCuenta(id);
            listaCuentas.remove(cuenta);
        } catch (Exception e){
            System.out.println("No hay cuenta para borrar");
        }
    }


    @Override
    public List<Cuenta> listarCuenta() {
        return listaCuentas;
    }

     */

}
