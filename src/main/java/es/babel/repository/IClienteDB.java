package es.babel.repository;

import es.babel.model.Cliente;

import java.util.List;

public interface IClienteDB {

    List<Cliente> listarClientes();

    Cliente buscarClienteById(int id);

    Cliente buscarClienteByDni(String dni);

    Cliente buscarClienteByEmail(String email);

    Cliente agregarCliente(Cliente cliente);

    void eliminarCliente(int idCliente);

}
