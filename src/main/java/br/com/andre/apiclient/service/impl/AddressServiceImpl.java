package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.dto.AddressDto;
import br.com.andre.apiclient.mapper.AddressMapper;
import br.com.andre.apiclient.mapper.CityMapper;
import br.com.andre.apiclient.model.Address;
import br.com.andre.apiclient.repository.AddressRepository;
import br.com.andre.apiclient.repository.CityRepository;
import br.com.andre.apiclient.service.AddressService;
import br.com.andre.apiclient.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityService cityService;

    @Override
    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Integer id){
        return addressRepository.findById(id).get();
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
