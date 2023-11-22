package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author  pabloBarzaghi
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
