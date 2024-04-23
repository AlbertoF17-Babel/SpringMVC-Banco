package es.babel.service;

import es.babel.model.Cliente;
import es.babel.model.Cuenta;
import es.babel.repository.ClienteDB;
import es.babel.repository.CuentaDB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaService implements ICuentaService {

    private final CuentaDB cuentaDB;
    private final ClienteDB clienteDB;
    List<Cuenta> listaCuentasUsuario;

    public CuentaService(CuentaDB cuentaDB, ClienteDB clienteDB) {
        this.cuentaDB = cuentaDB;
        this.clienteDB = clienteDB;
    }

    @Override
    public List<Cuenta> obtenerCuentas(int idCliente) {
        List<Cuenta> listaCuentasTotales = cuentaDB.listarCuenta();
        List<Cliente> listaClientes = clienteDB.listarClientes();
        this.listaCuentasUsuario = null;


        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                for (Cuenta cuenta : listaCuentasTotales) {
                    if (cliente.getId() == cuenta.getIdUsuario()) {
                        this.listaCuentasUsuario.add(cuenta);
                        return listaCuentasTotales;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Cuenta agregarCuenta(Cuenta cuenta) {
        cuentaDB.agregarCuenta(cuenta);
    }

    @Override
    public void modificarCuenta(int idCuenta) {
        cuentaDB.modificarCuenta(idCuenta);
    }

    @Override
    public void borrarCuenta(int idCuenta) {
        cuentaDB.borrarCuenta(idCuenta);
    }

    @Override
    public List<Cuenta> listarCuenta() {
        return cuentaDB.listarCuenta();
    }
}
