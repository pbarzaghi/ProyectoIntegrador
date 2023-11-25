package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.TipoProblema;
/**
 @author pabloBarzaghi
 */
public interface TipoProblemaService extends CrudService<TipoProblema,Integer>{
    public TipoProblema addEspecialidad(TipoProblema tipoProblema, Especialidad especialidad  );
    public TipoProblema addIncidencia(TipoProblema tipoProblema, Incidencia incidencia  );
}
