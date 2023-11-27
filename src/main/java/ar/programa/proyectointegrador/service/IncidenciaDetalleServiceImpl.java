package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.repository.IncidenciaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<DetalleIncidencia> findAll() {
        return incidenciaDetalleRepository.findAll();
    }

    @Override
    public DetalleIncidencia save(DetalleIncidencia detalleIncidencia)  {
        return incidenciaDetalleRepository.save(detalleIncidencia);
    }

    @Override
    public DetalleIncidencia update(DetalleIncidencia detalleIncidencia) {
        return incidenciaDetalleRepository.save(detalleIncidencia);
    }

    @Override
    public Optional<DetalleIncidencia> findById(Integer integer)  {
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
