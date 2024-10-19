package com.cibertec.academiabaile.model.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Alumno_PruebaRequest {
    public Integer id;
    public Integer alumno;
    public Integer prueba;
    public String resultados;
    public LocalDate fecha_prueba;

}
