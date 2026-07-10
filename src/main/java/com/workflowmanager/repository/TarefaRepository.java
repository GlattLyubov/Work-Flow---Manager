package com.workflowmanager.repository;

import com.workflowmanager.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // Método customizado para buscar tarefas por status na tela de logística
    List<Tarefa> findByStatus(String status);
}
