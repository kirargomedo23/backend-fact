package com.kir.backend.repository;

import com.kir.backend.models.Contribuyente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContribuyenteRepository extends JpaRepository<Contribuyente, Long> {
}
