package br.com.andre.apiclient.repository;

import br.com.andre.apiclient.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAll();
}
