package com.example.ListaTareas.tareas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<TareaDTO> getAll(){
        return tareaService.getAll();
    }

    @GetMapping("/{id}")
    public TareaDTO getById(@PathVariable Long id){
        return tareaService.getById(id);
    }

    @PostMapping
    public TareaDTO addTarea(@RequestBody TareaDTO tareaDTO){
        return tareaService.addTarea(tareaDTO);
    }

    @PutMapping("/{id}")
    public TareaDTO updateTarea( @RequestBody TareaDTO tareaDTO, @PathVariable Long id){
        return tareaService.updateTarea(tareaDTO,id);
    }

    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable Long id){
        tareaService.deleteTarea(id);
    }

}