package com.cibertec.academiabaile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cibertec.academiabaile.model.bd.Alumno_Prueba;

import java.util.List;

public interface Alumno_PruebaRepository extends JpaRepository<Alumno_Prueba, Integer> {
    @Query(value = "CALL obtener_prueba_alumno(:id_prueba)",
            nativeQuery = true)
    List<Alumno_Prueba> obtenerPruebasAlumno(@Param("id_prueba") int id);
}
