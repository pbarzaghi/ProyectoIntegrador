package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.ServicioDto;
import ar.programa.proyectointegrador.dto.TipoProblemaDto;
import ar.programa.proyectointegrador.entity.*;
import ar.programa.proyectointegrador.service.EspecialidadService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import ar.programa.proyectointegrador.service.TipoProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TipoProblemaRestController {
    @Autowired
    TipoProblemaService tipoProblemaService;
    @Autowired
    EspecialidadService especialidadService;

    @Autowired
    IncidenciaService incidenciaService;

    @PostMapping("/tipoproblema")
    public TipoProblemaDto CreateTipoproblema(@Validated @RequestBody Map<String, Object> body) {

        String tiempoEstimado= String.valueOf(body.get("tiempoEstimado"));
        String tipo=String.valueOf(body.get("tipo"));

        TipoProblema tipoProblemaCreate=new TipoProblema();
        tipoProblemaCreate.setTiempoEnDias(Integer.valueOf(tiempoEstimado));
        tipoProblemaCreate.setTipo(tipo);
        tipoProblemaCreate =tipoProblemaService.save(tipoProblemaCreate);
        return TipoProblemaDto.builder()
                .tipo(tipoProblemaCreate.getTipo())
                .tiempoEnDias(tipoProblemaCreate.getTiempoEnDias())
                .build();

    }

    // Update
    @PutMapping("/TipoProblemaEspecialidad/{id}")
    public String updateTipoProblemaEspecialidad(@Validated @RequestBody Map<String,Object> body,
                                        @PathVariable("id") Integer id){
        TipoProblema tipoProblema= tipoProblemaService.findById(id).get();
        if(tipoProblema!= null){
            String idEspecialidad=String.valueOf(body.get("idEspecialidad"));
            Especialidad especialidad=  especialidadService.findById(Integer.valueOf(idEspecialidad)).get();
            tipoProblema= tipoProblemaService.addEspecialidad(tipoProblema,especialidad);
            if(tipoProblema!=null)
                return "OK - La especialidad "+ idEspecialidad +" tiene agregado  tipo de problema  "+id;
        }

        return "Fallo - No se agrego el servicio al cliente "+id;

    }

    @PutMapping("/TipoproblemaIncidencia/{id}")
    public String updateTipoProblemaIncidencia(@Validated @RequestBody Map<String,Object> body,
                                          @PathVariable("id") Integer id){
        TipoProblema tipoProblema=tipoProblemaService.findById(id).get();
        if(tipoProblema != null){
            String idIncidencia=String.valueOf(body.get("idIncidencia"));
            Incidencia incidencia=  incidenciaService.findById(Integer.valueOf(idIncidencia)).get();
            tipoProblema= tipoProblemaService.addIncidencia(tipoProblema,incidencia);

            if(tipoProblema!=null) {
                          return "OK - Incidencia " + idIncidencia + " se agregado al tipo problema " + id;
            }
        }

        return "Fallo - No se agrego la incidencia al tipo de problema "+id;

    }

    @PutMapping("/tipoproblema/{id}")
    public TipoProblemaDto updateTipoproblema(@Validated @RequestBody Map<String, Object> body,
                                     @PathVariable("id") Integer id) {

        TipoProblema tipoProblemaUpdate = tipoProblemaService.findById(id).get();
        String tiempoEstimado= String.valueOf(body.get("tiempoEstimado"));
        String tipo=String.valueOf(body.get("tipo"));

        if(! tipo.isEmpty())
            tipoProblemaUpdate.setTipo(tipo);

        if(! tiempoEstimado.isEmpty())
            tipoProblemaUpdate.setTiempoEnDias(Integer.valueOf(tiempoEstimado));

        tipoProblemaUpdate= tipoProblemaService.update(tipoProblemaUpdate);

        return TipoProblemaDto.builder()
                        .tipo(tipoProblemaUpdate.getTipo())
                                .tiempoEnDias(tipoProblemaUpdate.getTiempoEnDias())
                                .build();



    }


    @GetMapping("/tipoproblemas")
    public List<TipoProblemaDto> getAllTipoProblemas() {
        List<TipoProblema> tipoProblemaList = tipoProblemaService.findAll();

        return tipoProblemaList.stream()
                .map(t -> TipoProblemaDto.builder()
                        .tipo(t.getTipo())
                        .tiempoEnDias(t.getTiempoEnDias())
                        .build())
                .collect(Collectors.toList());
    }
    @DeleteMapping("/tipoproblema/{id}")
    public String deleteTipoProblemaById(@PathVariable("id") Integer id){
        tipoProblemaService.deleteById(id);
        return "Tipo de problema fue eliminado correctamente";
    }



}

