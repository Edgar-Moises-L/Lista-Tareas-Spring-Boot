package com.example.ListaTareas.tareas;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private TareaMapper tareaMapper;

    public List<TareaDTO> getAll(){
        return tareaRepository.findAll().stream()
                .map(tareaMapper::toDto)
                .collect(Collectors.toList());
    }

    public TareaDTO getById(Long id){
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException(("No se encontro el id " + id)));
        return tareaMapper.toDto(tarea);
    }

    @Transactional
    public TareaDTO addTarea(TareaDTO tareaDTO){
       Tarea tarea = tareaMapper.toEntity(tareaDTO);

       Tarea tareaNueva = tareaRepository.save(tarea);
       return tareaMapper.toDto(tareaNueva);
    }

    @Transactional
    public TareaDTO updateTarea(TareaDTO tareaDTO, Long id){
        Tarea tareaGuardada = tareaRepository.findById(id).
                orElseThrow(()-> new RuntimeException("No se encontro el producto con el id " + id));

        Tarea tareaNueva = tareaMapper.toEntity(tareaDTO);

        tareaGuardada.setTitulo(tareaNueva.getTitulo());
        tareaGuardada.setDescripcion(tareaNueva.getDescripcion());
        tareaGuardada.setFechaLiminte(tareaNueva.getFechaLiminte());
        tareaGuardada.setPrioridad(tareaNueva.getPrioridad());
        tareaGuardada.setEstado(tareaNueva.getEstado());

        tareaRepository.save(tareaGuardada);
        return tareaMapper.toDto(tareaGuardada);

    }

    @Transactional
    public void deleteTarea(Long id){
        if(!tareaRepository.existsById(id)){
            throw new RuntimeException("No se encontro la tarea con el id '" + id + "'");
        }
        tareaRepository.deleteById(id);
    }

}
