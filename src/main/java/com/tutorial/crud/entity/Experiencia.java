package com.tutorial.crud.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Experiencia")
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private String puesto;

    private String fechaDesde;

    private String fechaHasta;
    private String descripcion;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Experiencia(Long id, String nombre, String puesto, String fechaDesde, String fechaHasta, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.descripcion = descripcion;
    }

    public Experiencia() {
    }

    @ManyToOne
    @JoinColumn(name="Persona_id")
    private Persona persona;
}
