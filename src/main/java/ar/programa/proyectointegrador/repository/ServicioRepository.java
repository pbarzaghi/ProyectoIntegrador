package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 @author pabloBarzaghi
 */
@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Integer> {
}
