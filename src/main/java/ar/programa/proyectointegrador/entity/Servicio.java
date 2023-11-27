package ar.programa.proyectointegrador.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="servicio")
/**
 @author pabloBarzaghi
 */
public class Servicio extends BaseEntity {


    @Column(name = "nombre")
    private String nombre;

    @JsonManagedReference
    @ManyToMany(mappedBy = "servicios")
    List<Cliente> clientes;

    @OneToMany
    List<DetalleIncidencia> detalleincidencia;


}
