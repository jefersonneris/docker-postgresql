package com.devneutro.dockerpostgres.service;

import com.devneutro.dockerpostgres.dto.TarefaDTO;
import com.devneutro.dockerpostgres.model.Tarefa;
import com.devneutro.dockerpostgres.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaDTO criar (TarefaDTO tarefaDTO){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefaRepository.save(tarefa);
        tarefaDTO.setId(tarefa.getId());
        return tarefaDTO;
    }

    public TarefaDTO atualizar (TarefaDTO tarefaDTO, Long id){
        Tarefa tarefaDatabase = tarefaRepository.getOne(id);
        tarefaDatabase.setTitulo(tarefaDTO.getTitulo());
        tarefaDatabase.setDescricao(tarefaDTO.getDescricao());
        return tarefaDTO;
    }

    private TarefaDTO converter (Tarefa tarefa){
        TarefaDTO result = new TarefaDTO();
        result.setId(tarefa.getId());
        result.setTitulo(tarefa.getTitulo());
        result.setDescricao(tarefa.getDescricao());
        return result;
    }

    public List<TarefaDTO> getAll(){
        return tarefaRepository.findAll().stream().map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long id){
        tarefaRepository.deleteById(id);
        return "DELETE";
    }

}
