package ar.programa.proyectointegrador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter


@Entity
@Table(name="tipoproblema")
/**
 @author pabloBarzaghi
 */
public class TipoProblema extends BaseEntity{


    @Column(name="tipo")
    private String tipo;
    @Column(name="tiempoEstimadoDias")
    private Integer tiempoEnDias;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tipoproblema_especialidad",
            joinColumns = @JoinColumn(name = "tipoProblema_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
     List<Especialidad> especialidades;


    @OneToMany
    List<Incidencia> incidencias;





}
