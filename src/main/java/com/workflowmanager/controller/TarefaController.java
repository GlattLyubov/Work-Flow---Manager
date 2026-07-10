package com.workflowmanager.controller;

import com.workflowmanager.model.Tarefa;
import com.workflowmanager.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    // Rota Principal: Exibe a tela do quadro Kanban com as tarefas divididas por status
    @GetMapping
    public String exibirKanban(Model model) {
        model.addAttribute("tarefasAFazer", tarefaService.listarPorStatus("A Fazer"));
        model.addAttribute("tarefasEmProgresso", tarefaService.listarPorStatus("Em Progresso"));
        model.addAttribute("tarefasConcluidas", tarefaService.listarPorStatus("Concluído"));
        return "kanban"; // Isso vai buscar um arquivo chamado kanban.html na pasta templates
    }

    // Rota para salvar uma nova tarefa vinda do formulário
    @PostMapping("/salvar")
    public String salvarTarefa(@ModelAttribute("tarefa") Tarefa tarefa) {
        tarefaService.salvar(tarefa);
        return "redirect:/tarefas"; // Recarrega a página atualizando a lista
    }

    // Rota para mudar o status da tarefa (mover os cartões no Kanban)
    @PostMapping("/alterar-status/{id}")
    public String alterarStatus(@PathVariable("id") Long id, @RequestParam("status") String novoStatus) {
        tarefaService.buscarPorId(id).ifPresent(tarefa -> {
            tarefa.setStatus(novoStatus);
            tarefaService.salvar(tarefa);
        });
        return "redirect:/tarefas";
    }

    // Rota para deletar uma tarefa
    @GetMapping("/deletar/{id}")
    public String deletarTarefa(@PathVariable("id") Long id) {
        tarefaService.deletar(id);
        return "redirect:/tarefas";
    }

}
