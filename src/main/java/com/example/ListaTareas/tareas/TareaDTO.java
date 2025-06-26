package com.example.ListaTareas.tareas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TareaDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Date fechaCreacon;
    private Date fechaLiminte;
    private String estado;
    private String prioridad;
}
