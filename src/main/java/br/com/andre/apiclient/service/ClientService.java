package br.com.andre.apiclient.service;

import br.com.andre.apiclient.dto.ClientDto;
import br.com.andre.apiclient.model.Client;

import java.util.List;


public interface ClientService {

    List<Client> getAll();

    Client findById(Integer id);

    Client save(Client client);

    Client save(Integer id, Client client);

    void delete(Integer id);

}
