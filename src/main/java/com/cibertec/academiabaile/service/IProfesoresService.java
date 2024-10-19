package com.cibertec.academiabaile.service;

import com.cibertec.academiabaile.model.bd.Profesores;

import java.util.List;

public interface IProfesoresService {
    List<Profesores> listarProfesores();
    void registerProfesores(Profesores profesores);
    void deleteProfesores(Integer id);
}
