package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.*;
import ar.programa.proyectointegrador.service.EspecialidadService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import ar.programa.proyectointegrador.service.TipoProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Map;

@RestController
public class TipoProblemaRestController {
    @Autowired
    TipoProblemaService tipoProblemaService;
    @Autowired
    EspecialidadService especialidadService;

    @Autowired
    IncidenciaService incidenciaService;

    @PostMapping("/Tipoproblema")
    public TipoProblema CreateTipoproblema(@Validated @RequestBody Map<String, Object> body) {

        String tiempoEstimado= String.valueOf(body.get("tiempoEstimado"));
        String tipo=String.valueOf(body.get("tipo"));

        TipoProblema tipoProblema=new TipoProblema();
        tipoProblema.setTiempoEnDias(Integer.valueOf(tiempoEstimado));
        tipoProblema.setTipo(tipo);
        return tipoProblemaService.save(tipoProblema);

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



}

