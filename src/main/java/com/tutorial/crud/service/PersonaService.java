
package com.tutorial.crud.service;


import com.tutorial.crud.entity.Persona;
import com.tutorial.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);

    }
}
