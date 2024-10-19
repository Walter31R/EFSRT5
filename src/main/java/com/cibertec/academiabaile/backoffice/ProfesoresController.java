package com.cibertec.academiabaile.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.academiabaile.model.bd.Profesores;
import com.cibertec.academiabaile.model.dto.request.ProfesoresRequest;
import com.cibertec.academiabaile.model.dto.response.ProfesoresResponse;
import com.cibertec.academiabaile.service.IProfesoresService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/profesores")
public class ProfesoresController {

    private IProfesoresService iProfesoresService;

    @GetMapping("")
    public String frmprofesores(Model model){
        model.addAttribute("listaprofesores",
                iProfesoresService.listarProfesores());
        return "backoffice/profesores/frmprofesores";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Profesores> listarProfesores(){
        return iProfesoresService.listarProfesores();
    }

    @PostMapping("/register")
    @ResponseBody
    public ProfesoresResponse registerProfesor(@RequestBody ProfesoresRequest profesoresRequest){
        String mensaje = "Profesor registrado correctamente";
        boolean respuesta = true;
        try{
            Profesores profesores = new Profesores();
            if (profesoresRequest.getId() > 0){
                profesores.setId(profesoresRequest.getId());
            }
            profesores.setDni(profesoresRequest.getDni());
            profesores.setNombre(profesoresRequest.getNombre());
            profesores.setApellido(profesoresRequest.getApellido());
            profesores.setTelefono(profesoresRequest.getTelefono());
            profesores.setCorreo_electronico(profesoresRequest.getCorreo_electronico());
            profesores.setEspecializacion(profesoresRequest.getEspecializacion());
            iProfesoresService.registerProfesores(profesores);
        }catch (Exception ex){
            mensaje = "Profesor no registrado, error en la BD. ";
            respuesta = false;
        }
        return  ProfesoresResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Profesores> listprofesores(){
        return  iProfesoresService.listarProfesores();
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public ProfesoresResponse eliminarProfesores(@PathVariable Integer id) {
        String mensaje = "Profesor eliminado correctamente";
        boolean respuesta = true;
        try{
            iProfesoresService.deleteProfesores(id);
        }catch (Exception ex){
            mensaje = "Profesor no eliminado, error en la BD. ";
            respuesta = false;
        }
        return ProfesoresResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
