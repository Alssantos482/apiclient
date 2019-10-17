package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.model.City;
import br.com.andre.apiclient.repository.CityRepository;
import br.com.andre.apiclient.service.CityService;
import br.com.andre.apiclient.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateService stateService;

    @Override
    public List<City> getAll(){
        return cityRepository.findAll();
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


    @Override
    public void delete(Integer id){
        cityRepository.deleteById(id);
    }
}
