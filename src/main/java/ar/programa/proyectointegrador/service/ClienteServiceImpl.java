package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 @author pabloBarzaghi
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<Cliente> findAll() throws Exception {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) throws Exception {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> findById(Integer integer) throws Exception {
        return clienteRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        clienteRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() throws Exception {
        clienteRepository.deleteAll();
    }
}
