package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.dto.CityDto;
import br.com.andre.apiclient.model.City;
import br.com.andre.apiclient.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RequestMapping(value = "/cities")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<CityDto> getAll() {
        return cityService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CityDto findById(@PathVariable Integer id) {
        return cityService.findById(id);
    }

    @Transactional
    @PostMapping
    public CityDto add(@RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public CityDto update(@PathVariable Integer id, @RequestBody CityDto cityDto) {
        return cityService.save(id,cityDto);
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        cityService.delete(id);
    }
}
