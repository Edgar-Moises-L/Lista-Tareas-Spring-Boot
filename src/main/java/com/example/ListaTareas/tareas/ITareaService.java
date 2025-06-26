package com.example.ListaTareas.tareas;

import java.util.List;

public interface ITareaService {
    List<TareaDTO> getAll();
    TareaDTO getById(Long id);
    TareaDTO addTarea(TareaDTO tareaDTO);
    TareaDTO updateTarea(TareaDTO tareaDTO, Long id);
    void deleteTarea(Long id);

}
