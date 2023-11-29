package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.ServicioDto;
import ar.programa.proyectointegrador.entity.*;
import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import ar.programa.proyectointegrador.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ServicioRestController {


    @Autowired
    private ServicioService servicioService;

    @Autowired
    private IncidenciaDetalleService incidenciaDetalleService;
    @PostMapping("/servicio")
    public ServicioDto CreateServicio(@Validated @RequestBody Map<String, Object> body) {

        String nombre= String.valueOf(body.get("nombre"));


        Servicio servicioCreate=new Servicio();

        servicioCreate.setNombre(nombre);
        servicioCreate= servicioService.save(servicioCreate);
        return ServicioDto.builder().nombre(servicioCreate.getNombre()).build();
    }

    @PutMapping("/servicioDetalleincidencia/{id}")
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

    @PutMapping("/servicio/{id}")
    public ServicioDto updateService(@Validated @RequestBody Map<String, Object> body,
                                    @PathVariable("id") Integer id) {

        Servicio servicioUpdate = servicioService.findById(id).get();
        String nombre= String.valueOf(body.get("nombre"));

        if(! nombre.isEmpty())
            servicioUpdate.setNombre(nombre);

        servicioUpdate= servicioService.update(servicioUpdate);

        return ServicioDto.builder().nombre(servicioUpdate.getNombre()).build();



    }

    @GetMapping("/servicios")
    public List<ServicioDto> getAllServicios() {
        List<Servicio> servicioList = servicioService.findAll();

        return servicioList.stream()
                .map(t -> ServicioDto.builder()
                        .nombre(t.getNombre())
                       .build())
                .collect(Collectors.toList());
    }

    @DeleteMapping("/servicio/{id}")
    public String deleteServicioById(@PathVariable("id") Integer id){
        servicioService.deleteById(id);
        return "Servicio eliminado correctamente";
    }


}
