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
    public List<Usuario> findAll() throws Exception {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario save(Usuario usuario) throws Exception {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario update(Usuario usuario) throws Exception {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Integer integer) throws Exception {
        return usuarioRepository.findById(integer);
    }

    @Transactional(readOnly = true)
    @Override
    public void deleteById(Integer integer) throws Exception {
        usuarioRepository.deleteById(integer);
    }

    @Transactional(readOnly = true)
    public void deleteAll() throws Exception {
        usuarioRepository.deleteAll();
    }
}
