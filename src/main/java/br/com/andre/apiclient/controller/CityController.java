package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.dto.CityDto;
import br.com.andre.apiclient.mapper.CityMapper;
import br.com.andre.apiclient.model.City;
import br.com.andre.apiclient.service.CityService;
import br.com.andre.apiclient.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/cities")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private StateService stateService;

    private CityMapper cityMapper = new CityMapper();

    @GetMapping
    public Page<CityDto> getAll(Pageable page) {
        return cityMapper.convertPageToDto(cityService.getAll(page));
    }

    @GetMapping(value = "/{id}")
    public CityDto findById(@PathVariable Integer id) {
        return cityMapper.convertToDto(cityService.findById(id));
    }

    @Transactional
    @PostMapping
    public CityDto add(@RequestBody CityDto cityDto) {
        City city = cityMapper.convertToEntity(cityDto);

        return cityMapper.convertToDto(cityService.save(city));
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public CityDto update(@PathVariable Integer id, @RequestBody CityDto cityDto) {

        City city = cityService.save(id, cityMapper.convertToEntity(cityDto));

        return cityMapper.convertToDto(city);
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        cityService.delete(id);
    }
}
