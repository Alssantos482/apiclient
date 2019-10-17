package br.com.andre.apiclient.controller;

import br.com.andre.apiclient.dto.StateDto;
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

    @GetMapping
    public List<StateDto> getAll() {
        return stateService.getAll();
    }

    @GetMapping(value = "/{id}")
    public StateDto findById(@PathVariable Integer id) {
        return stateService.findById(id);
    }

    @Transactional
    @PostMapping
    public StateDto add(@RequestBody StateDto stateDto) {
        return stateService.save(stateDto);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public StateDto update(@PathVariable Integer id,
                           @RequestBody StateDto stateDto) {
        return stateService.save(id, stateDto);
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        stateService.delete(id);
    }



}
