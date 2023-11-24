package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Usuario;
import ar.programa.proyectointegrador.repository.UsuarioRepository;
import ar.programa.proyectointegrador.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll()  {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public Usuario update(Usuario usuario)  {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Integer integer)  {
        return usuarioRepository.findById(integer);
    }

    @Transactional
    @Override
    public void deleteById(Integer integer)  {
        usuarioRepository.deleteById(integer);
    }

    @Transactional
    public void deleteAll()   {
        usuarioRepository.deleteAll();
    }
}
