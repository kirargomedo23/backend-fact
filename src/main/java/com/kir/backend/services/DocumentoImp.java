package com.kir.backend.services;

import com.kir.backend.models.Documento;
import com.kir.backend.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentoImp {

    @Autowired
    DocumentoRepository documentoRepository;

    public Optional<Documento> buscarPorId(Long id){
        return documentoRepository.findById(id);
    }

    public Documento actualizarPorId(Documento documentoBD,
                                     Documento documento){
        documentoBD.setCodigo(documento.getCodigo());
        documentoBD.setNombre(documento.getNombre());
        documentoBD.setDescription(documento.getDescription());
        documentoBD.setEstado(documento.getEstado());
        return documentoRepository.save(documentoBD);
    }
}
