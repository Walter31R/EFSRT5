package com.cibertec.academiabaile.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.academiabaile.model.bd.Alumno_clase;
import com.cibertec.academiabaile.model.bd.Clases;
import com.cibertec.academiabaile.repository.Alumno_claseRepository;
import com.cibertec.academiabaile.repository.ClasesRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class Alumno_ClaseService implements IAlumno_ClaseService {
    private Alumno_claseRepository alumno_claseRepository;
    private ClasesRepository clasesRepository;

    @Override
    public List<Alumno_clase> listarBailarines() {
        return alumno_claseRepository.findAll();
    }

    @Transactional
    @Override
    public void registerBailarines(Alumno_clase alumno_clase) {

        //Verificar que la clase no este llena
        Clases clase = clasesRepository.findById(alumno_clase.getClase().getId()).get();
        int maximo = clase.getNromaximo();
        List<Alumno_clase> alumnosClase = alumno_claseRepository.obtenerAlumnosClase(alumno_clase.getClase().getId());
        if (alumnosClase.size() >= maximo){
            throw new RuntimeException("La clase supera el máximo de alumnos");
        }
        //Desactivar inscripcion anterior
        alumno_claseRepository.actualizarClaseEstado(alumno_clase.getAlumno().getId());
        //Grabar cambios
        alumno_claseRepository.save(alumno_clase);
    }

    @Override
    public void deleteBailarines(Integer id) {
        alumno_claseRepository.deleteById(id);
    }
}
