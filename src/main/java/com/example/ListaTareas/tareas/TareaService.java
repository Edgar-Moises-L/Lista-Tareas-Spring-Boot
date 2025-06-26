package com.example.ListaTareas.tareas;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService implements ITareaService {
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private TareaMapper tareaMapper;

    @Override
    public List<TareaDTO> getAll() {
        return tareaRepository.findAll().stream()
                .map(tareaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TareaDTO getById(Long id) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException(("No se encontro el id " + id)));
        return tareaMapper.toDto(tarea);
    }

    @Override
    @Transactional
    public TareaDTO addTarea(TareaDTO tareaDTO) {
        Tarea tarea = tareaMapper.toEntity(tareaDTO);
        validarRequest(tarea);
        Tarea tareaNueva = tareaRepository.save(tarea);
        return tareaMapper.toDto(tareaNueva);
    }

    @Override
    @Transactional
    public TareaDTO updateTarea(TareaDTO tareaDTO, Long id) {
        Tarea tareaGuardada = tareaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("No se encontro el producto con el id " + id));

        Tarea tareaNueva = tareaMapper.toEntity(tareaDTO);
        validarRequest(tareaNueva);

        tareaGuardada.setTitulo(tareaNueva.getTitulo());
        tareaGuardada.setDescripcion(tareaNueva.getDescripcion());
        tareaGuardada.setFechaLiminte(tareaNueva.getFechaLiminte());
        tareaGuardada.setPrioridad(tareaNueva.getPrioridad());
        tareaGuardada.setEstado(tareaNueva.getEstado());

        tareaRepository.save(tareaGuardada);
        return tareaMapper.toDto(tareaGuardada);

    }

    @Override
    @Transactional
    public void deleteTarea(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new RuntimeException("No se encontro la tarea con el id '" + id + "'");
        }
        tareaRepository.deleteById(id);
    }


    private void validarRequest(Tarea tarea) {

        if (tarea == null) {
            throw new IllegalArgumentException("El objeto Tarea no puede ser nulo");
        }

        if (tarea.getTitulo() == null || tarea.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título de la tarea no puede estar vacío");
        }

        if (tarea.getDescripcion() == null || tarea.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la tarea no puede estar vacía");
        }

        if (tarea.getFechaCreacon() == null) {
            throw new IllegalArgumentException("La fecha de creación no puede ser nula");
        }

        if (tarea.getFechaLiminte() == null) {
            throw new IllegalArgumentException("La fecha límite no puede ser nula");
        }

        if (tarea.getFechaCreacon().after(tarea.getFechaLiminte())) {
            throw new IllegalArgumentException("La fecha de creación no puede ser posterior a la fecha límite");
        }

        if (tarea.getEstado() == null || tarea.getEstado().trim().isEmpty()) {
            throw new IllegalArgumentException("El estado de la tarea no puede estar vacío");
        }

        if (!esEstadoValido(tarea.getEstado())) {
            throw new IllegalArgumentException("El estado proporcionado no es válido");
        }

        if (tarea.getPrioridad() == null || tarea.getPrioridad().trim().isEmpty()) {
            throw new IllegalArgumentException("La prioridad de la tarea no puede estar vacía");
        }

        if (!esPrioridadValida(tarea.getPrioridad())) {
            throw new IllegalArgumentException("La prioridad proporcionada no es válida");
        }
    }

    private boolean esEstadoValido(String estado) {
        return estado.equalsIgnoreCase("pendiente")
                || estado.equalsIgnoreCase("en progreso")
                || estado.equalsIgnoreCase("completado");
    }

    private boolean esPrioridadValida(String prioridad) {
        return prioridad.equalsIgnoreCase("baja")
                || prioridad.equalsIgnoreCase("media")
                || prioridad.equalsIgnoreCase("alta");
    }

}
