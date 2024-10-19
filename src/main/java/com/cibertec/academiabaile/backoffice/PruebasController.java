package com.cibertec.academiabaile.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.academiabaile.model.bd.Pruebas;
import com.cibertec.academiabaile.model.dto.request.PruebasRequest;
import com.cibertec.academiabaile.model.dto.response.PruebasResponse;
import com.cibertec.academiabaile.service.IPruebasService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    private IPruebasService iPruebasService;

    @GetMapping("")
    public String frmpruebas(Model model){
        model.addAttribute("listpruebas",
                iPruebasService.listarPruebas());
        return "backoffice/pruebas/frmpruebas";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Pruebas> listarPruebas(){
        return iPruebasService.listarPruebas();
    }

    @PostMapping("/register")
    @ResponseBody
    public PruebasResponse registerPrueba(@RequestBody PruebasRequest pruebasRequest){
        String mensaje = "Prueba registrada correctamente";
        boolean respuesta = true;
        try{
            Pruebas pruebas = new Pruebas();
            if (pruebasRequest.getId()> 0){
                pruebas.setId(pruebasRequest.getId());
            }
            pruebas.setTipo_prueba(pruebasRequest.getTipo_prueba());
            pruebas.setDescripcion(pruebasRequest.getDescripcion());
            iPruebasService.registerPruebas(pruebas);
        }catch (Exception ex){
            mensaje = "Prueba no registrada, error en la BD. ";
            respuesta = false;
        }
        return  PruebasResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Pruebas> listpruebas(){
        return  iPruebasService.listarPruebas();
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public PruebasResponse eliminarPrueba(@PathVariable Integer id) {
        String mensaje = "Prueba eliminado correctamente";
        boolean respuesta = true;
        try{
            iPruebasService.deletePruebas(id);
        }catch (Exception ex){
            mensaje = "Prueba no eliminado, error en la BD. ";
            respuesta = false;
        }
        return PruebasResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
