package com.cibertec.academiabaile.model.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Alumno_claseRequest {
    private Integer id;
    private Integer alumno;
    private Integer clase;
    private LocalDate fecha_registro;
    private Boolean activo;
}
