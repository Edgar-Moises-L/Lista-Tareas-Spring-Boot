package com.example.ListaTareas.tareas;

import java.util.Date;

public class TareaDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Date fechaCreacon;
    private Date fechaLiminte;
    private String estado;
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

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
