package com.kir.backend.repository;

import com.kir.backend.models.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long>  {

    @Query(value = "SELECT *FROM tb_entidad e WHERE e.estado = :estado  ", nativeQuery = true )
    Optional<List<Entidad>> findByEstado( @Param("estado") Boolean estado);

    @Query(
            value = "SELECT *FROM tb_entidad e WHERE " +
                    "e.nro_documento LIKE %:search% OR e.razon_social LIKE %:search%  ",
            nativeQuery = true
    )
    Optional<List<Entidad>> findByNroDocumentoOrRazonSocialLike(@Param("search") String search);
}
