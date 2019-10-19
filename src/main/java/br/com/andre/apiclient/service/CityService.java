package br.com.andre.apiclient.service;


import br.com.andre.apiclient.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CityService {

    Page<City> getAll(Pageable page);

    City findById(Integer id);

    City save(City city);

    City save(Integer id, City city);

    void delete(Integer id);
}
