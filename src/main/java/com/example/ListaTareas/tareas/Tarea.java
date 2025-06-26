package com.example.ListaTareas.tareas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date fechaCreacon;

    @Column(nullable = false)
    private Date fechaLiminte;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String prioridad;
}
