package ar.programa.proyectointegrador.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@Entity
@Table(name="tipousuario")
/**
 @author pabloBarzaghi
 */
public class TipoUsuario extends BaseEntity{


    @Column(name = "tipo")
    private String tipo;


}
