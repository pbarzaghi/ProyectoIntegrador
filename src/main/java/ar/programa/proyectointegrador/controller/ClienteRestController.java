package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.service.ClienteService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import ar.programa.proyectointegrador.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class ClienteRestController {
    @Autowired
    ClienteService clienteService;
    @Autowired
    ServicioService servicioService;
   @Autowired
   IncidenciaService incidenciaService;

    @PostMapping("/Cliente")
    public Cliente CreateCliente(@Validated @RequestBody Map<String, Object> body) {

        String razonSocial= String.valueOf(body.get("razonSocial"));
        String cuit=String.valueOf(body.get("CUIT"));
        String mail=String.valueOf(body.get("mail"));

        Cliente cliente=new Cliente();
        cliente.setRazonSocial(razonSocial);
        cliente.setCuit(cuit);
        cliente.setMail(mail);

        return clienteService.save(cliente);
    }
    // Update
    @PutMapping("/Clienteservicio/{id}")
    public String updateClienteServicio(@Validated @RequestBody Map<String,Object> body,
                                         @PathVariable("id") Integer id){
        Cliente cliente=clienteService.findById(id).get();
        if(cliente != null){
            String idServicio=String.valueOf(body.get("idServicio"));
            Servicio servicio=  servicioService.findById(Integer.valueOf(idServicio)).get();
           cliente= clienteService.addServicio(cliente,servicio);
           if(cliente!=null)
           return "OK - Servicio "+ idServicio +"agregado al cliente "+id;
        }

        return "Fallo - No se agrego el servicio al cliente "+id;

    }

    @PutMapping("/Clienteincidencia/{id}")
    public String updateClienteIncidencia(@Validated @RequestBody Map<String,Object> body,
                                        @PathVariable("id") Integer id){
        Cliente cliente=clienteService.findById(id).get();
        if(cliente != null){
            String idIncidencia=String.valueOf(body.get("idIncidencia"));
            Incidencia incidencia=  incidenciaService.findById(Integer.valueOf(idIncidencia)).get();
            cliente= clienteService.addIncidencia(cliente,incidencia);
            if(cliente!=null)
                return "OK - Incidencia "+ idIncidencia +"agregado al cliente "+id;
        }

        return "Fallo - No se agrego la incidencia al cliente "+id;

    }


}
