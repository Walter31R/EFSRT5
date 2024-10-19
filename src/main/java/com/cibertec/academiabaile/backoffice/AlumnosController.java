package com.cibertec.academiabaile.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.academiabaile.model.bd.Alumnos;
import com.cibertec.academiabaile.model.dto.request.AlumnosRequest;
import com.cibertec.academiabaile.model.dto.response.AlumnosResponse;
import com.cibertec.academiabaile.service.IAlumnosService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/alumnos")
public class AlumnosController {

    private IAlumnosService iAlumnosService;

    @GetMapping("")
    public String frmalumnos(Model model){
        model.addAttribute("listalumnos",
                iAlumnosService.listarAlumnos());
        return "backoffice/alumnos/frmalumnos";
    }


    @GetMapping("/list")
    @ResponseBody
    public List<Alumnos> listarAlumnos(){
        return iAlumnosService.listarAlumnos();
    }

    @PostMapping("/register")
    @ResponseBody
    public AlumnosResponse registerAlumno(@RequestBody AlumnosRequest alumnosRequest){
        String mensaje = "Alumno registrado correctamente";
        boolean respuesta = true;
        try{
            Alumnos alumnos = new Alumnos();
            if(alumnosRequest.getId() > 0){
                alumnos.setId(alumnosRequest.getId());
            }
            alumnos.setDni(alumnosRequest.getDni());
            alumnos.setNombre(alumnosRequest.getNombre());
            alumnos.setApellido(alumnosRequest.getApellido());
            alumnos.setFecha_nacimiento(alumnosRequest.getFecha_nacimiento());
            alumnos.setDireccion(alumnosRequest.getDireccion());
            alumnos.setTelefono(alumnosRequest.getTelefono());
            iAlumnosService.registerAlumnos(alumnos);
        }catch (Exception ex){
            mensaje = "Alumno no registrado, error en la BD. ";
            respuesta = false;
        }
        return AlumnosResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public AlumnosResponse eliminarAlumno(@PathVariable Integer id) {
        String mensaje = "Alumno eliminado correctamente";
        boolean respuesta = true;
        try{
            iAlumnosService.deleteAlumnos(id);
        }catch (Exception ex){
            mensaje = "Alumno no eliminado, error en la BD. ";
            respuesta = false;
        }
        return AlumnosResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
