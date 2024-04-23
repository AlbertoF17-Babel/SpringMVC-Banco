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
    public void cliente(Model model) {
        List<Cliente> listaClientes = clienteService.listarClientes();
        model.addAttribute("listaClientes", listaClientes);
    }

    @GetMapping(value = "/DNI/{dni}")
    public String getClienteByDNI(@PathVariable String dni, Model model){
        Cliente cliente = clienteService.buscarClienteByDni(dni);
        model.addAttribute("cliente", cliente);
        return "redirect:/cliente";
    }

    @GetMapping(value = "/{id}")
    public String getClienteByID(@PathVariable int id, Model model){
        Cliente cliente = clienteService.buscarClienteById(id);
        model.addAttribute("cliente", cliente);
        return "redirect:/cliente";
    }

    @GetMapping(value = "/email/{email}")
    public String getClienteByEmail(@PathVariable String email, Model model){
        Cliente cliente = clienteService.buscarClienteByEmail(email);
        model.addAttribute("cliente", cliente);
        return "redirect:/cliente";
    }

    @PostMapping
    public String agregarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.agregarCliente(cliente);
        return "redirect:/cliente";
    }

    @PostMapping(value = "/{id}/update")
    public String modificarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.modificarCliente(cliente);
        return "redirect:/cliente";
    }

    @PostMapping(value = "/{idCliente}/delete")
    public String eliminarCliente(@PathVariable int idCliente) {
        clienteService.eliminarCliente(idCliente);
        return "redirect:/cliente";
    }

}
