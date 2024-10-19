package com.cibertec.academiabaile.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.academiabaile.model.bd.Alumno_clase;
import com.cibertec.academiabaile.model.bd.Alumnos;
import com.cibertec.academiabaile.model.bd.Clases;
import com.cibertec.academiabaile.model.dto.request.Alumno_claseRequest;
import com.cibertec.academiabaile.model.dto.response.Alumno_claseResponse;
import com.cibertec.academiabaile.service.IAlumno_ClaseService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/alumno_clase")
public class Alumno_ClaseController {
    private IAlumno_ClaseService iAlumno_claseService;

    @GetMapping("")
    public String frmalumno_clase(Model model){
        model.addAttribute("listaleq",
                iAlumno_claseService.listarBailarines());
        return "backoffice/alumno_clase/frmalumno_clase";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Alumno_clase> listarBailarines(){
        return iAlumno_claseService.listarBailarines();
    }

    @PostMapping("/register")
    @ResponseBody
    public Alumno_claseResponse registerBailarines(@RequestBody Alumno_claseRequest alumno_claseRequest){
        String mensaje = "Bailarin registrado correctamente";
        boolean respuesta = true;
        try{
            Alumno_clase alcl = new Alumno_clase();
            if(alumno_claseRequest.getId() > 0){
                alcl.setId_alumno_clase(alumno_claseRequest.getId());
            }
            Alumnos alumno = new Alumnos();
            alumno.setId(alumno_claseRequest.getAlumno());
            alcl.setAlumno(alumno);
            Clases clase = new Clases();
            clase.setId(alumno_claseRequest.getClase());
            alcl.setClase(clase);
            alcl.setFecha_registro(alumno_claseRequest.getFecha_registro());
            alcl.setActivo(alumno_claseRequest.getActivo());
            iAlumno_claseService.registerBailarines(alcl);
        }catch (Exception ex){
            mensaje = ex.getMessage();
            respuesta = false;
        }
        return Alumno_claseResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public Alumno_claseResponse deleteBailarines(@PathVariable Integer id) {
        String mensaje = "Bailarin eliminado correctamente";
        boolean respuesta = true;
        try{
            iAlumno_claseService.deleteBailarines(id);
        }catch (Exception ex){
            mensaje = "Bailarin no eliminado, error en la BD. ";
            respuesta = false;
        }
        return Alumno_claseResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
