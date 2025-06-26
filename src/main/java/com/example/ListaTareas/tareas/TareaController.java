package com.example.ListaTareas.tareas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<TareaDTO>> getAll() {
        List<TareaDTO> tareas = tareaService.getAll();
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaDTO> getById(@PathVariable Long id) {
        TareaDTO tarea = tareaService.getById(id);
        return ResponseEntity.ok(tarea);
    }

    @PostMapping
    public ResponseEntity<TareaDTO> addTarea(@RequestBody TareaDTO tareaDTO) {
        TareaDTO tarea = tareaService.addTarea(tareaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaDTO> updateTarea(@RequestBody TareaDTO tareaDTO, @PathVariable Long id) {
        TareaDTO tarea = tareaService.updateTarea(tareaDTO, id);
        return ResponseEntity.ok(tarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}


