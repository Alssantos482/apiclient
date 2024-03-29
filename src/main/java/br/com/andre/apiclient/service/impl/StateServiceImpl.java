package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.mapper.StateMapper;
import br.com.andre.apiclient.model.State;
import br.com.andre.apiclient.repository.StateRepository;
import br.com.andre.apiclient.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    private StateMapper stateMapper = new StateMapper();

    @Override
    public Page<State> getAll(Pageable page){
        return stateRepository.findAll(page);
    }

    @Override
    public State findById(Integer id){
        Optional<State> value = stateRepository.findById(id);
        return value.isPresent() ? value.get() : null;
    }

    @Override
    public State save(State state){

        return stateRepository.save(state);
    }

    public State save(Integer id, State state){
        state.setId(id);

        return stateRepository.save(state);

    }

    @Override
    public void delete(Integer id){
        stateRepository.deleteById(id);
    }

}
