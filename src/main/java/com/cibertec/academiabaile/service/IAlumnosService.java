package com.cibertec.academiabaile.service;

import com.cibertec.academiabaile.model.bd.Alumnos;

import java.util.List;

public interface IAlumnosService {
    List<Alumnos> listarAlumnos();
    void registerAlumnos(Alumnos alumnos);

    void deleteAlumnos(Integer id);
}
