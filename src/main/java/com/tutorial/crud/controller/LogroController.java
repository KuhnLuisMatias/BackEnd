package com.tutorial.crud.controller;

import com.tutorial.crud.entity.Educacion;
import com.tutorial.crud.entity.Logro;
import com.tutorial.crud.service.LogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/logro")
public class LogroController {

    @Autowired
    private LogroService logroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Logro>> listarLogro()
    {
        return new ResponseEntity<>(logroService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Logro> obtenerLogro(@PathVariable Long id){
        return new ResponseEntity<>(logroService.findById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<Logro> crearLogro(@RequestBody Logro logro)
    {
        return new ResponseEntity<>(logroService.save(logro),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Logro> actualizarLogro(@PathVariable Long id,@RequestBody Logro logro){
        Logro logroEncontrado = logroService.findById(id);

        if(logroEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            try{
                logroEncontrado.setTitulo(logro.getTitulo());
                logroEncontrado.setFechaExpedicion(logro.getFechaExpedicion());
                logroEncontrado.setFechaVencimiento(logro.getFechaVencimiento());
                return new ResponseEntity<>(logroService.save(logroEncontrado),HttpStatus.CREATED);
            }catch(DataAccessException e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarLogro(@PathVariable Long id) {
        logroService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


