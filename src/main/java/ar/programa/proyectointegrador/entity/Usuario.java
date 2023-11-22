package ar.programa.proyectointegrador.entity;

import ar.programa.proyectointegrador.enumerado.TipoUsuarioEmun;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table (name="usuario")
/**
 @author pabloBarzaghi
 */

public class Usuario extends BaseEntity{


    @Column(name="username")
    private String nombreUsuario;

    @Column(name="password")
    private String pass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipoUsuario_id",referencedColumnName = "id")
    private TipoUsuario tipoUsuario;


}
