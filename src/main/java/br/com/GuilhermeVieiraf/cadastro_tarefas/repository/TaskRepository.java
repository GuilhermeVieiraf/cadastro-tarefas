package br.com.GuilhermeVieiraf.cadastro_tarefas.repository;

import br.com.GuilhermeVieiraf.cadastro_tarefas.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
