package br.com.GuilhermeVieiraf.cadastro_tarefas.Controller;

import br.com.GuilhermeVieiraf.cadastro_tarefas.dto.TaskDTO;
import br.com.GuilhermeVieiraf.cadastro_tarefas.entity.Task;
import br.com.GuilhermeVieiraf.cadastro_tarefas.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Handler;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid TaskDTO task) {
        TaskDTO createdTask = service.create(task);
        return ResponseEntity.status(201).body(createdTask);
    }

    @GetMapping("/list-tasks")
    public ResponseEntity<List<TaskDTO>> list() {
        List<TaskDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(
            @PathVariable UUID id,
            @RequestBody @Valid TaskDTO dto) {
        try {
            TaskDTO updated = service.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }




}
