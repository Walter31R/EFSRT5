package com.cibertec.academiabaile.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pruebas")
public class Pruebas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo_prueba;
    private String descripcion;
}
