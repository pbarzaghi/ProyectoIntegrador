package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.*;

/**
 @author pabloBarzaghi
 */
public interface TecnicoService extends CrudService<Tecnico,Integer> {

      public Tecnico addIncidencia(Tecnico tecnico, Incidencia incidencia  );
      public Tecnico addEspecialidad(Tecnico tecnico, Especialidad especialidad  );
}
