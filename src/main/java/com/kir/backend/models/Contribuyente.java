package com.kir.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_contribuyente")
@Getter
@Setter
@ToString
public class Contribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_contribuyente")
    private Long id_tipo_contribuyente;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false )
    private Boolean estado;


    @OneToOne(mappedBy = "contribuyente")
    @JsonIgnore
    private Entidad entidad;

}
