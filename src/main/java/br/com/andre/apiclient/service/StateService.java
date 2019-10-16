package br.com.andre.apiclient.service;

import br.com.andre.apiclient.dto.StateDto;

import java.util.List;

public interface StateService {

    List<StateDto> getAll();

    StateDto findById(Integer id);

    StateDto save(StateDto stateDto);

    StateDto save(Integer id, StateDto stateDto);

    void delete(Integer id);

}
