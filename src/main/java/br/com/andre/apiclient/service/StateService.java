package br.com.andre.apiclient.service;

import br.com.andre.apiclient.model.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StateService {

    Page<State> getAll(Pageable page);

    State findById(Integer id);

    State save(State state);

    State save(Integer id, State state);

    void delete(Integer id);

}
