package com.marcosalarcon.backendapirest.service;

import com.marcosalarcon.backendapirest.model.Cliente;
import com.marcosalarcon.backendapirest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getCliente(){
        return  repository.findAll();
    }

    public Cliente getClientesById(Integer id) { return repository.findById(id).orElse(null);}

    public Cliente save(Cliente cliente) { return repository.save(cliente);}

    public String deleteCliente(Integer id) { repository.deleteById(id); return "cliente removed! "+id;}

}
