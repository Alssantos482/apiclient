package br.com.andre.apiclient.service;

import br.com.andre.apiclient.model.Address;
import br.com.andre.apiclient.model.City;
import br.com.andre.apiclient.model.Client;
import br.com.andre.apiclient.repository.ClientRepository;
import javafx.beans.binding.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @MockBean
    AddressService addressService;

    @MockBean
    ClientRepository clientRepository;

    @Test
    public void TestSaveClient () {
        //Arrange
        Address address = new Address(0, "1", "12", "asd", "asd", new City(), null);
        Client client = new Client(0, "asd", "asd",LocalDate.of(1994,05,06), address);
        Client clientSaved = null;

        when(addressService.findById(Mockito.any())).thenReturn(address);
        when(clientRepository.save(Mockito.any())).thenReturn(client);

        //Act
        clientSaved = clientService.save(client);


        //Assertion
        assertThat(clientSaved.getCpf()).isEqualTo(client.getCpf());

    }
}
