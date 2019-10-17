package br.com.andre.apiclient.repository;

import br.com.andre.apiclient.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
