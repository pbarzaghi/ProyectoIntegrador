package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.TipoProblema;
import ar.programa.proyectointegrador.repository.TipoProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class TipoProblemaServiceImpl implements TipoProblemaService{
   @Autowired
    TipoProblemaRepository tipoProblemaRepository;
    @Override
    public List<TipoProblema> findAll()  {
        return tipoProblemaRepository.findAll();
    }

    @Override
    public TipoProblema save(TipoProblema tipoProblema)  {
        return tipoProblemaRepository.save(tipoProblema);
    }

    @Override
    public TipoProblema update(TipoProblema tipoProblema)  {
        return tipoProblemaRepository.save(tipoProblema);
    }

    @Override
    public Optional<TipoProblema> findById(Integer integer)  {
        return tipoProblemaRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        tipoProblemaRepository.deleteById(integer);
    }

    @Override
    public void deleteAll()  {
        tipoProblemaRepository.deleteAll();
    }
}
