package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.TipoUsuario;
import ar.programa.proyectointegrador.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{
    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;
    @Override
    public List<TipoUsuario> findAll() throws Exception {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    public TipoUsuario save(TipoUsuario tipoUsuario) throws Exception {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public TipoUsuario update(TipoUsuario tipoUsuario) throws Exception {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public Optional<TipoUsuario> findById(Integer integer) throws Exception {
        return tipoUsuarioRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        tipoUsuarioRepository.findById(integer);
    }

    @Override
    public void deleteAll() throws Exception {
        tipoUsuarioRepository.deleteAll();
    }
}
