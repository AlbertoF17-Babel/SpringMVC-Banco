package es.babel.controller;

import es.babel.model.Cliente;
import es.babel.service.IClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public void listarClientes(Model model) {
        List<Cliente> listaClientes = clienteService.listarClientes();
        model.addAttribute(listaClientes);
    }

    @GetMapping(value = "/DNI/{dni}")
    public String getClienteByDNI(@PathVariable String dni){
        return "clientes";
    }

    @GetMapping(value = "/{id}")
    public String getClienteByID(@PathVariable int id){
        return "clientes";
    }

    @GetMapping(value = "/email/{email}")
    public String getClienteByEmail(@PathVariable String email){
        return "clientes";
    }

    @PostMapping
    public String agregarCliente(@RequestBody Cliente cliente) {
        clienteService.agregarCliente(cliente);
        return "clientes";
    }

    @PostMapping(value = "/{id}/update")
    public String modificarCliente(@RequestBody Cliente cliente) {
        clienteService.modificarCliente(cliente);
        return "clientes";
    }

    @PostMapping(value = "/{id}/delete")
    public String eliminarCliente(@PathVariable int idCliente) {
        clienteService.eliminarCliente(idCliente);
        return "clientes";
    }

}
