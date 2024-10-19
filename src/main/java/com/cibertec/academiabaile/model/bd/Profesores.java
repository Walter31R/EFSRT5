package com.cibertec.academiabaile.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profesores")
public class Profesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo_electronico;
    private String especializacion;
}
