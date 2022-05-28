package com.tutorial.crud.service;

import com.tutorial.crud.entity.Logro;
import com.tutorial.crud.repository.LogroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogroService implements ILogroService{

    @Autowired
    private LogroRepository logroRepository;


    @Override
    public Logro save(Logro logro) {
        return  logroRepository.save(logro);
    }

    @Override
    public Logro findById(Long id) {
        return logroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Logro> findAll() {
        return logroRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        logroRepository.deleteById(id);
    }
}
