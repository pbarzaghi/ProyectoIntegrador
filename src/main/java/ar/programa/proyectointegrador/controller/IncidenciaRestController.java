package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Incidencia;

import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
public class IncidenciaRestController {

    @Autowired
    IncidenciaService incidenciaService;

    @Autowired
    private IncidenciaDetalleService incidenciaDetalleService;

    @PostMapping("/Incidencia")
    public Incidencia CreateIncidencia(@Validated @RequestBody Map<String, Object> body) {

        String alias= String.valueOf(body.get("alias"));
        String descripcion= String.valueOf(body.get("descripcion"));
        String fechaestimada= String.valueOf(body.get("fechaestimada"));
        Boolean resuelto=  Boolean.valueOf((String) body.get("resuelto"));

        Incidencia incidencia=new Incidencia();
        incidencia.setAlias(alias);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        incidencia.setDescripcion(descripcion);
        LocalDateTime fecha= LocalDateTime.parse(fechaestimada,formatter);
        incidencia.setFechaEstimada(fecha);
        if(resuelto)
        incidencia.setResuelto(Boolean.TRUE );
        else
            incidencia.setResuelto(Boolean.FALSE);
       return  incidenciaService.save(incidencia);
    }

    @PutMapping("/IncidenciaDetalleincidencia/{id}")
    public String updateIncidenciaoDetalleIncidencia(@Validated @RequestBody Map<String,Object> body,
                                                  @PathVariable("id") Integer id){
        Incidencia incidencia=incidenciaService.findById(id).get();
        if(incidencia!= null){
            String idDetalleIncidencia=String.valueOf(body.get("idDetalleIncidencia"));
            DetalleIncidencia detalleIncidencia=  incidenciaDetalleService.findById(Integer.valueOf(idDetalleIncidencia)).get();
            incidencia= incidenciaService.addDetalleIncidencia(incidencia,detalleIncidencia);
            if(incidencia!=null)
                return "OK - Detalle de Incidencia "+ idDetalleIncidencia +" se agregado al Incidente "+id;
        }

        return "Fallo - No se agrego la Detalle de incidencia al Incidente "+id;

    }

}
