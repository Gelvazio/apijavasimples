package com.company.nomeprojeto.tarefas.facade;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefasFacade {
    private static final Map<Long, TarefaDTO> tarefas = new HashMap<>();

    public TarefaDTO criar(TarefaDTO tarefaDTO){
        // Total de tarefas + 1
        Long proximoId = tarefas.keySet().size() + 1L;
        tarefaDTO.setId(proximoId);
        tarefas.put(proximoId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTO atualizar(TarefaDTO tarefaDTO, Long tarefaId){
        // Atualiza a tarefa com o id atual
        tarefas.put(tarefaId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTO findById(Long tarefaId){
        // Retorna a tarefa com o id passado por parametro
        return tarefas.get(tarefaId);
    }

    public List<TarefaDTO> getAll(){
        return new ArrayList<>(tarefas.values());
    }

    public String delete(Long tarefaId){
        tarefas.remove(tarefaId);
        return "DELETED";
    }

    public Map<Long, TarefaDTO> getAllTarefas(){
        return tarefas;
    }
}
