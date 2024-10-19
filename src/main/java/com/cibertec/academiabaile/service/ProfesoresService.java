package com.cibertec.academiabaile.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.academiabaile.model.bd.Profesores;
import com.cibertec.academiabaile.repository.ProfesoresRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class ProfesoresService implements IProfesoresService{

    private ProfesoresRepository profesoresRepository;
    @Override
    public List<Profesores> listarProfesores() {
        return profesoresRepository.findAll();
    }

    @Override
    public void registerProfesores(Profesores profesores) {
        profesoresRepository.save(profesores);
    }

    @Override
    public void deleteProfesores(Integer id) {
        profesoresRepository.deleteById(id);
    }
}
