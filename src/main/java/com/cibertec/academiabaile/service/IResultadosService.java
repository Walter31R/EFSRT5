package com.cibertec.academiabaile.service;

import com.cibertec.academiabaile.model.bd.Resultados;

import java.util.List;

public interface IResultadosService {
    List<Resultados> listarResultados();
    void registerResultados(Resultados resultados);
}
