package ar.programa.proyectointegrador.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@Entity
@Table(name="detalleincidencia")
/**
 @author pabloBarzaghi
 */
public class IncidenciaDetalle  extends BaseEntity{



    @ManyToOne
    @JoinColumn(name="incidencia_id", referencedColumnName="id")
    private Incidencia incidencia;

    @ManyToOne
    @JoinColumn(name="servicio_id", referencedColumnName="id")
    private Servicio servicio;



    @Column(name="detalleProblema")
    private String detalleProblema;

    @Column(name="descripcionProblema")

    private String descripcionProblema;
    @Column(name="resuelto")
    private Boolean resuelto;
}


