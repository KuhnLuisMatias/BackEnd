package com.tutorial.crud.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="Educacion")
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaFinal;
    private String imagen_educacion;

    public Educacion() {
    }

    public Educacion(Long id, String titulo, String descripcion, String fechaInicio, String fechaFinal, String imagen_educacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.imagen_educacion = imagen_educacion;
    }

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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getImagen_educacion() {
        return imagen_educacion;
    }

    public void setImagen_educacion(String imagen_educacion) {
        this.imagen_educacion = imagen_educacion;
    }

    @ManyToMany(mappedBy = "educacions")
    private Collection<Persona> personas;

}
