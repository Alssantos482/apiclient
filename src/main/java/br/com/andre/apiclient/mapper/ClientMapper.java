package br.com.andre.apiclient.mapper;

import br.com.andre.apiclient.dto.ClientDto;
import br.com.andre.apiclient.model.Client;

public class ClientMapper  {

    public Client convertToEntity(ClientDto clientDto) {
        Client client = new Client();

        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setCpf(clientDto.getCpf());
        client.setBirthDate(clientDto.getBirthDate());



        return client;
    }

    public ClientDto convertToDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setCpf(client.getCpf());
        clientDto.setBirthDate(client.getBirthDate());



        return clientDto;
    }
}
