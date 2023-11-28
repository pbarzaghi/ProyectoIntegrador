package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.TecnicoDto;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController

public class ConsultaRestController {
    @Autowired
    TecnicoService tecnicoService;

    @GetMapping("/tecnicoConMasIncidentesResueltosNdias/{id}")
    public TecnicoDto getTecnicoConMasIncidentesResueltos(@Validated @RequestBody Map<String, Object> body,
                                                       @PathVariable("id") Integer id) {

        List<Tecnico> lista=tecnicoService.findTecnicosConMasIncidentesResueltosEnNDias(id);
        if(lista.size() !=0){
            Tecnico mostrar=lista.get(0);
            return TecnicoDto.builder()
                    .nombre(mostrar.getNombre())
                    .nroTel(mostrar.getNroTel())
                    .mail(mostrar.getMail()).build();

        }

        return TecnicoDto.builder().nombre("CONSULTA SIN RESULTADO").build();

    }

    @GetMapping("/tecnicoConMasIncidentesResueltosNdiasEspecialidad/{id}")
    public TecnicoDto getTecnicoConMasIncidentesResueltosEspecialidad(@Validated @RequestBody Map<String, Object> body,
                                                                   @PathVariable("id") Integer id) {


        Integer idEsp = Integer.valueOf(String.valueOf(body.get("idEspecialidad")));

        List<Tecnico> lista=tecnicoService.findTecnicosConMasIncidentesResueltosEnNDiasEspecialidad(id,idEsp);

        if(lista.size() !=0){
            Tecnico mostrar=lista.get(0);
            return TecnicoDto.builder()
                    .nombre(mostrar.getNombre())
                    .nroTel(mostrar.getNroTel())
                    .mail(mostrar.getMail()).build();

        }

        return TecnicoDto.builder().nombre("CONSULTA SIN RESULTADO").build();


    }

    @GetMapping("/tecnicoRapidoResolverIncidencia")
    public TecnicoDto  getTecnicoMasRapidoResolucionIncidencia(){

        List<Tecnico > lista=tecnicoService.findTecnicoMasRapidoResolvioLaIncidencia();
        if(lista.size() !=0){
            Tecnico mostrar=lista.get(0);
            return TecnicoDto.builder()
                    .nombre(mostrar.getNombre())
                    .nroTel(mostrar.getNroTel())
                    .mail(mostrar.getMail()).build();

        }

        return TecnicoDto.builder().nombre("CONSULTA SIN RESULTADO").build();

    }

}
