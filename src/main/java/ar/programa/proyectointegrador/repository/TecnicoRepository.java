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

   /* QRY  Quien fue el tecnico con mas incidentes resueltos  en los ultimos N dias
    */
   @Query (" SELECT t FROM Tecnico as t "+
               " JOIN ( SELECT i.tecnico, COUNT( i.tecnico) AS cantidad "+
                  " FROM Incidencia as i"+
                 " WHERE i.resuelto = TRUE "+
                " AND i.fechaestimada BETWEEN :fechaInicio AND :fechaFin "+
               " GROUP BY i.tecnico ORDER BY cantidad DESC) "+
             " ON t.id = i.tecnico" )


    //@Query( " SELECT  t FROM Tecnico  t")
    public List<Tecnico> findAllTecnicosByIncidenciaResueltaEntreFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                                        @Param("fechaFin")LocalDateTime fechaFin);



     /*  QRY  Quien fue el tecnico con mas incidentes resueltos de una determinada
              especialidad en los ultimos N dias

     SELECT t.*
FROM Tecnico t
JOIN (
  SELECT TE.tecnico_id
  FROM tecnico_especialidad TE
  WHERE TE.especialidad_id IN (SELECT ID FROM ESPECIALIDAD WHERE NOMBRE = 'SAP')
) AS TE ON t.id = TE.tecnico_id
JOIN (
  SELECT i.tecnico_id, COUNT(i.tecnico_id) AS cantidad
  FROM Incidencia i
  WHERE i.resuelto = TRUE
  GROUP BY i.tecnico_id
) AS i ON t.id = i.tecnico_id
ORDER BY i.cantidad DESC;
      */

    @Query( " Select t from Tecnico  t")  //qry para que no tiree error
    public List<Tecnico> findAllTecnicosByIncidenciaResueltaEntreFechasEspecialidad(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                                        @Param("fechaFin") LocalDateTime fechaFin,
                                                                         @Param("nombreEsp") String nombreEsp);

}
