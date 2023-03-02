package com.kir.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tb_entidad")
@Getter
@Setter
public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_entidad")
    private Long id_entidad;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    private Documento documento;

    @Column(unique = true, length = 25, nullable = false)
    private String nro_documento;

    @Column(length = 100, nullable = false)
    private String razon_social;

    @Column(length = 100,  nullable = true, columnDefinition = "varchar default NULL")
    private String nombre_comercial;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_contribuyente",
            referencedColumnName = "id_tipo_contribuyente")
    private Contribuyente contribuyente;

    @Column(length = 250, nullable = true, columnDefinition = "varchar default NULL")
    private String direccion;

    @Column(length = 50, nullable = true, columnDefinition = "varchar default NULL")
    private String telefono;

    @Column(columnDefinition = "boolean  default true")
    private Boolean estado;


}
