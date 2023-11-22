package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 @author pabloBarzaghi
 */
@Repository
public interface IncidenciaReprository extends JpaRepository<Incidencia,Integer> {
}
