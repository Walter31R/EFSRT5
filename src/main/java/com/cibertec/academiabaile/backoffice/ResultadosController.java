package com.cibertec.academiabaile.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cibertec.academiabaile.model.bd.Resultados;
import com.cibertec.academiabaile.service.IResultadosService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/resultados")
public class ResultadosController {

    private IResultadosService iResultadosService;

    @GetMapping("")
    public String frmresultados(Model model){
        model.addAttribute("listresultados",
                iResultadosService.listarResultados());
        return "backoffice/resultados/frmresultados";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Resultados> listarResultados(){
        return iResultadosService.listarResultados();
    }

    /*@PostMapping("/register")
    @ResponseBody
    public ResultadosResponse registerResultado(@RequestBody ResultadosRequest resultadosRequest){
        String mensaje = "Resultado registrado correctamente";
        boolean respuesta = true;
        try{
            Resultados resultados = new Resultados();
            resultados.setId_alumno(resultadosRequest.getId_alumno());
            resultados.setId_clase(resultadosRequest.getId_clase());
            resultados.setFecha_inicio(resultadosRequest.getFecha_inicio());

            Resultados existingResultados = iResultadosService.findByFecha_inicio(resultados.getFecha_inicio());
            if (existingResultados != null) {
                // Si ya existe un resultado con la misma fecha de inicio, se lanza una excepción
                throw new RuntimeException("Ya existe un resultado con la misma fecha de inicio.");
            }

            iResultadosService.registerResultados(resultados);
        } catch (Exception ex) {
            mensaje = "Resultados no registrados, error en la BD.";
            respuesta = false;
        }
        return ResultadosResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }*/
}
