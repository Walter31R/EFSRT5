package com.cibertec.academiabaile.model.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlumnosRequest {
    private Integer id;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private String direccion;
    private String telefono;
}
