
package com.arantesds.lista_tarefas.repositories;

import com.arantesds.lista_tarefas.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mark
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
