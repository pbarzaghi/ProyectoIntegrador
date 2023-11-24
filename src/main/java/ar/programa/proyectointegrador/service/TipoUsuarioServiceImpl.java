package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.TipoUsuario;
import ar.programa.proyectointegrador.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{
    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;
    @Transactional(readOnly = true)
    @Override
    public List<TipoUsuario> findAll(){
        return tipoUsuarioRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }
    @Transactional(readOnly = true)
    @Override
    public TipoUsuario update(TipoUsuario tipoUsuario)  {
        return tipoUsuarioRepository.save(tipoUsuario);
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<TipoUsuario> findById(Integer integer)  {
        return tipoUsuarioRepository.findById(integer);
    }
    @Transactional
    @Override
    public void deleteById(Integer integer)  {
        tipoUsuarioRepository.findById(integer);
    }
    @Transactional
    @Override
    public void deleteAll() {
        tipoUsuarioRepository.deleteAll();
    }

}
