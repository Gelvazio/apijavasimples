package com.company.nomeprojeto.tarefas.api;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import com.company.nomeprojeto.tarefas.facade.TarefasFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI {
    // Realiza a injeção de dependencia da outra classe
    @Autowired
    private TarefasFacade tarefasFacade;

    @PostMapping  // Recebe uma requisição POST
    @ResponseBody // Devolve um arquivo JSON
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO){
        return tarefasFacade.criar(tarefaDTO);
    }

    @PutMapping("/{tarefaId}") // Recebe o id da tarefa por parametro da URL na requisição PUT
    @ResponseBody // Devolve um arquivo JSON
    public TarefaDTO atualizar(@PathVariable("tarefaId")Long tarefaId,
                               @RequestBody TarefaDTO tarefaDTO){
        return tarefasFacade.atualizar(tarefaDTO, tarefaId);
    }

    @GetMapping("/{tarefaId}") // Recebe uma requisição GET, com um id por parametro
    @ResponseBody // Devolve um arquivo JSON
    public List<TarefaDTO> getAll(@PathVariable("tarefaId")Long tarefaId){
        TarefaDTO tarefaData = tarefasFacade.findById(tarefaId);
        List <TarefaDTO> tarefaAtual = new ArrayList<>();
        if(tarefaData != null){
            if (tarefaData.getId() > 0) {
                tarefaAtual.add(tarefaData);
            }
        }

        return tarefaAtual;
    }

    @GetMapping // Recebe uma requisição GET
    @ResponseBody // Devolve um arquivo JSON
    public List<TarefaDTO> getAll(){
        return tarefasFacade.getAll();
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId){
        return tarefasFacade.delete(tarefaId);
    }

}
