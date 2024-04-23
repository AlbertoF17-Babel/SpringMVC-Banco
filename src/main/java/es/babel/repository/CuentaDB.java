package es.babel.repository;

import es.babel.model.Cliente;
import es.babel.model.Cuenta;
import es.babel.model.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaDB implements ICuentaDB {

    List<Cuenta> listaCuentas;

    @Override
    public Cuenta obtenerCuenta(int id) {
        Cuenta cuentaObtenida = null;
        for (Cuenta cuenta: listaCuentas) {
            if (id == cuenta.getId()) {
                cuentaObtenida = cuenta;
                break;
            }
        }
        return cuentaObtenida;
    }

    @Override
    public void agregarCuenta(Cuenta cuenta) {
        listaCuentas.add(cuenta);
    }

    @Override
    public void modificarCuenta(int id) {
        Cuenta cuentaAModificar = obtenerCuenta(id);
    }

    @Override
    public void borrarCuenta(int id) {
        try{
         Cuenta cuentaABorrar = obtenerCuenta(id);
         listaCuentas.remove(cuentaABorrar);
        } catch (Exception e){
            System.out.println("No hay cuenta que borrar");
        }
    }

    @Override
    public List<Cuenta> listarCuenta() {
        return listaCuentas;
    }

}
