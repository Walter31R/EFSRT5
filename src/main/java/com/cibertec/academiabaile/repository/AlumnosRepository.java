package com.cibertec.academiabaile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cibertec.academiabaile.model.bd.Alumnos;


@Repository
public interface AlumnosRepository extends JpaRepository<Alumnos, Integer> {

}
