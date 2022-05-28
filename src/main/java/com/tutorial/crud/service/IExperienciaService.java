package com.tutorial.crud.service;


import com.tutorial.crud.entity.Experiencia;

import java.util.List;

public interface IExperienciaService {
    public Experiencia save(Experiencia experiencia);
    public Experiencia findById(Long id);
    public List<Experiencia> findALL();
    public void delete(Long id);
}
