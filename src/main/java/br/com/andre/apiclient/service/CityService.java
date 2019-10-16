package br.com.andre.apiclient.service;

import br.com.andre.apiclient.dto.CityDto;

import java.util.List;

public interface CityService {

    List<CityDto> getAll();

    CityDto findById(Integer id);

    CityDto save(CityDto cityDto);

    CityDto save(Integer id, CityDto cityDto);

    void delete(Integer id);
}
