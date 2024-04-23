package es.babel.service;

import es.babel.model.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> listarClientes();

    Cliente buscarClienteByDni(String dni);

    Cliente buscarClienteById(int id);

    Cliente buscarClienteByEmail(String email);

    Cliente agregarCliente(Cliente cliente);

    void eliminarCliente(int idCliente);

    Cliente modificarCliente(Cliente cliente);
}
