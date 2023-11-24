package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.service.EspecialidadService;
import ar.programa.proyectointegrador.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TecnicoRestController {
    @Autowired
    TecnicoService tecnicoService;
    @Autowired
    EspecialidadService especialidadService;
    @PostMapping("/Tecnico")
    public Tecnico CreateTecnico(@Validated @RequestBody Map<String, Object> body) {

        String nombre= String.valueOf(body.get("nombre"));
        String mail=String.valueOf(body.get("mail"));
        String numTelefono=String.valueOf(body.get("numTelefono"));

        Tecnico tecnico=new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setMail(mail);
        tecnico.setNroTel(numTelefono);

        return tecnicoService.save(tecnico);
    }

    @PutMapping("/Tecnicoespecialidad/{id}")
    public String updateTecnicoespecialidad(@Validated @RequestBody Map<String,Object> body,
                                          @PathVariable("id") Integer id){
        Tecnico tecnico=tecnicoService.findById(id).get();
        if(tecnico != null){
            String idEspecialidad=String.valueOf(body.get("idEspecialidad"));
            Especialidad especialidad = especialidadService.findById(Integer.valueOf(idEspecialidad)).get();
           tecnico= tecnicoService.addEspecialidad(tecnico,especialidad);
            if(tecnico!=null)
                return "OK - Especialidad "+ idEspecialidad +" se agregado al tecnico "+id;
        }

        return "Fallo - No se agrego la especialidad al tecnico "+id;

    }
}
