package com.arantesds.lista_tarefas.controllers;

import com.arantesds.lista_tarefas.models.Tarefa;
import com.arantesds.lista_tarefas.repositories.TarefaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mark
 */
@RestController
// Define a URL base para o controller
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    // GET /api/tarefas
    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    // GET /api/tarefas/1
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id) {
        Optional<Tarefa> tarefa = repository.findById(id);
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        }
        return ResponseEntity.notFound().build();
    }

    // POST /api/tarefas
    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    // DELETE /api/tarefas/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // PUT /api/tarefas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaDetalhes) {
        //Busca a tarefa
        Optional<Tarefa> tarefaExistente = repository.findById(id);

        //Verifica se a tarefa foi encontrada
        if (tarefaExistente.isPresent()) {
            //Obtém o objeto da tarefa
            Tarefa tarefa = tarefaExistente.get();

            //Atualiza os dados da tarefa com os detalhes da requisição
            tarefa.setDescricao(tarefaDetalhes.getDescricao());
            tarefa.setConcluida(tarefaDetalhes.isConcluida());

            //Salva a tarefa atualizada no banco de dados
            Tarefa tarefaAtualizada = repository.save(tarefa);

            //Retorna a tarefa atualizada com status 200 OK
            return ResponseEntity.ok(tarefaAtualizada);
        } else {
            //Se a tarefa não existir, retorna 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

}
