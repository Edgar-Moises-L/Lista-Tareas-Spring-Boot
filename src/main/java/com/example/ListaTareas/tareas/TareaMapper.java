package com.example.ListaTareas.tareas;

import org.springframework.stereotype.Component;

@Component
public class TareaMapper {
    public TareaDTO toDto(Tarea tarea) {
        TareaDTO dto = new TareaDTO();
        dto.setId(tarea.getId());
        dto.setTitulo(tarea.getTitulo());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setFechaCreacon(tarea.getFechaCreacon());
        dto.setFechaLiminte(tarea.getFechaLiminte());
        dto.setPrioridad(tarea.getPrioridad());
        dto.setEstado(tarea.getEstado());
        return dto;
    }

    public Tarea toEntity(TareaDTO dto) {
        Tarea tarea = new Tarea();
        tarea.setId(dto.getId());
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setFechaCreacon(dto.getFechaCreacon());
        tarea.setFechaLiminte(dto.getFechaLiminte());
        tarea.setPrioridad(dto.getPrioridad());
        tarea.setEstado(dto.getEstado());
        return tarea;
    }
}
