package com.devneutro.dockerpostgres.controller;

import com.devneutro.dockerpostgres.dto.TarefaDTO;
import com.devneutro.dockerpostgres.model.Tarefa;
import com.devneutro.dockerpostgres.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @ResponseBody
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO){
        return tarefaService.criar(tarefaDTO);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public TarefaDTO atualizar(@PathVariable ("id") Long id, @RequestBody TarefaDTO tarefaDTO){
        return tarefaService.atualizar(tarefaDTO, id);
    }

    @GetMapping
    @ResponseBody
    public List<TarefaDTO> tarefaDTOList(){
        return tarefaService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deletar (@PathVariable ("id") Long id){
        return tarefaService.delete(id);
    }


}
