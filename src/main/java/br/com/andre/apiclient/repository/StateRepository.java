package br.com.andre.apiclient.repository;

import br.com.andre.apiclient.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
