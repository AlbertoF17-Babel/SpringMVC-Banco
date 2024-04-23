package es.babel.service;

import es.babel.model.Cliente;
import es.babel.repository.IClienteDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private final IClienteDB clienteDB;

    private final ISucursalService sucursalService;

    public ClienteService(IClienteDB clienteDB, ISucursalService sucursalService) {
        this.clienteDB = clienteDB;
        this.sucursalService = sucursalService;
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientesList =  this.clienteDB.listarClientes();

        for (Cliente cliente : clientesList) {
            cliente.setSucursalPrincipal(sucursalService.detalleSucursal(cliente.getSucursalPrincipalId()));
        }
        return clientesList;
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
    public void modificarCliente(Cliente cliente) {
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
            }
        }
    }
}
