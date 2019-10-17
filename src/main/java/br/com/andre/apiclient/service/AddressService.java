package br.com.andre.apiclient.service;

import br.com.andre.apiclient.dto.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAll();

    AddressDto findById(Integer id);

    AddressDto save(AddressDto addressDto);

    AddressDto save(Integer id, AddressDto addressDto);

    void delete(Integer id);

}
