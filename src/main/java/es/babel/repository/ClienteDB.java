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


}
