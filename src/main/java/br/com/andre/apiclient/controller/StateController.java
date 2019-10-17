package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.dto.StateDto;
import br.com.andre.apiclient.mapper.StateMapper;
import br.com.andre.apiclient.model.State;
import br.com.andre.apiclient.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/states")
@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    private StateMapper stateMapper = new StateMapper();

    @GetMapping
    public List<StateDto> getAll() {
        return stateMapper.convertListToDto(stateService.getAll());
    }

    @GetMapping(value = "/{id}")
    public StateDto findById(@PathVariable Integer id) {
        return stateMapper.convertToDto(stateService.findById(id));
    }

    @Transactional
    @PostMapping
    public StateDto add(@RequestBody StateDto stateDto) {
        State state = stateMapper.convertToEntity(stateDto);

        return stateMapper.convertToDto(stateService.save(state));
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public StateDto update(@PathVariable Integer id,
                           @RequestBody StateDto stateDto) {
        State state = stateMapper.convertToEntity(stateDto);

        return stateMapper.convertToDto(stateService.save(id, state));
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        stateService.delete(id);
    }



}
