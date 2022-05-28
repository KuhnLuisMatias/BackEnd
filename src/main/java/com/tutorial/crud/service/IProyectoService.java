package com.tutorial.crud.service;


import com.tutorial.crud.entity.Proyecto;

import java.util.List;

public interface IProyectoService {
    public Proyecto save(Proyecto proyectos);
    public Proyecto findById(Long id);
    public List<Proyecto> findALL();
    public void delete(Long id);
}
