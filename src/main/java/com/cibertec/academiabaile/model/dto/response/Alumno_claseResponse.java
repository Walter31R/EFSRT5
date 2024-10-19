package com.cibertec.academiabaile.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alumno_claseResponse {
    private Boolean respuesta;
    private String mensaje;
}
