package com.cibertec.academiabaile.service;

import com.cibertec.academiabaile.model.bd.Alumno_Prueba;

import java.util.List;

public interface IAlumno_PruebaService {
    List<Alumno_Prueba> listarResultados();
    void registerResultados(Alumno_Prueba alumno_prueba);
    void deleteAlumnoPrueba(Integer id);
}

