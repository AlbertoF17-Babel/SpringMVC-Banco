package es.babel.service;

import es.babel.model.Cliente;
import es.babel.model.Cuenta;
import es.babel.repository.ClienteDB;
import es.babel.repository.CuentaDB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaService implements ICuentaService {


    private int lastId = 1;
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
        cuenta.setId(lastId++);
        cuentaDB.listarCuenta().add(cuenta);
    }

    @Override
    public void modificarCuenta(Cuenta cuenta) {
        for (Cuenta cuentaListado : cuentaDB.listarCuenta()) {
            //if()
        }

        //Cuenta cuentaAModificar = obtenerCuenta(cuenta);

        /*
        for (Cliente clienteListado : clienteDB.listarClientes()) {
            if (clienteListado.getDni().equalsIgnoreCase(cliente.getDni()) || clienteListado.getEmail().equalsIgnoreCase(cliente.getEmail())
                    || clienteListado.getId() == cliente.getId()) {
                if (cliente.getDireccionPostal() != 0){
                    clienteListado.setDireccionPostal(cliente.getDireccionPostal());
                }
                if (!cliente.getEmail().isEmpty()){
                    clienteListado.setEmail(cliente.getEmail());
                }
                if (!cliente.getTelefono().isEmpty()){
                    clienteListado.setTelefono(cliente.getTelefono());
                }
                if (cliente.getSucursalPrincipalId() != 0){
                    clienteListado.setSucursalPrincipalId(cliente.getSucursalPrincipalId());
                    clienteListado.setSucursalPrincipal(cliente.getSucursalPrincipal());
                }
                if (cliente.getCuentasAsociadas() != null){
                    clienteListado.setCuentasAsociadas(cliente.getCuentasAsociadas());
                }

         */

    }

    @Override
    public void borrarCuenta(Cuenta cuenta) {
        try {
            cuentaDB.listarCuenta().remove(cuenta);
        } catch (Exception e) {
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
        for (Cuenta cuenta : cuentaDB.listarCuenta()) {
            if (id == cuenta.getId()) {
                cuentaObtenida = cuenta;
                break;
            }
        }
        return cuentaObtenida;
    }
}
