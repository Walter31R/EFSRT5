package com.cibertec.academiabaile.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlumnosResponse {
    private Boolean respuesta;
    private String mensaje;
}
