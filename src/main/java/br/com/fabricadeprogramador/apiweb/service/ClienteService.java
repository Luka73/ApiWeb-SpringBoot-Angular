package br.com.fabricadeprogramador.apiweb.service;

import br.com.fabricadeprogramador.apiweb.model.Cliente;
import br.com.fabricadeprogramador.apiweb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    /*private Map<Integer, Cliente> clientes = new HashMap<>();
    private int proximoId = 1;*/


/*    public Cliente inserirNoHashMap(Cliente cliente) {
        if(clientes == null){
            clientes = new HashMap<>();
        }

        cliente.setId(proximoId);
        clientes.put(proximoId, cliente);
        proximoId++;

        return cliente;
    }*/

/*    public Cliente alterarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
        return cliente;
    }*/

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Collection<Cliente> buscarTodos(){
        /*return clientes.values();*/
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(int id) {
       /* return clientes.get(id);*/
        return clienteRepository.findById(id).orElse(null);

    }

    public void excluir(Cliente cliente) {
        /*clientes.remove(id);*/
        clienteRepository.delete(cliente);
    }
}
