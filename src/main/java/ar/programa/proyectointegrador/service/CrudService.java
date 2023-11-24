package ar.programa.proyectointegrador.service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author pbarzaghi
 */
public interface CrudService<T,ID> {
    List<T> findAll() ;
    T save(T t);
    T update(T t);
    Optional<T> findById(ID id) ;
    void deleteById(ID id);
    void deleteAll() ;



}