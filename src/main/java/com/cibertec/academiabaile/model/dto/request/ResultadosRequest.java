package com.cibertec.academiabaile.model.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class ResultadosRequest {
    private  Integer id_alumno;
    private  Integer id_clase;
    private Date fecha_inicio;
}
