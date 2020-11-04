package br.com.fabricadeprogramador.apiweb.controller;

import br.com.fabricadeprogramador.apiweb.model.Cliente;
import br.com.fabricadeprogramador.apiweb.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.POST, value ="/clientes",
                        consumes = MediaType.APPLICATION_JSON_VALUE,
                        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cadastar(@RequestBody Cliente cliente) {
        clienteService.salvar(cliente);
        System.out.println("Cliente: " + cliente.toString() + " cadastrado com sucesso!");
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/clientes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> selecionarTodosClientes(){
        Collection<Cliente> clientes = clienteService.buscarTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> deletarCliente(@PathVariable int id) {
        Cliente cliente = clienteService.buscarPorId(id);
        if(cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clienteService.excluir(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/clientes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente) {
        Cliente result = clienteService.buscarPorId(cliente.getId());
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clienteService.salvar(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}",
                        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> selecionarPorId(@PathVariable int id) {
        Cliente result = clienteService.buscarPorId(id);
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

