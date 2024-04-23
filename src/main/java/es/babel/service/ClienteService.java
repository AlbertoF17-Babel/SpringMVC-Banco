package es.babel.service;

import es.babel.model.Cliente;
import es.babel.repository.IClienteDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private final IClienteDB clienteDB;

    public ClienteService(IClienteDB clienteDB) {
        this.clienteDB = clienteDB;
    }

    @Override
    public List<Cliente> listarClientes() {
        return this.clienteDB.listarClientes();
    }

    @Override
    public Cliente buscarClienteByDni(String dni) {
        return this.clienteDB.buscarClienteByDni(dni);
    }

    @Override
    public Cliente buscarClienteById(int id) {
        return this.clienteDB.buscarClienteById(id);
    }

    @Override
    public Cliente buscarClienteByEmail(String email) {
        return this.clienteDB.buscarClienteByEmail(email);
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return this.clienteDB.agregarCliente(cliente);
    }

    @Override
    public void eliminarCliente(int idCliente) {
        this.clienteDB.eliminarCliente(idCliente);
    }


    @Override
    public Cliente modificarCliente(Cliente cliente) {
        for (Cliente clienteListado : clienteDB.listarClientes()) {
            if (clienteListado.getDni().equalsIgnoreCase(cliente.getDni()) || clienteListado.getEmail().equalsIgnoreCase(cliente.getEmail())
                    || clienteListado.getId() == cliente.getId()) {
                return cliente;
            }
        }
        return cliente;
    }
}
