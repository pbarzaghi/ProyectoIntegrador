package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EspecialidadRestController {

    @Autowired
    EspecialidadService especialidadService;

    @PostMapping("/Especialidad")
    public Especialidad CreateEspecialidad(@Validated @RequestBody Map<String, Object> body) {

        String nombre= String.valueOf(body.get("nombre"));


        Especialidad especialidad=new Especialidad();

        especialidad.setNombre(nombre);

        return  especialidadService.save(especialidad);
    }
}
