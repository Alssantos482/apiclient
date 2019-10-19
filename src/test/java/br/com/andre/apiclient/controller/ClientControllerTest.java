package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.model.Address;
import br.com.andre.apiclient.model.City;
import br.com.andre.apiclient.model.Client;
import br.com.andre.apiclient.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    ClientService clientService;

    @Test
    public void TestGetAllClient() throws Exception {
        //Arrange
        Address address = new Address(0, "1", "12", "asd", "asd", new City(), null);
        Client client = new Client(0, "asd", "asd11", new Date(LocalDate.of(1994,05,06).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()), address);
        List<Client> clients = new ArrayList<>();
        clients.add(client);
        Page<Client> clientPage = new PageImpl<>(clients);

        when(clientService.getAll(Mockito.any())).thenReturn(clientPage);

        //Act
        mvc.perform(get("/clients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['content']", Matchers.hasSize(1)))
                .andExpect(jsonPath("$['content'].[0].cpf",is(client.getCpf())));

    }

    @Test
    public void TestPostClient() throws Exception {
        //Arrange
        Address address = new Address(0, "1", "12", "asd", "asd", new City(), null);
        Client client = new Client(0, "01619415240", "asd11", new Date(LocalDate.of(1994,05,06).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()), address);

        when(clientService.save(Mockito.any())).thenReturn(client);

        mvc.perform(post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(client)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['cpf']", is(client.getCpf())));

    }

}
