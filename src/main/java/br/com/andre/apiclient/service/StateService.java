package br.com.andre.apiclient.service;

import br.com.andre.apiclient.model.State;

import java.util.List;

public interface StateService {

    List<State> getAll();

    State findById(Integer id);

    State save(State state);

    State save(Integer id, State state);

    void delete(Integer id);

}
