package com.tutorial.crud.service;

import com.tutorial.crud.entity.Experiencia;
import com.tutorial.crud.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;


    @Override
    public Experiencia save(Experiencia experiencia) {

        return experienciaRepository.save(experiencia);
    }

    @Override
    public Experiencia findById(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }


    @Override
    public List<Experiencia> findALL() {
        return experienciaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        experienciaRepository.deleteById(id);

    }
}
