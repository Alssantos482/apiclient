package br.com.andre.apiclient.service;

import br.com.andre.apiclient.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();

    Address findById(Integer id);

    Address save(Address addressDto);

    Address save(Integer id, Address address);

    void delete(Integer id);

}
