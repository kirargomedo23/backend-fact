package com.kir.backend.controllers;

import com.kir.backend.errors.MissingHeaderInfoException;
import com.kir.backend.models.Documento;
import com.kir.backend.services.DocumentoImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/documento")
@CrossOrigin("*")
public class DocumentoController {

    private static final Logger log = LoggerFactory.getLogger(DocumentoController.class);

    @Autowired
    private DocumentoImp documentoImp;

    @GetMapping("/{id}")
    public Documento encontrarDocumento(@PathVariable Long id){
        log.info(" Método encontrarDocumento, recibió el id: "+id);
        return documentoImp.buscarPorId(id)
                .orElseThrow( () ->
                        new MissingHeaderInfoException("El id enviado en la petición " +
                                "con valor de "+ id +" no existe."));
    }

    @PutMapping("/{id}")
    public ResponseEntity< Documento > actualizarDocumento(
            @RequestBody Documento documento,
            @PathVariable Long id){

        log.info(" Método actualizarDocumento, recibió el id: "+id);
        Documento documentoBD = documentoImp
                .buscarPorId(id)
                .orElseThrow( () ->
                        new MissingHeaderInfoException("El id enviado en la petición " +
                                "con valor de "+ id +" no existe."));

        Documento documentoActualizado = documentoImp.actualizarPorId(documentoBD, documento);
        return new ResponseEntity(documentoActualizado, HttpStatus.OK);

    }

}
