package br.com.andre.apiclient.mapper;

import br.com.andre.apiclient.dto.CityDto;
import br.com.andre.apiclient.model.City;

import java.util.List;
import java.util.stream.Collectors;

public class CityMapper {

    public City convertToEntity(CityDto cityDto) {
        City city = new City();

        city.setId(cityDto.getId());
        city.setName(cityDto.getName());

        return city;
    }

    public CityDto convertToDto(City city) {
        CityDto cityDto = new CityDto();

        cityDto.setId(city.getId());
        cityDto.setName(city.getName());

        return cityDto;
    }

    public List<CityDto> convertListToDto(List<City> cities){
        return cities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

}
