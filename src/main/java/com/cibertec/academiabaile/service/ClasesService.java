package com.cibertec.academiabaile.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.academiabaile.model.bd.Clases;
import com.cibertec.academiabaile.repository.ClasesRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ClasesService implements IClasesService {

    private ClasesRepository clasesRepository;
    @Override
    public List<Clases> listarClases() {
        return clasesRepository.findAll();
    }

    @Override
    public void registerClases(Clases clases) {
        clasesRepository.save(clases);
    }

    @Override
    public void deleteClases(Integer id) {
        clasesRepository.deleteById(id);
    }
}
