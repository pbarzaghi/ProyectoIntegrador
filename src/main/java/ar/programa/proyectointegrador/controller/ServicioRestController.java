package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import ar.programa.proyectointegrador.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class ServicioRestController {


    @Autowired
    private ServicioService servicioService;

    @Autowired
    private IncidenciaDetalleService incidenciaDetalleService;
    @PostMapping("/Servicio")
    public Servicio CreateServicio(@Validated @RequestBody Map<String, Object> body) {

        String nombre= String.valueOf(body.get("nombre"));


        Servicio servicio=new Servicio();

        servicio.setNombre(nombre);

        return  servicioService.save(servicio);
    }

    @PutMapping("/ServicioDetalleincidencia/{id}")
    public String updateServicioDetalleIncidencia(@Validated @RequestBody Map<String,Object> body,
                                          @PathVariable("id") Integer id){
        Servicio servicio=servicioService.findById(id).get();
        if(servicio!= null){
            String idDetalleIncidencia=String.valueOf(body.get("idDetalleIncidencia"));
            DetalleIncidencia detalleIncidencia=  incidenciaDetalleService.findById(Integer.valueOf(idDetalleIncidencia)).get();
            servicio= servicioService.addDetalleIncidencia(servicio,detalleIncidencia);
            if(servicio!=null)
                return "OK - Detalle de Incidencia "+ idDetalleIncidencia +" se agregado al servicio "+id;
        }

        return "Fallo - No se agrego la Detalle de incidencia al servicio "+id;

    }

}
