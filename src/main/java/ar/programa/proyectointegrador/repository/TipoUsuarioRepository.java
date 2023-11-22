package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 @author pabloBarzaghi
 */
@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer> {
}
