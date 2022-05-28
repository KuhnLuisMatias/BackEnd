package com.tutorial.crud.service;

import com.tutorial.crud.entity.Logro;

import java.util.List;

public interface ILogroService {

    public Logro save(Logro logro);
    public Logro findById(Long id);
    public List<Logro> findAll();
    public void delete(Long id);
}
