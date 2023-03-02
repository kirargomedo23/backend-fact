package com.kir.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_documento")
@Getter
@Setter
@ToString
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_documento")
    private Long id_tipo_documento;

    @Column(length = 20, nullable = false)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 200, nullable = true, columnDefinition = "varchar default NULL")
    private String description;

    @Column(columnDefinition = "boolean  default true")
    private Boolean estado;


    @OneToOne(mappedBy = "documento")
    @JsonIgnore
    private Entidad entidad;

}
