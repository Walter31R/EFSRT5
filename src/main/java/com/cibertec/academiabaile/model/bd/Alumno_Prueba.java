package com.cibertec.academiabaile.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "resultados_pruebas")
public class Alumno_Prueba {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_alumno_prueba;
        @ManyToOne
        @JoinColumn(name = "ID_Alumno")
        private Alumnos alumno;
        @ManyToOne
        @JoinColumn(name = "ID_Prueba")
        private Pruebas prueba;
        private String resultados;
        private LocalDate fecha_prueba;
    }

