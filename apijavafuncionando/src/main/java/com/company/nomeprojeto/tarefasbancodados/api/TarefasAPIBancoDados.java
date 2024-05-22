package com.company.nomeprojeto.tarefasbancodados.api;

import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.nomeprojeto.tarefas.dto.TarefaDTOBancoDados;
import com.company.nomeprojeto.tarefas.facade.TarefasFacadeBancoDados;

@Controller
@RequestMapping(value="/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPIBancoDados {
    // Realiza a injeção de dependencia da outra classe
    @Autowired
    private TarefasFacadeBancoDados tarefasFacade;

    @PostMapping  // Recebe uma requisição POST
    @ResponseBody // Devolve um arquivo JSON
    public TarefaDTOBancoDados criar(@RequestBody TarefaDTOBancoDados tarefaDTO){
        return tarefasFacade.criar(tarefaDTO);
    }

    @PutMapping("/{tarefaId}") // Recebe o id da tarefa por parametro da URL na requisição PUT
    @ResponseBody // Devolve um arquivo JSON
    public TarefaDTOBancoDados atualizar(@PathVariable("tarefaId")Long tarefaId,
                                         @RequestBody TarefaDTOBancoDados tarefaDTO){
        return tarefasFacade.atualizar(tarefaDTO, tarefaId);
    }

    @GetMapping("/{tarefaId}") // Recebe uma requisição GET, com um id por parametro
    @ResponseBody // Devolve um arquivo JSON
    public List<TarefaDTOBancoDados> get(@PathVariable("tarefaId")Long tarefaId){
        TarefaDTOBancoDados tarefaData = tarefasFacade.findById(tarefaId);
        List <TarefaDTOBancoDados> tarefaAtual = new ArrayList<>();
        if(tarefaData != null){
            if (tarefaData.getId() > 0) {
                tarefaAtual.add(tarefaData);
            }
        }

        return tarefaAtual;
    }

    @GetMapping // Recebe uma requisição GET
    @ResponseBody // Devolve um arquivo JSON
    public List<TarefaDTOBancoDados> getAll(){
        return tarefasFacade.getAll();
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId){
        return tarefasFacade.delete(tarefaId);
    }

}
