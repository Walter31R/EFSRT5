package com.cibertec.academiabaile.model.dto.request;

import lombok.Data;

@Data
public class ClasesRequest {
    private Integer id;
    private String nombre_clase;
    private Integer entrenador;
    private Integer nromaximo;
}
