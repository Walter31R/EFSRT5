package com.cibertec.academiabaile.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.academiabaile.model.bd.Resultados;
import com.cibertec.academiabaile.repository.ResultadosRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ResultadosService implements  IResultadosService{

    private ResultadosRepository resultadosRepository;

    @Override
    public List<Resultados> listarResultados() {
        return resultadosRepository.findAll();
    }


    @Override
    @Transactional
    public void registerResultados(Resultados resultados) {
        resultadosRepository.save(resultados);
    }
}
