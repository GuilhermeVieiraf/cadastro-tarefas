package br.com.GuilhermeVieiraf.cadastro_tarefas.service;

import br.com.GuilhermeVieiraf.cadastro_tarefas.dto.TaskDTO;
import br.com.GuilhermeVieiraf.cadastro_tarefas.entity.Task;
import br.com.GuilhermeVieiraf.cadastro_tarefas.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task create(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setExpirationDate(dto.expirationDate());
        return repository.save(task);
    }

    public List<TaskDTO> findAll() {
       List<Task> tasks = repository.findAll();

       List<TaskDTO> listDTO = tasks.stream()
               .map(task -> new TaskDTO(
                       task.getId(),
                       task.getTitle(),
                       task.getDescription(),
                       task.getExpirationDate()
               ))
               .toList();

       return listDTO;
    }

    public Task findById(UUID id) throws EntityNotFoundException {
        Optional<Task> taskOptional = repository.findById(id);
        return taskOptional.orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
    }

    public TaskDTO update(UUID id, TaskDTO dto) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setExpirationDate(dto.expirationDate());

        Task updatedTask = repository.save(task);

        return new TaskDTO(
                updatedTask.getId(),
                updatedTask.getTitle(),
                updatedTask.getDescription(),
                updatedTask.getExpirationDate()
        );
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Task com ID " + id + " não encontrada para deleção.");
        }
        repository.deleteById(id);
    }
}
