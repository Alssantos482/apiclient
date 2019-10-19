package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.model.Client;
import br.com.andre.apiclient.repository.ClientRepository;
import br.com.andre.apiclient.service.AddressService;
import br.com.andre.apiclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressService addressService;

    @Override
    public Page<Client> getAll(Pageable page){
        return clientRepository.findAll(page);
    }

    @Override
    public Client findById(Integer id){
        Optional<Client> value = clientRepository.findById(id);
        return value.isPresent() ? value.get() : null;
    }

    @Override
    public Client save(Client client){
        client.setAddress(addressService.findById(client.getAddress().getId()));

        return clientRepository.save(client);
    }

    public Client save(Integer id, Client client) {
        client.setId(id);
        client.setAddress(addressService.findById(client.getAddress().getId()));

        return clientRepository.save(client);
    }

    @Override
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
}
