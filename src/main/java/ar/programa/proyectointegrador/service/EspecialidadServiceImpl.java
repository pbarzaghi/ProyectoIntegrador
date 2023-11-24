package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class EspecialidadServiceImpl implements EspecialidadService {
    @Autowired
    EspecialidadRepository especialidadRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }
    @Transactional
    @Override
    public Especialidad save(Especialidad especialidad)   {
        return especialidadRepository.save(especialidad);
    }
    @Transactional
    @Override
    public Especialidad update(Especialidad especialidad)   {
        return especialidadRepository.save(especialidad);
    }
    @Transactional
    @Override
    public Optional<Especialidad> findById(Integer integer)  {
        return especialidadRepository.findById(integer);
    }
    @Transactional
    @Override
    public void deleteById(Integer integer)  {
        especialidadRepository.deleteById(integer);
    }
    @Transactional
    @Override
    public void deleteAll()  {
        especialidadRepository.deleteAll();
    }
}
