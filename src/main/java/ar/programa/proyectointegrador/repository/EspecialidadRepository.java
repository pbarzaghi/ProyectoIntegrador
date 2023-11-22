package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 @author pabloBarzaghi
 */
@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Integer> {
}
