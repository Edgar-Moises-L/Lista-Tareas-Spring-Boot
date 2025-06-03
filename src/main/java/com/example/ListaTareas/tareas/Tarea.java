package com.example.ListaTareas.tareas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Tareas")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacon() {
        return fechaCreacon;
    }

    public void setFechaCreacon(Date fechaCreacon) {
        this.fechaCreacon = fechaCreacon;
    }

    public Date getFechaLiminte() {
        return fechaLiminte;
    }

    public void setFechaLiminte(Date fechaLiminte) {
        this.fechaLiminte = fechaLiminte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
