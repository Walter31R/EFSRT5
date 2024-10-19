package com.cibertec.academiabaile.service;

import com.cibertec.academiabaile.model.bd.Clases;

import java.util.List;

public interface IClasesService {
    List<Clases> listarClases();
    void registerClases(Clases clases);
    void deleteClases(Integer id);
}
