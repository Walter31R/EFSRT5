package com.cibertec.academiabaile.model.dto.request;

import lombok.Data;

@Data
public class PruebasRequest {
    private int id;
    private String tipo_prueba;
    private String descripcion;
}
