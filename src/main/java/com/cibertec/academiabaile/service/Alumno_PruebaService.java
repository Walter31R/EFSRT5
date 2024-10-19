package com.cibertec.academiabaile.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.academiabaile.model.bd.Alumno_Prueba;
import com.cibertec.academiabaile.repository.*;

import java.util.List;

@AllArgsConstructor
@Service
public class Alumno_PruebaService implements IAlumno_PruebaService{
    private Alumno_PruebaRepository alumno_pruebaRepository;
    private AlumnosRepository alumnosRepository;

    @Override
    public List<Alumno_Prueba> listarResultados() {
        return alumno_pruebaRepository.findAll();
    }

    @Override
    public void registerResultados(Alumno_Prueba alumno_prueba) {
        alumno_pruebaRepository.save(alumno_prueba);
    }

    @Override
    public void deleteAlumnoPrueba(Integer id) {
        alumno_pruebaRepository.deleteById(id);
    }
}
