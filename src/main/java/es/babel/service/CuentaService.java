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
    public void agregarCuenta(Cuenta cuenta) {
        cuentaDB.listarCuenta().add(cuenta);
    }

    @Override
    public void modificarCuenta(int idCuenta) {
        Cuenta cuentaAModificar = obtenerCuenta(idCuenta);
    }

    @Override
    public void borrarCuenta(int idCuenta) {
        try{
            Cuenta cuentaABorrar = obtenerCuenta(idCuenta);
            cuentaDB.listarCuenta().remove(cuentaABorrar);
        } catch (Exception e){
            System.out.println("No hay cuenta que borrar");
        }
    }

    @Override
    public List<Cuenta> listarCuenta() {
        return cuentaDB.listarCuenta();
    }

    @Override
    public Cuenta obtenerCuenta(int id) {
        Cuenta cuentaObtenida = null;
        for (Cuenta cuenta: cuentaDB.listarCuenta()) {
            if (id == cuenta.getId()) {
                cuentaObtenida = cuenta;
                break;
            }
        }
        return cuentaObtenida;
    }
}
