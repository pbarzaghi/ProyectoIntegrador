package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class EspecialidadServiceImpl implements EspecialidadService {
    @Autowired
    EspecialidadRepository especialidadRepository;
    @Override
    public List<Especialidad> findAll() throws Exception {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad save(Especialidad especialidad) throws Exception {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad update(Especialidad especialidad) throws Exception {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Optional<Especialidad> findById(Integer integer) throws Exception {
        return especialidadRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        especialidadRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() throws Exception {
        especialidadRepository.deleteAll();
    }
}
