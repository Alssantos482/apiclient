package br.com.andre.apiclient.mapper;

import br.com.andre.apiclient.dto.CityDto;
import br.com.andre.apiclient.model.City;
import org.springframework.data.domain.Page;


public class  CityMapper {

    public City convertToEntity(CityDto cityDto) {
        City city = new City();

        city.setId(cityDto.getId());
        city.setName(cityDto.getName());

        if (cityDto.getState() != null) {
            city.setState(new StateMapper().convertToEntity(cityDto.getState()));
        }

        return city;
    }

    public CityDto convertToDto(City city) {
        CityDto cityDto = new CityDto();

        cityDto.setId(city.getId());
        cityDto.setName(city.getName());

        if (city.getState() != null) {
            cityDto.setState(new StateMapper().convertToDto(city.getState()));
        }

        return cityDto;
    }

    public Page<CityDto> convertPageToDto(Page<City> cities){
        return cities.map(this::convertToDto);
    }

}
