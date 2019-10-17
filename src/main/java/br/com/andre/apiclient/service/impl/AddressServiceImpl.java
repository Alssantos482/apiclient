package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.dto.AddressDto;
import br.com.andre.apiclient.mapper.AddressMapper;
import br.com.andre.apiclient.mapper.CityMapper;
import br.com.andre.apiclient.model.Address;
import br.com.andre.apiclient.repository.AddressRepository;
import br.com.andre.apiclient.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

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
        return addressRepository.save(address);
    }

    public Address save(Integer id, Address address){
        Address addressNew = addressRepository.getOne(id);
        addressNew.setStreet(address.getStreet());
        addressNew.setNumber(address.getNumber());
        addressNew.setDistrict(address.getDistrict());
        addressNew.setComplement(address.getComplement());
        addressNew.setCity(address.getCity());

        return address;

    }

    @Override
    public void delete(Integer id){
        addressRepository.deleteById(id);
    }
}
