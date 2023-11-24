package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class ServicioServiceImpl implements ServicioService {
    @Autowired
    ServicioRepository servicioRepository;
    @Override
    public List<Servicio> findAll()  {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio save(Servicio servicio)  {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio update(Servicio servicio)  {
        return servicioRepository.save(servicio);
    }

    @Override
    public Optional<Servicio> findById(Integer integer)  {
        return servicioRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer)  {
        servicioRepository.deleteById(integer);
    }

    @Override
    public void deleteAll()  {
        servicioRepository.deleteAll();
    }
}
