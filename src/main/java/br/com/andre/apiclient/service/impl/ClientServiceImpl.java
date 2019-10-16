package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.model.Client;
import br.com.andre.apiclient.repository.ClientRepository;
import br.com.andre.apiclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
