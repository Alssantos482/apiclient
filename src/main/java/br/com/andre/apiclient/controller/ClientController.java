package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.dto.ClientDto;
import br.com.andre.apiclient.mapper.ClientMapper;
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

    private ClientMapper clientMapper = new ClientMapper();

    @GetMapping
    public List<ClientDto> getAll() {
        return clientMapper.convertListToDto(clientService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ClientDto findById(@PathVariable Integer id) {
        return clientMapper.convertToDto(clientService.findById(id));
    }

    @Transactional
    @PostMapping
    public ClientDto add(@RequestBody ClientDto clientDto) {
        Client client = clientMapper.convertToEntity(clientDto);

        return clientMapper.convertToDto(clientService.save(client));
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ClientDto update(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        Client client = clientMapper.convertToEntity(clientDto);

        return clientMapper.convertToDto(clientService.save(id,client));
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.delete(id);
    }

}
