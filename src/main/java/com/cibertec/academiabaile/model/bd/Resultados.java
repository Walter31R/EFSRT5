package com.cibertec.academiabaile.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "resultados_pruebas")
public class Resultados {
    @Id
    private  Integer id_alumno;
    private  Integer id_clase;
    private Date fecha_inicio;
}
