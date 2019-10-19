package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.model.Address;
import br.com.andre.apiclient.repository.AddressRepository;
import br.com.andre.apiclient.service.AddressService;
import br.com.andre.apiclient.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityService cityService;

    @Override
    public Page<Address> getAll(Pageable page){
        return addressRepository.findAll(page);
    }

    @Override
    public Address findById(Integer id){
        Optional<Address> value = addressRepository.findById(id);
        return value.isPresent() ? value.get() : null;
    }

    @Override
    public Address save(Address address){
        address.setCity(cityService.findById(address.getCity().getId()));

        return addressRepository.save(address);
    }

    public Address save(Integer id, Address address) {
        address.setId(id);
        address.setCity(cityService.findById(address.getCity().getId()));

        return addressRepository.save(address);
    }

    @Override
    public void delete(Integer id){
        addressRepository.deleteById(id);
    }
}
