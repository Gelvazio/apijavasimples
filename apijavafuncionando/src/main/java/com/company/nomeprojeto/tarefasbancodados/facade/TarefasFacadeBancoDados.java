package com.company.nomeprojeto.tarefasbancodados.facade;

import com.company.nomeprojeto.tarefas.dto.TarefaDTOBancoDados;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefasFacadeBancoDados {
    private static final Map<Long, TarefaDTOBancoDados> tarefas = new HashMap<Long, TarefaDTOBancoDados>();

    public TarefaDTOBancoDados criar(TarefaDTOBancoDados tarefaDTO){
        // Total de tarefas + 1
        Long proximoId = tarefas.keySet().size() + 1L;
        tarefaDTO.setId(proximoId);
        tarefas.put(proximoId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTOBancoDados atualizar(TarefaDTOBancoDados tarefaDTO, Long tarefaId){
        // Atualiza a tarefa com o id atual
        tarefas.put(tarefaId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTOBancoDados findById(Long tarefaId){
        // Retorna a tarefa com o id passado por parametro
        return tarefas.get(tarefaId);
    }

    public List<TarefaDTOBancoDados> getAll(){
        return new ArrayList<>(tarefas.values());
    }

    public String delete(Long tarefaId){
        tarefas.remove(tarefaId);
        return "DELETED";
    }

    public Map<Long, TarefaDTOBancoDados> getAllTarefas(){
        return tarefas;
    }
}
