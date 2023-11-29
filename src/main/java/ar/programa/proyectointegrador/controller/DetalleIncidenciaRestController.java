package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.DetalleIncidenciaDto;
import ar.programa.proyectointegrador.dto.ServicioDto;
import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class DetalleIncidenciaRestController {
    @Autowired
    IncidenciaDetalleService incidenciaDetalleService;

    @PostMapping("/detalleIncidencia")
    public  DetalleIncidenciaDto CreateDetalleIncidencia(@Validated @RequestBody Map<String, Object> body) {

        String descripcionProblema= String.valueOf(body.get("descripcionProblema"));
        String detalleProblema= String.valueOf(body.get("detalleProblema"));
        Boolean resuelto=  Boolean.valueOf((String) body.get("resuelto"));
       DetalleIncidencia detalleIncidenciaCreate =new DetalleIncidencia();
        detalleIncidenciaCreate.setDescripcionProblema(descripcionProblema);
        detalleIncidenciaCreate.setDetalleProblema(detalleProblema);
         detalleIncidenciaCreate=  incidenciaDetalleService.save(detalleIncidenciaCreate);
        return DetalleIncidenciaDto.builder()
                .detalleProblema(detalleIncidenciaCreate.getDetalleProblema())
                .descripcionProblema(detalleIncidenciaCreate.getDescripcionProblema())
                .resuelto(detalleIncidenciaCreate.getResuelto())
                .build();

    }

    @PutMapping("/detalleIncidencia/{id}")
    public DetalleIncidenciaDto updateDetalleIncidencia(@Validated @RequestBody Map<String, Object> body,
                                     @PathVariable("id") Integer id) {

        DetalleIncidencia detalleIncidenciaUpdate = incidenciaDetalleService.findById(id).get();
        String descripcionProblema= String.valueOf(body.get("descripcionProblema"));
        String detalleProblema= String.valueOf(body.get("detalleProblema"));

        String strResuelto= String.valueOf(body.get("resuelto"));

        if(! descripcionProblema.isEmpty())
            detalleIncidenciaUpdate.setDescripcionProblema(descripcionProblema);

        if(! detalleProblema.isEmpty())
            detalleIncidenciaUpdate.setDetalleProblema(detalleProblema);

        if(! strResuelto.isEmpty())
            detalleIncidenciaUpdate.setResuelto(Boolean.valueOf(strResuelto));

       detalleIncidenciaUpdate= incidenciaDetalleService.update(detalleIncidenciaUpdate);

        return DetalleIncidenciaDto.builder()
                .detalleProblema(detalleIncidenciaUpdate.getDetalleProblema())
                .descripcionProblema(detalleIncidenciaUpdate.getDescripcionProblema())
                .resuelto(detalleIncidenciaUpdate.getResuelto())
                .build();



    }

    @GetMapping("/detalleIncidencias")
    public List<DetalleIncidenciaDto> getAllDetalleIncidencias() {
        List<DetalleIncidencia> detalleIncidenciaList = incidenciaDetalleService.findAll();

        return detalleIncidenciaList.stream()
                .map(t -> DetalleIncidenciaDto.builder()
                        .detalleProblema(t.getDetalleProblema())
                        .descripcionProblema(t.getDescripcionProblema())
                        .resuelto(t.getResuelto())
                        .build())
                .collect(Collectors.toList());
    }


    @DeleteMapping("/detalleIncidencia/{id}")
    public String deleteServicioById(@PathVariable("id") Integer id){
        incidenciaDetalleService.deleteById(id);
        return "Detalle Incidencia fue eliminado correctamente";
    }
}
