package br.com.andre.apiclient.mapper;


import br.com.andre.apiclient.dto.ClientDto;
import br.com.andre.apiclient.model.Client;
import org.springframework.data.domain.Page;


public class ClientMapper  {

    public Client convertToEntity(ClientDto clientDto) {
        Client client = new Client();

        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setCpf(clientDto.getCpf());
        client.setBirthDate(clientDto.getBirthDate());

        if (clientDto.getAddress() != null) {
            client.setAddress(
                    new AddressMapper().convertToEntity(clientDto.getAddress())
            );
        }

        return client;
    }

    public ClientDto convertToDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setCpf(client.getCpf());
        clientDto.setBirthDate(client.getBirthDate());

        if (client.getAddress() != null) {
            clientDto.setAddress(
                    new AddressMapper().convertToDto(client.getAddress())
            );
        }

        return clientDto;
    }

    public Page<ClientDto> convertPageToDto(Page<Client> clients){
        return clients.map(this::convertToDto);
    }
}
