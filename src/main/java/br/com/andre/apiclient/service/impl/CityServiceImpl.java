package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.model.City;
import br.com.andre.apiclient.repository.CityRepository;
import br.com.andre.apiclient.service.CityService;
import br.com.andre.apiclient.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateService stateService;

    @Override
    public Page<City> getAll(Pageable page){
        return cityRepository.findAll(page);
    }

    @Override
    public City findById(Integer id){
        return cityRepository.findById(id).get();
    }

    @Override
    public City save(City city){
        city.setState(stateService.findById(city.getState().getId()));

        return cityRepository.save(city);
    }

    public City save(Integer id, City city){
        city.setId(id);
        city.setState(stateService.findById(city.getState().getId()));

        return cityRepository.save(city);
    }

    @Override
    public void delete(Integer id){
        cityRepository.deleteById(id);
    }
}
