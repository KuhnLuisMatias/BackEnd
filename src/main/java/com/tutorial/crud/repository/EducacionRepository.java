package com.tutorial.crud.repository;


import com.tutorial.crud.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducacionRepository extends JpaRepository<Educacion, Long> {
}
