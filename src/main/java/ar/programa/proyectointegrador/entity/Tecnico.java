package ar.programa.proyectointegrador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter

@Entity
@Table(name="tecnico")
/**
 @author pabloBarzaghi
 */
public class Tecnico extends BaseEntity{


    @Column(name="nombre")
    private String nombre;
    @Column(name="mail")
    private String mail;
    @Column(name="numTelefono")
    private String nroTel;

    @OneToMany
    List<Incidencia> incidencias;


}
