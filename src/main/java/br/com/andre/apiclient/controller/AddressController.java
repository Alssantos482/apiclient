package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.dto.AddressDto;
import br.com.andre.apiclient.mapper.AddressMapper;
import br.com.andre.apiclient.model.Address;
import br.com.andre.apiclient.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/addresses")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    private AddressMapper addressMapper = new AddressMapper();

    @GetMapping
    public Page<AddressDto> getAll(Pageable page) {
        return addressMapper.convertPageToDto(addressService.getAll(page));
    }

    @GetMapping(value = "/{id}")
    public AddressDto findById(@PathVariable Integer id) {
        return addressMapper.convertToDto(addressService.findById(id));
    }

    @Transactional
    @PostMapping
    public AddressDto add(@RequestBody AddressDto addressDto) {
        Address address = addressMapper.convertToEntity(addressDto);

        return addressMapper.convertToDto(addressService.save(address));
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public AddressDto update(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
        Address address = addressMapper.convertToEntity(addressDto);

        return addressMapper.convertToDto(addressService.save(id,address));
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }
}
