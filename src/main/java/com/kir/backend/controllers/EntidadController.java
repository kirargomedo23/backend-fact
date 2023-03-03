package com.kir.backend.controllers;

import com.kir.backend.errors.MissingHeaderInfoException;
import com.kir.backend.models.Entidad;
import com.kir.backend.services.EntidadImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entidad")
@CrossOrigin("*")
public class EntidadController {

    private static final Logger log = LoggerFactory.getLogger(EntidadController.class);

    @Autowired
    private EntidadImp entidadImp;

    @GetMapping("/all")
    public List<Entidad> getAll()  {
        return entidadImp.listar();
    }

    @GetMapping("/all/filter")
    public  List<Entidad> getAllActivo(@RequestParam("isActive") Boolean active){
        log.info(" Método getAllActivo, recibió el valor de : "+active);

        return entidadImp
                .findByEstado(active)
                .orElseThrow( () ->
                        new MissingHeaderInfoException("Ocurrió un error al filtrar" +
                                " con estado "+ active));
    }

    @GetMapping("/{id}")
    public Optional<Entidad> getOne(@PathVariable Long id){
        log.info(" Método getOne, recibió el valor de : "+id);

        return Optional.ofNullable(entidadImp.buscarPorId(id)
                .orElseThrow(
                        () -> new MissingHeaderInfoException("Ocurrió un error al " +
                                "buscar por el id  " +
                                id)));
    }

    @PostMapping("/")
    public String insert(@RequestBody Entidad entidad){
        try{
            entidadImp.guardar(entidad);
        }catch (Exception e){

        }
        return "";
    }



    @GetMapping("all/search")
    public Optional<List<Entidad>> searchNroDocumentoOrRazonSocial(
            @RequestParam("search") String search){
        log.info(" Método search, recibió el valor de : "+search);
        return Optional.ofNullable(entidadImp
                .findByLikeNroDocumentoOrRazonSocial(search)
                .orElseThrow(
                        () ->
                        new MissingHeaderInfoException("Ocurrió un error al buscar con la palabra " +
                                search )));
    }

    @PutMapping("/{id}")
    public void update(
            @RequestBody Entidad entidad,
            @PathVariable Long id){
        log.info(" Método update, recibió el id: "+id);

        Entidad entidadBD = entidadImp.buscarPorId(id)
                .orElseThrow( () ->
                        new MissingHeaderInfoException("No se pudo " +
                                "actualizar, debido que el id enviado en la petición " +
                                "con valor de "+ id +" no existe."));
        entidadImp.actualizar(entidad, entidadBD);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  void delete( @PathVariable Long id){
        log.info(" Método delete, recibió el id: "+id);

        Entidad entidadBD = entidadImp.buscarPorId(id)
                .orElseThrow( () ->
                        new MissingHeaderInfoException("El id enviado en la petición " +
                                "con valor de "+ id +" no existe."));
        entidadImp.eliminar(entidadBD);
    }


}
