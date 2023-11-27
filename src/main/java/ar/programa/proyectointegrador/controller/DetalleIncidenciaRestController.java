package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
public class DetalleIncidenciaRestController {
    @Autowired
    IncidenciaDetalleService incidenciaDetalleService;

    @PostMapping("/DetalleIncidencia")
    DetalleIncidencia CreateDetalleIncidencia(@Validated @RequestBody Map<String, Object> body) {

        String descripcionProblema= String.valueOf(body.get("descripcionProblema"));
        String detalleProblema= String.valueOf(body.get("detalleProblema"));
        Boolean resuelto=  Boolean.valueOf((String) body.get("resuelto"));
       DetalleIncidencia detalleIncidencia =new DetalleIncidencia();
        detalleIncidencia.setDescripcionProblema(descripcionProblema);
        detalleIncidencia.setDetalleProblema(detalleProblema);
         return  incidenciaDetalleService.save(detalleIncidencia);

    }
}
