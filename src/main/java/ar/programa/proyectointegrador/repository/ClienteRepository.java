package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 @author pabloBarzaghi
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
