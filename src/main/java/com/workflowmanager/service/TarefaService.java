package com.workflowmanager.service;

import com.workflowmanager.model.Tarefa;
import com.workflowmanager.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // Listar todas as tarefas
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    // Listar tarefas por status (para o nosso Kanban)
    public List<Tarefa> listarPorStatus(String status) {
        return tarefaRepository.findByStatus(status);
    }

    // Salvar ou atualizar uma tarefa
    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // Buscar uma tarefa pelo ID
    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    // Deletar uma tarefa
    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }

}
