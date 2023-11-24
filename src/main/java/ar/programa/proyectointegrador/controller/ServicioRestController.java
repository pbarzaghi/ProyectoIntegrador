package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class ServicioRestController {


    @Autowired
    private ServicioService servicioService;
    @PostMapping("/Servicio")
    public Servicio CreateServicio(@Validated @RequestBody Map<String, Object> body) {

        String nombre= String.valueOf(body.get("nombre"));


        Servicio servicio=new Servicio();

        servicio.setNombre(nombre);

        return  servicioService.save(servicio);
    }
}
