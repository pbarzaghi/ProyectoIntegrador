package ar.programa.proyectointegrador.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @ManyToMany(mappedBy = "especialidades")
    List<TipoProblema> tipoProblemas;

    @JsonManagedReference
    @ManyToMany(mappedBy = "especialidades")
    List<Tecnico> tecnicos;

}
