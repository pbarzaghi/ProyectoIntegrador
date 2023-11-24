package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class TecnicoServiceImpl implements TecnicoService{
    @Autowired
    TecnicoRepository tecnicoRepository;
    @Transactional
    @Override
    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }
    @Transactional
    @Override
    public Tecnico save(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    @Transactional
     @Override
    public Tecnico update(Tecnico tecnico)  {
        return tecnicoRepository.save(tecnico);
    }

    @Transactional
    @Override
    public Optional<Tecnico> findById(Integer integer)  {
        return tecnicoRepository.findById(integer);
    }
    @Transactional
    @Override
    public void deleteById(Integer integer)  {
        tecnicoRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() {
        tecnicoRepository.deleteAll();
    }
@Transactional
    @Override
    public Tecnico addIncidencia(Tecnico tecnico, Incidencia incidencia) {
        List<Incidencia> listIncidencias=tecnico.getIncidencias();
       if(!listIncidencias.contains(incidencia)) {
            listIncidencias.add(incidencia);
            tecnico.setIncidencias(listIncidencias);
             return tecnicoRepository.save(tecnico);
        }
        return null;
    }
    @Transactional
    @Override
    public Tecnico addEspecialidad(Tecnico tecnico, Especialidad especialidad) {
        List<Especialidad> listEspecialidades=tecnico.getEspecialidad();
        if(!listEspecialidades.contains(especialidad)) {
            listEspecialidades.add(especialidad);
            tecnico.setEspecialidad(listEspecialidades);
            return tecnicoRepository.save(tecnico);
        }

     return null;
    }


}
