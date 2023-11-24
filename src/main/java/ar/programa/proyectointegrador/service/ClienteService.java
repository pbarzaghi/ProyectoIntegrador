package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.entity.Tecnico;

/**
 @author pabloBarzaghi
 */
public interface ClienteService extends CrudService<Cliente,Integer> {
    public Cliente addIncidencia(Cliente cliente, Incidencia incidencia  );
    public Cliente addServicio(Cliente cliente, Servicio servicio  );
}
