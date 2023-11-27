package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
/**
 @author pabloBarzaghi
 */
public interface ServicioService extends CrudService<Servicio,Integer> {
    public Servicio addDetalleIncidencia(Servicio servicio, DetalleIncidencia detalleIncidencia) ;

}
