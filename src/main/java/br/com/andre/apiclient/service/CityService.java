package br.com.andre.apiclient.service;

import br.com.andre.apiclient.model.City;

import java.util.List;

public interface CityService {

    List<City> getAll();

    City findById(Integer id);

    City save(City city);

    void delete(Integer id);
}
