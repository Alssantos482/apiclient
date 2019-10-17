package br.com.andre.apiclient.mapper;

import br.com.andre.apiclient.dto.StateDto;
import br.com.andre.apiclient.model.State;

import java.util.List;
import java.util.stream.Collectors;

public class StateMapper {

    public State convertToEntity(StateDto stateDto) {
        State state = new State();

        state.setId(stateDto.getId());
        state.setName(stateDto.getName());
        state.setInitials(stateDto.getInitials());

        return state;
    }

    public StateDto convertToDto(State state) {
        StateDto stateDto = new StateDto();

        stateDto.setId(state.getId());
        stateDto.setName(state.getName());
        stateDto.setInitials(state.getInitials());

        return stateDto;
    }

    public List<StateDto> convertListToDto(List<State> states){
        return states.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
