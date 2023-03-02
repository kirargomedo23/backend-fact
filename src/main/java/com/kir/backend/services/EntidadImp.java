package com.kir.backend.services;

import com.kir.backend.models.Contribuyente;
import com.kir.backend.models.Entidad;
import com.kir.backend.repository.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadImp implements  IBaseService<Entidad> {

    @Autowired
    EntidadRepository entidadRepository;

    @Override
    public void guardar(Entidad entity) {
        entidadRepository.save(entity);
    }

    @Override
    public List<Entidad> listar() {
        return entidadRepository.findAll();
    }

    @Override
    public void eliminar(Entidad entity) {
        entidadRepository.delete(entity);
    }

    @Override
    public Optional<Entidad>  buscarPorId(Long id) {
        return entidadRepository.findById(id);
    }

    @Override
    public void actualizar(Entidad entidad, Entidad entidadBD) {
        entidadBD.setEstado(entidad.getEstado());
        entidadRepository.save(entidadBD);
    }

    public Optional<List<Entidad>>  findByEstado(Boolean estado) {
        return entidadRepository.findByEstado(estado);
    }

    public Optional<List<Entidad>> findByLikeNroDocumentoOrRazonSocial(String search){
        return entidadRepository.findByNroDocumentoOrRazonSocialLike(search);
    }

}
