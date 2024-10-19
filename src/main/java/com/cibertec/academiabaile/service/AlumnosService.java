package com.cibertec.academiabaile.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.academiabaile.model.bd.Alumnos;
import com.cibertec.academiabaile.repository.AlumnosRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AlumnosService implements IAlumnosService{

    private AlumnosRepository alumnosRepository;
    @Override
    public List<Alumnos> listarAlumnos() {
        return alumnosRepository.findAll();
    }


    @Override
    public void registerAlumnos(Alumnos alumnos) {
        alumnosRepository.save(alumnos);
    }

    @Override
    public void deleteAlumnos(Integer id) {
        alumnosRepository.deleteById(id);
    }
}
