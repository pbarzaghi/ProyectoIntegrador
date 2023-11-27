package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 @author pabloBarzaghi
 */
@Repository
public interface IncidenciaDetalleRepository extends JpaRepository<DetalleIncidencia,Integer> {
}
