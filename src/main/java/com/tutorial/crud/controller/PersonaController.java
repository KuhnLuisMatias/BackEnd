package com.tutorial.crud.controller;

import com.tutorial.crud.entity.Persona;
import com.tutorial.crud.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/about")
public class PersonaController {

    @Autowired
    private PersonaService personaService;
    @GetMapping("listar")
    public ResponseEntity<List<Persona>> listarPersona(){
        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.save(persona),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id,@RequestBody Persona persona){
        Persona personaEncontrada = personaService.findById(id);
        if(personaEncontrada == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            personaEncontrada.setNombre(persona.getNombre());
            personaEncontrada.setDescripcion(persona.getDescripcion());
            personaEncontrada.setApellido(persona.getApellido());
            personaEncontrada.setCelular(persona.getCelular());
            personaEncontrada.setEmail(persona.getEmail());
            personaEncontrada.setCiudad(persona.getCiudad());
            personaEncontrada.setFecha(personaEncontrada.getFecha());
            return new ResponseEntity<>(personaService.save(personaEncontrada),HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> actualizarPersona(@PathVariable Long id){
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
