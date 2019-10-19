package br.com.andre.apiclient.service;

import br.com.andre.apiclient.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AddressService {

    Page<Address> getAll(Pageable page);

    Address findById(Integer id);

    Address save(Address addressDto);

    Address save(Integer id, Address address);

    void delete(Integer id);

}
