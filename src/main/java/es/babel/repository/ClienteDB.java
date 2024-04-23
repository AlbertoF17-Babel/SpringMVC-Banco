package es.babel.repository;

import es.babel.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteDB implements IClienteDB {

    List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public List<Cliente> listarClientes() {
        return listaClientes;
    }

    @Override
    public Cliente buscarClienteById(int id) {
        List<Cliente> listaClientes = listarClientes();
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente buscarClienteByDni(String dni) {
        List<Cliente> listaClientes = listarClientes();
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente buscarClienteByEmail(String email) {
        List<Cliente> listaClientes = listarClientes();
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equals(email)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        boolean exists = listarClientes().stream().anyMatch(e -> e.getDni().equals(cliente.getDni()));
        if (!exists) {
                int idUltimoCliente = listaClientes.get(listaClientes.size()-1).getId();
                cliente.setId(idUltimoCliente+1);
        } else {
            cliente.setId(1);
        }
        listarClientes().add(cliente);
        return cliente;
    }

    @Override
    public void eliminarCliente(int idCliente) {
        listarClientes().removeIf(cliente -> cliente.getId() == idCliente);;
    }

}
