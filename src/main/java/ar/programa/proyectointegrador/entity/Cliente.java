package ar.programa.proyectointegrador.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter

@Entity
@Table(name="cliente")
/**
 @author pabloBarzaghi
 */
public class Cliente extends BaseEntity {


    @Column(name="razonSocial")
    private String razonSocial;

    @Column(name="CUIT")
    private String cuit;

    @Column(name="mail")
    private String mail;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    List<Servicio> servicios;

    @OneToMany(fetch = FetchType.LAZY)
    List<Incidencia> incidencias;



}
