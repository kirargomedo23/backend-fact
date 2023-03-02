package com.kir.backend.controllers;

import com.kir.backend.errors.MissingHeaderInfoException;
import com.kir.backend.models.Entidad;
import com.kir.backend.services.EntidadImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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
    public List<Entidad> getAll(){
        List<Entidad> listEntidad = null;
        try {
            listEntidad = entidadImp.listar();
        }catch (Exception e){
            //return new HttpResponse<Entidad>(HttpStatus.CONFLICT);
        }
        return listEntidad;
    }

    @GetMapping("/all/filter")
    public  Optional<List<Entidad>> getAllActivo(@RequestParam("isActive") Boolean active){
        log.info(" Método getAllActivo, recibió el valor de : "+active);

        Optional<List<Entidad>> listEntidad = null;
        try {
            listEntidad = entidadImp.findByEstado(active);
        }catch (Exception e){
            System.out.println("e: "+e);
        }
        return listEntidad;
    }

    @GetMapping("/{id}")
    public Optional<Entidad> getOne(@PathVariable Long id){
        log.info(" Método getOne, recibió el valor de : "+id);

        Optional<Entidad> entidad = null;
        try {
            entidad = entidadImp.buscarPorId(id);
        }catch (Exception e){

        }
        return entidad;
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
    public Optional<List<Entidad>> searchNroDocumentoOrRazonSocial(@RequestParam("search") String search){
        log.info(" Método search, recibió el valor de : "+search);
        Optional<List<Entidad>> x = entidadImp.findByLikeNroDocumentoOrRazonSocial(search);
        return  x;
    }

    @PutMapping("/{id}")
    public String update(
            @RequestBody Entidad entidad,
            @PathVariable Long id){
        log.info(" Método update, recibió el id: "+id);

        Entidad entidadBD = entidadImp.buscarPorId(id)
                .orElseThrow( () ->
                        new MissingHeaderInfoException("El id enviado en la petición " +
                                "con valor de "+ id +" no existe."));
        entidadImp.actualizar(entidad, entidadBD);
        return  "";
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
