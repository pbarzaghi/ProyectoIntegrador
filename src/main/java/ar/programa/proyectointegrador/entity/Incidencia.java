package ar.programa.proyectointegrador.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="incidencia")
/**
 @author pabloBarzaghi
 */
public class Incidencia extends BaseEntity {

  @Column(name="alias")
    private String alias;
    @Column(name="descripcion")
    private String descripcion;
    //@Column(name="fechaEstimada")
    private LocalDateTime fechaEstimada;

    @Column(name="resuelto")
    private Boolean resuelto;


    @OneToMany
    List<IncidenciaDetalle> incidenciaDetalles;


    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName="id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="tipoProblema_id", referencedColumnName="id")
    private  TipoProblema tipoProblema;

    @ManyToOne
    @JoinColumn(name="tecnico_id", referencedColumnName="id")
    private  Tecnico tecnico;



}
