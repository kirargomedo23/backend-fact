package com.kir.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntidadDTO {
    private Long id_entidad;
    private DocumentoDTO documentoDTO;
    private ContribuyenteDTO contribuyenteDTO;
    private String nro_documento;
    private String razon_social;
    private Boolean estado;

}
