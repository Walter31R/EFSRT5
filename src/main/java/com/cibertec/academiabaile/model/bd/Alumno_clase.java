package com.cibertec.academiabaile.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "alumno_clase")
public class Alumno_clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alumno_clase;
    @ManyToOne
    @JoinColumn(name = "ID_Alumno")
    private Alumnos alumno;
    @ManyToOne
    @JoinColumn(name = "ID_Clase")
    private Clases clase;
    private LocalDate fecha_registro;
    private Boolean activo;


}
