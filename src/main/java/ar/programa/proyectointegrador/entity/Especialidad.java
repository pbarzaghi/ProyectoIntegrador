package ar.programa.proyectointegrador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="especialidad")
/**
 @author pabloBarzaghi
 */
public class Especialidad extends BaseEntity{


    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "especialidades")
    List<TipoProblema> tipoProblemas;


    @ManyToMany(mappedBy = "especialidad")
    List<Tecnico> tecnicos;

}
