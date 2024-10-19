package com.cibertec.academiabaile.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "clases")
public class Clases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre_clase;
    @ManyToOne
    @JoinColumn(name = "id_entrenador")
    private Profesores entrenador;
    private Integer nromaximo;
}
