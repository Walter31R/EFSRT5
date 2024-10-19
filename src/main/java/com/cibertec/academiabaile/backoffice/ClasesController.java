package com.cibertec.academiabaile.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.academiabaile.model.bd.Clases;
import com.cibertec.academiabaile.model.bd.Profesores;
import com.cibertec.academiabaile.model.dto.request.ClasesRequest;
import com.cibertec.academiabaile.model.dto.response.ClasesResponse;
import com.cibertec.academiabaile.service.IClasesService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/clases")
public class ClasesController {

    private IClasesService iClasesService;

    @GetMapping("")
    public String frmeclases(Model model){
        model.addAttribute("listclases",
                iClasesService.listarClases());
        return "backoffice/clases/frmclases";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Clases> listarClases(){
        return iClasesService.listarClases();
    }

    @PostMapping("/register")
    @ResponseBody
    public ClasesResponse registerClase(@RequestBody ClasesRequest clasesRequest){
        String mensaje = "Clase registrado correctamente";
        boolean respuesta = true;
        try{
            Clases clases = new Clases();
            if(clasesRequest.getId() > 0){
                clases.setId(clasesRequest.getId());
            }
            clases.setNombre_clase(clasesRequest.getNombre_clase());
            Profesores profesores = new Profesores();
            profesores.setId(clasesRequest.getEntrenador());
            clases.setEntrenador(profesores);
            clases.setNromaximo(clasesRequest.getNromaximo());
            iClasesService.registerClases(clases);
        }catch (Exception ex){
            mensaje = "Clase no registrado, error en la BD. ";
            respuesta = false;
        }
        return ClasesResponse.builder().mensaje(mensaje).respuesta(respuesta).build();}


    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public ClasesResponse eliminarClase(@PathVariable Integer id) {
        String mensaje = "Clase eliminado correctamente";
        boolean respuesta = true;
        try{
            iClasesService.deleteClases(id);
        }catch (Exception ex){
            mensaje = "Clase no eliminado, error en la BD. ";
            respuesta = false;
        }
        return ClasesResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
