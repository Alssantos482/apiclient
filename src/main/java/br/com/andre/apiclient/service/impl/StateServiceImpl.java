package br.com.andre.apiclient.service.impl;

import br.com.andre.apiclient.dto.StateDto;
import br.com.andre.apiclient.mapper.StateMapper;
import br.com.andre.apiclient.model.State;
import br.com.andre.apiclient.repository.StateRepository;
import br.com.andre.apiclient.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    private StateMapper stateMapper = new StateMapper();

    @Override
    public List<StateDto> getAll(){
        return stateMapper.convertListToDto(stateRepository.findAll());
    }

    @Override
    public StateDto findById(Integer id){
        return this.stateMapper.convertToDto(stateRepository.findById(id).get());
    }

    @Override
    public StateDto save(StateDto stateDto){
        State state  = this.stateMapper.convertToEntity(stateDto);

        return stateMapper.convertToDto(stateRepository.save(state));
    }

    public StateDto save(Integer id, StateDto stateDto){
        State state = stateRepository.getOne(id);
        state.setName(stateDto.getName());
        state.setUf(stateDto.getUf());

        return stateMapper.convertToDto(state);

    }

    @Override
    public void delete(Integer id){
        stateRepository.deleteById(id);
    }

}
