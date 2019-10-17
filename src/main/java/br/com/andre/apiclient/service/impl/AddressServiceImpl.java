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

    private AddressMapper addressMapper = new AddressMapper();

    @Override
    public List<AddressDto> getAll(){
        return addressMapper.convertListToDto(addressRepository.findAll());
    }

    @Override
    public AddressDto findById(Integer id){
        return this.addressMapper.convertToDto(addressRepository.findById(id).get());
    }

    @Override
    public AddressDto save(AddressDto addressDto){
        Address address  = this.addressMapper.convertToEntity(addressDto);

        return addressMapper.convertToDto(addressRepository.save(address));
    }

    public AddressDto save(Integer id, AddressDto addressDto){
        Address address = addressRepository.getOne(id);
        address.setStreet(addressDto.getStreet());
        address.setNumber(addressDto.getNumber());
        address.setDistrict(addressDto.getDistrict());
        address.setComplement(addressDto.getComplement());
        address.setCity(new CityMapper().convertToEntity(addressDto.getCity()));

        return addressMapper.convertToDto(address);

    }

    @Override
    public void delete(Integer id){
        addressRepository.deleteById(id);
    }
}
