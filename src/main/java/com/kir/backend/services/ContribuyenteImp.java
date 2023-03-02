package com.kir.backend.services;

import com.kir.backend.models.Contribuyente;
import com.kir.backend.repository.ContribuyenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContribuyenteImp   {

    @Autowired
    ContribuyenteRepository contribuyenteRepository;

    public Optional<Contribuyente> buscarPorId(Long id) {
        return contribuyenteRepository.findById(id);
    }



    public Contribuyente actualizarPorId(Contribuyente contribuyenteBD,
                                                      Contribuyente contribuyenteModel) {
        contribuyenteBD.setNombre(contribuyenteModel.getNombre());
        contribuyenteBD.setEstado(contribuyenteModel.getEstado());
        return  contribuyenteRepository.save(contribuyenteBD);
    }

}
