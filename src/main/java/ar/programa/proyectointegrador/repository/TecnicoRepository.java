package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 @author pabloBarzaghi
 */
@Repository
@Transactional
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {

   @Query (" SELECT t FROM Tecnico t "+
               " JOIN (SELECT i.tecnico_id, COUNT( i.tecnico_id) AS cantidad " +
                  " FROM Incidencia  i" +
                 " WHERE i.resuelto = TRUE " +
                " AND i.fecha_estimada BETWEEN :fechaInicio AND :fechaFin " +
               " GROUP BY i.tecnico_id ORDER BY cantidad DESC) " +
             " ON t.id = i.tecnico_id" )


    public List<Tecnico> findAllTecnicosByIncidenciaResueltaEntreFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                                        @Param("fechaFin")LocalDateTime fechaFin);





}
