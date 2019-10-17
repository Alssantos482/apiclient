package br.com.andre.apiclient.service;

import br.com.andre.apiclient.dto.ClientDto;
import br.com.andre.apiclient.model.Client;

import java.util.List;


public interface ClientService {

    List<ClientDto> getAll();

    ClientDto findById(Integer id);

    ClientDto save(ClientDto clientDto);

    ClientDto save(Integer id, ClientDto clientDto);

    void delete(Integer id);



}
