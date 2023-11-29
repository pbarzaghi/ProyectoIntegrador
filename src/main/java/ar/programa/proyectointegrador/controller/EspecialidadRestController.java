package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.EspecialidadDto;
import ar.programa.proyectointegrador.dto.ServicioDto;
import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class EspecialidadRestController {

    @Autowired
    EspecialidadService especialidadService;

    @PostMapping("/especialidad")
    public Especialidad CreateEspecialidad(@Validated @RequestBody Map<String, Object> body) {

        String nombre= String.valueOf(body.get("nombre"));


        Especialidad especialidad=new Especialidad();

        especialidad.setNombre(nombre);

        return  especialidadService.save(especialidad);
    }


    @PutMapping("/especialidad/{id}")
    public EspecialidadDto  updateEspecialidad(@Validated @RequestBody Map<String, Object> body,
                                     @PathVariable("id") Integer id) {

        Especialidad especialidadUpdate = especialidadService.findById(id).get();
        String nombre= String.valueOf(body.get("nombre"));

        if(! nombre.isEmpty())
            especialidadUpdate.setNombre(nombre);

        especialidadUpdate= especialidadService.update(especialidadUpdate);

        return EspecialidadDto.builder().nombre(especialidadUpdate.getNombre()).build();



    }

    @GetMapping("/especialidades")
    public List<EspecialidadDto> getAllEspecialidades() {
        List<Especialidad> especialidadList = especialidadService.findAll();

        return especialidadList.stream()
                .map(t -> EspecialidadDto.builder()
                        .nombre(t.getNombre())
                        .build())
                .collect(Collectors.toList());
    }
    @DeleteMapping("/especialidad/{id}")
    public String deleteEspecialidadById(@PathVariable("id") Integer id){
        especialidadService.deleteById(id);
        return "Especialidad eliminado correctamente";
    }

}
