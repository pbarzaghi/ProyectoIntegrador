package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Incidencia;
/**
 @author pabloBarzaghi
 */
public interface IncidenciaService extends CrudService<Incidencia,Integer> {

    public Incidencia addDetalleIncidencia(Incidencia incidencia,DetalleIncidencia detalleIncidencia) ;

}
