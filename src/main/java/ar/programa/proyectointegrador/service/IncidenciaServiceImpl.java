package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.repository.IncidenciaReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
public class IncidenciaServiceImpl implements IncidenciaService{
    @Autowired
    IncidenciaReprository incidenciaReprository;
    @Override
    public List<Incidencia> findAll()   {
        return incidenciaReprository.findAll();
    }

    @Override
    public Incidencia save(Incidencia incidencia)  {
        return incidenciaReprository.save(incidencia);
    }

    @Override
    public Incidencia update(Incidencia incidencia)   {
        return incidenciaReprository.save(incidencia);
    }

    @Override
    public Optional<Incidencia> findById(Integer integer)  {
        return incidenciaReprository.findById(integer );
    }

    @Override
    public void deleteById(Integer integer)  {
        incidenciaReprository.deleteById(integer);
    }

    @Override
    public void deleteAll()  {
        incidenciaReprository.deleteAll();
    }

    @Override
    public Incidencia addDetalleIncidencia(Incidencia incidencia, DetalleIncidencia detalleIncidencia) {
        List<DetalleIncidencia> detalleIncidenciaList=incidencia.getDetalleincidencia();

        if(! detalleIncidenciaList.contains(detalleIncidencia)) {
            detalleIncidenciaList.add(detalleIncidencia);
            incidencia.setDetalleincidencia(detalleIncidenciaList);
            if( detalleIncidencia.getResuelto() == null)
                detalleIncidencia.setResuelto(Boolean.FALSE);
            incidencia.setResuelto(detalleIncidencia.getResuelto());
            detalleIncidencia.setIncidencia(incidencia);
            return incidenciaReprository.save(incidencia);
        }
        return null;
    }
}
