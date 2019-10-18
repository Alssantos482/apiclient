package br.com.andre.apiclient.service;

import br.com.andre.apiclient.dto.ClientDto;
import br.com.andre.apiclient.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ClientService {

    Page<Client> getAll(Pageable page);

    Client findById(Integer id);

    Client save(Client client);

    Client save(Integer id, Client client);

    void delete(Integer id);

}
