package com.cibertec.academiabaile.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.academiabaile.model.bd.Pruebas;
import com.cibertec.academiabaile.repository.PruebasRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PruebasService implements IPruebasService {

    private final PruebasRepository pruebasRepository;


    @Override
    public List<Pruebas> listarPruebas() {
        return pruebasRepository.findAll();
    }

    @Override
    public void registerPruebas(Pruebas pruebas) {
        pruebasRepository.save(pruebas);
    }

    public void deletePruebas(Integer id) {
        pruebasRepository.deleteById(id);
    }
}
