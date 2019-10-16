package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.dto.CityDto;
import br.com.andre.apiclient.mapper.CityMapper;
import br.com.andre.apiclient.model.City;
import br.com.andre.apiclient.repository.CityRepository;
import br.com.andre.apiclient.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    private CityMapper cityMapper = new CityMapper();

    @Override
    public List<CityDto> getAll(){
        return cityMapper.convertListToDto(cityRepository.findAll());
    }

    @Override
    public CityDto findById(Integer id){
        return this.cityMapper.convertToDto(cityRepository.findById(id).get());
    }

    @Override
    public CityDto save(CityDto cityDto){
        City city  = this.cityMapper.convertToEntity(cityDto);

        return cityMapper.convertToDto(cityRepository.save(city));
    }

    public CityDto save(Integer id, CityDto cityDto){
        City city = cityRepository.getOne(id);
        city.setName(cityDto.getName());

        return cityMapper.convertToDto(city);

    }

    @Override
    public void delete(Integer id){
        cityRepository.deleteById(id);
    }
}
