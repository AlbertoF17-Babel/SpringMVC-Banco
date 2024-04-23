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
        List<Cliente> listaClientes = clienteDB.listarClientes();
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente buscarClienteById(int id) {
        List<Cliente> listaClientes = clienteDB.listarClientes();
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente buscarClienteByEmail(String email) {
        List<Cliente> listaClientes = clienteDB.listarClientes();
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equals(email)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        boolean exists = clienteDB.listarClientes().stream().anyMatch(e -> e.getDni().equals(cliente.getDni()));
        if (!exists) {
            clienteDB.listarClientes().add(cliente);
        }
        return null;
    }

    @Override
    public void eliminarCliente(int idCliente) {
        clienteDB.listarClientes().removeIf(cliente -> cliente.getId() == idCliente);;
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
