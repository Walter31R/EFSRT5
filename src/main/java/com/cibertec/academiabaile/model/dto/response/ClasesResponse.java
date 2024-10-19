package com.cibertec.academiabaile.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClasesResponse {
    private Boolean respuesta;
    private String mensaje;
}
