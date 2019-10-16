package br.com.andre.apiclient.repository;

import br.com.andre.apiclient.model.City;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRepository extends JpaRepository<City, Integer> {

}
