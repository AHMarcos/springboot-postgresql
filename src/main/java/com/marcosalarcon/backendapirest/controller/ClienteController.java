package com.marcosalarcon.backendapirest.controller;

import com.marcosalarcon.backendapirest.model.Cliente;
import com.marcosalarcon.backendapirest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/cliente")
    public List<Cliente> findAll() {return service.getCliente();}

    @GetMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente findById(@PathVariable Integer id){
        return service.getClientesById(id);
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        cliente.setCreateAt(LocalDateTime.now());
        cliente.setIp(cliente.getIp());
        return service.save(cliente);
    }

    @PutMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Integer id){
        Cliente clienteUpdate = service.getClientesById(id);

        clienteUpdate.setNombre(cliente.getNombre());
        clienteUpdate.setApellido(cliente.getApellido());
        clienteUpdate.setEmail(cliente.getEmail());

        return service.save(clienteUpdate);
    }

    @DeleteMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.deleteCliente(id);
    }


}
