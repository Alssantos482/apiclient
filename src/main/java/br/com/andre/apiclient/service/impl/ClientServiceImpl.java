package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.dto.ClientDto;
import br.com.andre.apiclient.mapper.ClientMapper;
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

    private ClientMapper clientMapper = new ClientMapper();

    @Override
    public List<ClientDto> getAll(){
        return clientMapper.convertListToDto(clientRepository.findAll());
    }

    @Override
    public ClientDto findById(Integer id){
        return this.clientMapper.convertToDto(clientRepository.findById(id).get());
    }

    @Override
    public ClientDto save(ClientDto clientDto){
        Client client  = this.clientMapper.convertToEntity(clientDto);

        return clientMapper.convertToDto(clientRepository.save(client));
    }

    public ClientDto save(Integer id, ClientDto clientDto){
        Client client = clientRepository.getOne(id);
        client.setName(clientDto.getName());

        return clientMapper.convertToDto(client);

    }

    @Override
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
}
