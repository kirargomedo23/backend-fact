package com.kir.backend.utils;

import com.kir.backend.dto.ContribuyenteDTO;
import com.kir.backend.dto.DocumentoDTO;
import com.kir.backend.dto.EntidadDTO;
import com.kir.backend.models.Entidad;

public class MapperDTO {

    public EntidadDTO convertEntidadToDTO(Entidad entidad){
        DocumentoDTO documentoDTO = new DocumentoDTO(
                entidad.getDocumento().getId_tipo_documento(),
                entidad.getDocumento().getNombre()
        );

        ContribuyenteDTO contribuyenteDTO = new ContribuyenteDTO(
                entidad.getContribuyente().getId_tipo_contribuyente(),
                entidad.getContribuyente().getNombre()
        );

        return new EntidadDTO(
                entidad.getId_entidad(),  documentoDTO,
                contribuyenteDTO, entidad.getNro_documento(),
                entidad.getRazon_social(), entidad.getEstado()
        );
    }
}
