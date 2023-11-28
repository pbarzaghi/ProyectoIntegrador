package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.*;

import java.util.List;

/**
 @author pabloBarzaghi
 */
public interface TecnicoService extends CrudService<Tecnico,Integer> {

      public Tecnico addIncidencia(Tecnico tecnico, Incidencia incidencia  );
      public Tecnico addEspecialidad(Tecnico tecnico, Especialidad especialidad  );

      List<Tecnico> findTecnicosConMasIncidentesResueltosEnNDias(Integer dias);
      List<Tecnico> findTecnicosConMasIncidentesResueltosEnNDiasEspecialidad(Integer dias,Integer idEsp);

      List<Tecnico> findTecnicoMasRapidoResolvioLaIncidencia() ;

}
