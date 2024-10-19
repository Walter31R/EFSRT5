package com.cibertec.academiabaile.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.academiabaile.model.bd.*;
import com.cibertec.academiabaile.model.dto.request.Alumno_PruebaRequest;
import com.cibertec.academiabaile.model.dto.response.Alumno_PruebaResponse;
import com.cibertec.academiabaile.service.IAlumno_PruebaService;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/alumno_prueba")
public class Alumno_PruebaController {
    private IAlumno_PruebaService iAlumnoPruebaService;

    @GetMapping("")
    public String frmalumno_prueba(Model model) {
        model.addAttribute("listalpru",
                iAlumnoPruebaService.listarResultados());
        return "backoffice/alumno_prueba/frmalumno_prueba";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Alumno_Prueba> listarResultados() {
        return iAlumnoPruebaService.listarResultados();
    }

    @PostMapping("/register")
    @ResponseBody
    public Alumno_PruebaResponse registerResultados(@RequestBody Alumno_PruebaRequest alumno_pruebaRequest) {
        String mensaje = "Resultado registrado correctamente";
        boolean respuesta = true;
        try {
            Alumno_Prueba alpru = new Alumno_Prueba();
            if (alumno_pruebaRequest.getId() > 0) {
                alpru.setId_alumno_prueba(alumno_pruebaRequest.getId());
            }
            if (alumno_pruebaRequest.fecha_prueba == null){
                alumno_pruebaRequest.fecha_prueba = LocalDate.now();
            }
            Alumnos alumno = new Alumnos();
            alumno.setId(alumno_pruebaRequest.getAlumno());
            alpru.setAlumno(alumno);
            Pruebas pruebas = new Pruebas();
            pruebas.setId(alumno_pruebaRequest.getPrueba());
            alpru.setPrueba(pruebas);
            alpru.setResultados(alumno_pruebaRequest.getResultados());
            alpru.setFecha_prueba(alumno_pruebaRequest.getFecha_prueba());
            iAlumnoPruebaService.registerResultados(alpru);
        } catch (Exception ex) {
            mensaje = ex.getMessage();
            respuesta = false;
        }
        return Alumno_PruebaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public Alumno_PruebaResponse deleteAlumnoPrueba(@PathVariable Integer id) {
        String mensaje = "Resultado de la prueba eliminado correctamente";
        boolean respuesta = true;
        try{
            iAlumnoPruebaService.deleteAlumnoPrueba(id);
        }catch (Exception ex){
            mensaje = "Resultado no eliminado, error en la BD. ";
            respuesta = false;
        }
        return Alumno_PruebaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}