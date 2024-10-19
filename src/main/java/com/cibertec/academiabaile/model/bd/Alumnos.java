package com.cibertec.academiabaile.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "alumnos")
public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private String direccion;
    private String telefono;
}
