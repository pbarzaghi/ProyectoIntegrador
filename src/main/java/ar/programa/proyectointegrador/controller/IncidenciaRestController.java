package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
public class IncidenciaRestController {

    @Autowired
    IncidenciaService incidenciaService;

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

       return  incidenciaService.save(incidencia);
    }
}
