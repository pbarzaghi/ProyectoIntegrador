package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
@EnableJpaRepositories
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {

   /* QRY  Quien fue el tecnico con mas incidentes resueltos  en los ultimos N dias
    */

    @Query("SELECT t FROM Tecnico as t "+
          " WHERE t.id = ( SELECT i.tecnico.id  FROM Incidencia i "+
                           " WHERE i.resuelto=TRUE "+
                             " AND i.fechaEstimada  BETWEEN :fechaInicio AND :fechaFin "+
                             " GROUP BY  i.tecnico.id ORDER BY  COUNT(i.id) DESC LIMIT 1 )")

   // @Query("Select t from Tecnico as t")
  public List<Tecnico> findAllTecnicosByIncidenciaResueltaEntreFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                                        @Param("fechaFin")LocalDateTime fechaFin);



     /*  QRY  Quien fue el tecnico con mas incidentes resueltos de una determinada
              especialidad en los ultimos N dias

     */

    @Query(value="SELECT * FROM Tecnico t " +
            "WHERE t.id in ( " +
            "  SELECT i.tecnico_id " +
            "  FROM Incidencia i " +
            "  WHERE i.resuelto = TRUE " +
            " AND i.fecha_Estimada  BETWEEN :fechaInicio AND :fechaFin "+
            "        and i.tecnico_id in( select tt.tecnico_id from tecnico_especialidad tt" +
                                        "   where tt.especialidad_id=:idEsp) " +
            "  GROUP BY i.tecnico_id " +
            "  ORDER BY COUNT(i.id) DESC " +
            ")",
            nativeQuery = true)
        /*    " SELECT t FROM Tecnico t "+
                    " WHERE t.id = ( "+
                    "  SELECT i.tecnico.id "+
                    " FROM Incidencia i "+
                    " WHERE i.resuelto = TRUE "+
                    " AND i.fechaEstimada BETWEEN :fechaInicio AND :fechaFin "+
                                   //     "  AND :objEspecialidad MEMBER OF i.tecnico.especialidades "+
                    " GROUP BY i.tecnico.id "+
                    " ORDER BY COUNT(i.id) DESC )")*/
     public List<Tecnico> findAllTecnicosByIncidenciaResueltaEntreFechasEspecialidad(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                                        @Param("fechaFin") LocalDateTime fechaFin,
                                                                         @Param("idEsp") Integer idEsp);

}
