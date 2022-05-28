package com.tutorial.crud.service;

import com.tutorial.crud.entity.Educacion;
import com.tutorial.crud.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public Educacion save(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    @Override
    public Educacion findById(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Educacion> findALL() {
        return educacionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        educacionRepository.deleteById(id);

    }
}
