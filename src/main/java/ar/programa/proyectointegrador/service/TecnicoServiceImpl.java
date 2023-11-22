package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class TecnicoServiceImpl implements TecnicoService{
    @Autowired
    TecnicoRepository tecnicoRepository;
    @Override
    public List<Tecnico> findAll() throws Exception {
        return tecnicoRepository.findAll();
    }

    @Override
    public Tecnico save(Tecnico tecnico) throws Exception {
        return tecnicoRepository.save(tecnico);
    }

    @Override
    public Tecnico update(Tecnico tecnico) throws Exception {
        return tecnicoRepository.save(tecnico);
    }

    @Override
    public Optional<Tecnico> findById(Integer integer) throws Exception {
        return tecnicoRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        tecnicoRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() throws Exception {
        tecnicoRepository.deleteAll();
    }
}
