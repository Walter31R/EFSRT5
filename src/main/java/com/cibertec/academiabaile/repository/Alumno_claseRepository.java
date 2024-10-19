package com.cibertec.academiabaile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cibertec.academiabaile.model.bd.Alumno_clase;

import java.util.List;

@Repository
public interface Alumno_claseRepository extends JpaRepository<Alumno_clase, Integer> {

    @Query(value = "CALL obtener_alumnosxclase(:id_clase)",
            nativeQuery = true)
    List<Alumno_clase> obtenerAlumnosClase(@Param("id_clase") int id_clase);

    @Modifying
    @Query(value = "CALL actualizar_clase_estado(:id_alumno)",
            nativeQuery = true)
     void actualizarClaseEstado(@Param("id_alumno") int id_alumno);
}
