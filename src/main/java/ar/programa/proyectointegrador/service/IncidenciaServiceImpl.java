package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.repository.IncidenciaReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class IncidenciaServiceImpl implements IncidenciaService{
    @Autowired
    IncidenciaReprository incidenciaReprository;
    @Override
    public List<Incidencia> findAll() throws Exception {
        return incidenciaReprository.findAll();
    }

    @Override
    public Incidencia save(Incidencia incidencia) throws Exception {
        return incidenciaReprository.save(incidencia);
    }

    @Override
    public Incidencia update(Incidencia incidencia) throws Exception {
        return incidenciaReprository.save(incidencia);
    }

    @Override
    public Optional<Incidencia> findById(Integer integer) throws Exception {
        return incidenciaReprository.findById(integer );
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        incidenciaReprository.deleteById(integer);
    }

    @Override
    public void deleteAll() throws Exception {
        incidenciaReprository.deleteAll();
    }
}
