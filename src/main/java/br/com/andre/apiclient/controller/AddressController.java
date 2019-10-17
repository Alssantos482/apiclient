package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.dto.AddressDto;
import br.com.andre.apiclient.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/addresses")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.getAll();
    }

    @GetMapping(value = "/{id}")
    public AddressDto findById(@PathVariable Integer id) {
        return addressService.findById(id);
    }

    @Transactional
    @PostMapping
    public AddressDto add(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public AddressDto update(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
        return addressService.save(id,addressDto);
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }
}
