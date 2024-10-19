package com.cibertec.academiabaile.service;

import com.cibertec.academiabaile.model.bd.Pruebas;

import java.util.List;

public interface IPruebasService {
    List<Pruebas> listarPruebas();
    void registerPruebas(Pruebas pruebas);
    void deletePruebas(Integer id);
}
