package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.IncidenciaDto;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Incidencia;

import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class IncidenciaRestController {

    @Autowired
    IncidenciaService incidenciaService;

    @Autowired
    private IncidenciaDetalleService incidenciaDetalleService;

    @PostMapping("/incidencia")
    public IncidenciaDto CreateIncidencia(@Validated @RequestBody Map<String, Object> body) {

        String alias= String.valueOf(body.get("alias"));
        String descripcion= String.valueOf(body.get("descripcion"));
        String fechaestimada= String.valueOf(body.get("fechaestimada"));
        String strResuelto=  String.valueOf(body.get("resuelto"));

        Incidencia incidenciaCreate=new Incidencia();
        incidenciaCreate.setAlias(alias);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime fecha= LocalDateTime.parse(fechaestimada,formatter);
        incidenciaCreate .setDescripcion(descripcion);

        incidenciaCreate.setFechaEstimada( LocalDateTime.parse(fechaestimada,formatter));
        if ("TRUE".equals(strResuelto))
           incidenciaCreate.setResuelto(Boolean.TRUE );
        else
             incidenciaCreate.setResuelto(Boolean.FALSE);

        incidenciaCreate=incidenciaService.save(incidenciaCreate);
        return IncidenciaDto.builder().alias(incidenciaCreate.getAlias())
                .descripcion(incidenciaCreate.getDescripcion())
                .fechaEstimada(incidenciaCreate.getFechaEstimada())
                .resuelto(incidenciaCreate.getResuelto())
                .build();
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

    @PutMapping("/incidencia/{id}")
    public IncidenciaDto updateIncidencia(@Validated @RequestBody Map<String, Object> body,
                                               @PathVariable("id") Integer id) {

        Incidencia incidenciaUpdate = incidenciaService.findById(id).get();
        String alias= String.valueOf(body.get("alias"));
        String descripcion= String.valueOf(body.get("descripcion"));
        String fechaestimada= String.valueOf(body.get("fechaestimada"));
        String strResuelto=String.valueOf(body.get("resuelto"));
      //  Boolean resuelto=  Boolean.valueOf((String) body.get("resuelto"));

        if(! alias.isEmpty())
            incidenciaUpdate.setAlias(alias);
        if (! descripcion.isEmpty())
           incidenciaUpdate.setDescripcion(descripcion);
        if (! fechaestimada.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            incidenciaUpdate.setFechaEstimada(LocalDateTime.parse(fechaestimada,formatter));
        }
        if (! strResuelto.isEmpty() )
            incidenciaUpdate.setResuelto(Boolean.valueOf(strResuelto));


        return IncidenciaDto.builder().alias(incidenciaUpdate.getAlias())
                .descripcion(incidenciaUpdate.getDescripcion())
                .fechaEstimada(incidenciaUpdate.getFechaEstimada())
                .resuelto(incidenciaUpdate.getResuelto())
                .build();


    }
    // Listar
    @GetMapping("/incidencias")
    public List<IncidenciaDto> getAllIncidencias() {
        List<Incidencia> incidenciaList = incidenciaService.findAll();

        return incidenciaList.stream()
                .map(t ->IncidenciaDto.builder()
                        .alias(t.getAlias())
                        .descripcion(t.getDescripcion())
                        .fechaEstimada(t.getFechaEstimada())
                        .resuelto(t.getResuelto())
                        .build())
                .collect(Collectors.toList());
    }


    // Delete
    @DeleteMapping("/incidencia/{id}")
    public String deleteIncidenciaoById(@PathVariable("id") Integer id){
        incidenciaService.deleteById(id);
        return "Incidencia eliminada correctamente";
    }

}
