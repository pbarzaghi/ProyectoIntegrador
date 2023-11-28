package ar.programa.proyectointegrador.controller;


import ar.programa.proyectointegrador.dto.TecnicoDto;
import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.service.EspecialidadService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import ar.programa.proyectointegrador.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TecnicoRestController {
    @Autowired
    TecnicoService tecnicoService;
    @Autowired
    EspecialidadService especialidadService;

    @Autowired
    IncidenciaService incidenciaService;

    @PostMapping("/tecnico")
    public TecnicoDto CreateTecnico(@Validated @RequestBody Map<String, Object> body) {

        String nombre = String.valueOf(body.get("nombre"));
        String mail = String.valueOf(body.get("mail"));
        String numTelefono = String.valueOf(body.get("numTelefono"));

        Tecnico tecnicoCreate = new Tecnico();
        tecnicoCreate.setNombre(nombre);
        tecnicoCreate.setMail(mail);
        tecnicoCreate.setNroTel(numTelefono);
        tecnicoCreate=tecnicoService.save(tecnicoCreate);

        return TecnicoDto.builder().nombre(tecnicoCreate.getNombre())
                .mail(tecnicoCreate.getMail())
                .nroTel(tecnicoCreate.getNroTel()).build();
    }

    @PutMapping("/tecnicoEspecialidad/{id}")
    public String updateTecnicoespecialidad(@Validated @RequestBody Map<String, Object> body,
                                            @PathVariable("id") Integer id) {
        Tecnico tecnico = tecnicoService.findById(id).get();
        if (tecnico != null) {
            String idEspecialidad = String.valueOf(body.get("idEspecialidad"));
            Especialidad especialidad = especialidadService.findById(Integer.valueOf(idEspecialidad)).get();
            tecnico = tecnicoService.addEspecialidad(tecnico, especialidad);
            if (tecnico != null)
                return "OK - Especialidad " + idEspecialidad + " se agregado al tecnico " + id;
        }

        return "Fallo - No se agrego la especialidad al tecnico " + id;

    }

    @PutMapping("/tecnicoIncidencia/{id}")
    public String updateTecnicoIncidencia(@Validated @RequestBody Map<String, Object> body,
                                          @PathVariable("id") Integer id) {
        Tecnico tecnico = tecnicoService.findById(id).get();
        if (tecnico != null) {
            String idIncidencia = String.valueOf(body.get("idIncidencia"));
            Incidencia incidencia = incidenciaService.findById(Integer.valueOf(idIncidencia)).get();
            tecnico = tecnicoService.addIncidencia(tecnico, incidencia);
            if (tecnico != null)
                return "OK - Incidencia " + idIncidencia + " es agregado al tecnico " + id;
        }

        return "Fallo - No se agrego la incidencia al tecnico " + id;

    }

    @GetMapping("/tecnicoConMasIncidentesResueltosNdias/{id}")
    public Tecnico getTecnicoConMasIncidentesResueltos(@Validated @RequestBody Map<String, Object> body,
                                                       @PathVariable("id") Integer id) {

        List<Tecnico> lista=tecnicoService.findTecnicosConMasIncidentesResueltosEnNDias(id);
        if(lista.size() !=0)
          return lista.get(0);// el primer elemento de la lista es el que mas cantidad tiene
        return null;

    }

    @GetMapping("/tecnicoConMasIncidentesResueltosNdiasEspecialidad/{id}")
    public Tecnico getTecnicoConMasIncidentesResueltosEspecialidad(@Validated @RequestBody Map<String, Object> body,
                                                       @PathVariable("id") Integer id) {


        Integer idEsp = Integer.valueOf(String.valueOf(body.get("idEspecialidad")));

        List<Tecnico> lista=tecnicoService.findTecnicosConMasIncidentesResueltosEnNDiasEspecialidad(id,idEsp);
        if(lista.size() !=0)
            return lista.get(0);// el primer elemento de la lista es el que mas cantidad tiene
        return null;

    }

    //Update campos de tecnico
    @PutMapping("/tecnico/{id}")
    public TecnicoDto updateTecnico(@Validated @RequestBody Map<String, Object> body,
                                    @PathVariable("id") Integer id) {

        Tecnico tecnicoUpdate = tecnicoService.findById(id).get();
        String nombre = String.valueOf(body.get("nombre"));
        String mail = String.valueOf(body.get("mail"));
        String numTelefono = String.valueOf(body.get("numTelefono"));
        if(! nombre.isEmpty())
            tecnicoUpdate.setNombre(nombre);
        if (! mail.isEmpty())
            tecnicoUpdate.setMail(mail);
        if (! numTelefono.isEmpty())
            tecnicoUpdate.setNroTel(numTelefono);
       tecnicoUpdate= tecnicoService.update(tecnicoUpdate);

       return TecnicoDto.builder().nombre(tecnicoUpdate.getNombre())
                .mail(tecnicoUpdate.getMail())
               .nroTel(tecnicoUpdate.getNroTel()).build();


    }
   // Listar
   @GetMapping("/tecnicos")
   public List<TecnicoDto> getAllTecnicos() {
       List<Tecnico> tecnicoList = tecnicoService.findAll();

       return tecnicoList.stream()
               .map(t -> TecnicoDto.builder()
                       .nombre(t.getNombre())
                       .mail(t.getMail())
                       .nroTel(t.getNroTel())
                       .build())
               .collect(Collectors.toList());
   }


   // Delete
   @DeleteMapping("/tecnico/{id}")
   public String deleteTecnicoById(@PathVariable("id") Integer id){
       tecnicoService.deleteById(id);
       return "Tecnico Eliminado correctamente";
   }

   }

