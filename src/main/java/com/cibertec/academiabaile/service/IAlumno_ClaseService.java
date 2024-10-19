package com.cibertec.academiabaile.service;

import com.cibertec.academiabaile.model.bd.Alumno_clase;

import java.util.List;

public interface IAlumno_ClaseService {
    List<Alumno_clase> listarBailarines();
    void registerBailarines(Alumno_clase alumno_clase);
    void deleteBailarines(Integer id);
}
