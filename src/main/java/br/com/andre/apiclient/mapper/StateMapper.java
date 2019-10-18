package br.com.andre.apiclient.mapper;

import br.com.andre.apiclient.dto.StateDto;
import br.com.andre.apiclient.model.State;
import org.springframework.data.domain.Page;

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

    public Page<StateDto> convertPageToDto(Page<State> states){
        return states.map(this::convertToDto);
    }
}
