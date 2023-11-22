package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 @author pabloBarzaghi
 */
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
}
