package ar.programa.proyectointegrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany
    List<Incidencia> incidencias;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "tecnico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
    List<Especialidad> especialidades;


}
