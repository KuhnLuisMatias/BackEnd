package com.tutorial.crud.entity;

import javax.persistence.*;

@Entity
@Table(name="Logro")
public class Logro {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String fechaExpedicion;
    private String fechaVencimiento;

    private String link;

    public Logro() {
    }

    public Logro(Long id, String titulo, String fechaExpedicion, String fechaVencimiento, String link) {
        this.id = id;
        this.titulo = titulo;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @ManyToOne
    @JoinColumn(name="Persona_id")
    private Persona persona;
}
