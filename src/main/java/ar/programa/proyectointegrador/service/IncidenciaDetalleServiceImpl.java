package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.IncidenciaDetalle;
import ar.programa.proyectointegrador.repository.IncidenciaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class IncidenciaDetalleServiceImpl implements IncidenciaDetalleService{
    @Autowired
    IncidenciaDetalleRepository incidenciaDetalleRepository;
    @Override
    public List<IncidenciaDetalle> findAll() {
        return incidenciaDetalleRepository.findAll();
    }

    @Override
    public IncidenciaDetalle save(IncidenciaDetalle incidenciaDetalle)  {
        return incidenciaDetalleRepository.save(incidenciaDetalle);
    }

    @Override
    public IncidenciaDetalle update(IncidenciaDetalle incidenciaDetalle) {
        return incidenciaDetalleRepository.save(incidenciaDetalle);
    }

    @Override
    public Optional<IncidenciaDetalle> findById(Integer integer)  {
        return incidenciaDetalleRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer)  {
        incidenciaDetalleRepository.deleteById(integer);
    }

    @Override
    public void deleteAll()  {
        incidenciaDetalleRepository.deleteAll();
    }
}
