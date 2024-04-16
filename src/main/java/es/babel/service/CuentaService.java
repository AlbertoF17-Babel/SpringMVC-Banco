package es.babel.service;

import es.babel.model.Cuenta;
import es.babel.repository.ClienteDB;
import es.babel.repository.CuentaDB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaService implements ICuentaService {

    private final CuentaDB cuentaDB;
    private final ClienteDB clienteDB;

    public CuentaService(CuentaDB cuentaDB, ClienteDB clienteDB) {
        this.cuentaDB = cuentaDB;
        this.clienteDB = clienteDB;
    }

/*
    @Override
    public Cuenta obtenerCuenta(int id, int idCliente) {
        return cuentaDB.obtenerCuenta(id, idCliente);
    }

    @Override
    public Cuenta agregarCuenta(Cuenta cuenta, int idCliente) {
        return cuentaDB.agregarCuenta(cuenta, idCliente);
    }


 */
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
        cuentaDB.modificarCuenta();
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
    public void borrarCuenta(int id, int idCliente) {
        cuentaDB.borrarCuenta(id, idCliente);
    }

    @Override
    public List<Cuenta> listarCuenta(int idCliente) {
        return cuentaDB.listarCuenta(idCliente);
    }

     */
}
