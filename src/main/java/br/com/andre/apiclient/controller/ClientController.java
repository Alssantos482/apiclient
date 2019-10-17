package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.dto.ClientDto;
import br.com.andre.apiclient.model.Client;
import br.com.andre.apiclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/clients")
@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDto> getAll() {
        return clientService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ClientDto findById(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    @Transactional
    @PostMapping
    public ClientDto add(@RequestBody ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ClientDto update(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        return clientService.save(id,clientDto);
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.delete(id);
    }

}
