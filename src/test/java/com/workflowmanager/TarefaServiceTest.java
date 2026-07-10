package com.workflowmanager;

import com.workflowmanager.model.Tarefa;
import com.workflowmanager.repository.TarefaRepository;
import com.workflowmanager.service.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarTarefaComSucesso() {
        // Cenario
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Testar API");
        tarefa.setStatus("A Fazer");

        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        // Acao
        Tarefa tarefaSalva = tarefaService.salvar(tarefa);

        // Verificacao
        assertNotNull(tarefaSalva);
        assertEquals("Testar API", tarefaSalva.getTitulo());
        verify(tarefaRepository, times(1)).save(tarefa);
    }

    @Test
    void deveFiltrarTarefasPorStatus() {
        // Cenario
        Tarefa t1 = new Tarefa(); t1.setStatus("A Fazer");
        Tarefa t2 = new Tarefa(); t2.setStatus("A Fazer");

        when(tarefaRepository.findByStatus("A Fazer")).thenReturn(Arrays.asList(t1, t2));

        // Acao
        List<Tarefa> resultado = tarefaService.listarPorStatus("A Fazer");

        // Verificacao
        assertEquals(2, resultado.size());
        verify(tarefaRepository, times(1)).findByStatus("A Fazer");
    }

}
