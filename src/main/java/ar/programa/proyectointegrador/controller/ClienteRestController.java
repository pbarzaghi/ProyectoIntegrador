package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.TecnicoDto;
import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.service.ClienteService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import ar.programa.proyectointegrador.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ClienteRestController {
    @Autowired
    ClienteService clienteService;
    @Autowired
    ServicioService servicioService;
   @Autowired
   IncidenciaService incidenciaService;

    @PostMapping("/cliente")
    public ClienteDto CreateCliente(@Validated @RequestBody Map<String, Object> body) {

        String razonSocial= String.valueOf(body.get("razonSocial"));
        String cuit=String.valueOf(body.get("cuit"));
        String mail=String.valueOf(body.get("mail"));

        Cliente clienteCreate=new Cliente();
        clienteCreate.setRazonSocial(razonSocial);
        clienteCreate.setCuit(cuit);
        clienteCreate.setMail(mail);
        clienteCreate=clienteService.save(clienteCreate);
        return ClienteDto.builder().razonSocial(clienteCreate.getRazonSocial())
                .cuit(clienteCreate.getCuit())
                .mail(clienteCreate.getMail()).build();
    }
    // Update
    @PutMapping("/clienteServicio/{id}")
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

    @PutMapping("/clienteIncidencia/{id}")
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

    @PutMapping("/cliente/{id}")
    public ClienteDto updateCliente(@Validated @RequestBody Map<String, Object> body,
                                    @PathVariable("id") Integer id) {

        Cliente clienteUpdate = clienteService.findById(id).get();
        String razonSocial= String.valueOf(body.get("razonSocial"));
        String cuit=String.valueOf(body.get("cuit"));
        String mail=String.valueOf(body.get("mail"));

        if( ! razonSocial.isEmpty() )
             clienteUpdate.setRazonSocial(razonSocial);
        if (! mail.isEmpty() )
            clienteUpdate.setMail(mail) ;
        if (! cuit.isEmpty())
             clienteUpdate.setCuit(cuit);



        clienteUpdate=clienteService.update(clienteUpdate);

        return ClienteDto.builder().razonSocial(clienteUpdate.getRazonSocial())
                .mail(clienteUpdate.getMail())
                .cuit(clienteUpdate.getCuit()).build();


    }

    @GetMapping("/clientes")
    public List<ClienteDto> getAllClientes() {
        List<Cliente> clienteList = clienteService.findAll();

        return clienteList.stream()
                .map(t -> ClienteDto.builder()
                        .razonSocial(t.getRazonSocial())
                        .cuit(t.getCuit())
                        .mail(t.getMail())
                        .build())
                .collect(Collectors.toList());
    }


    @DeleteMapping("/cliente/{id}")
    public String deleteClienteById(@PathVariable("id") Integer id){
        clienteService.deleteById(id);
        return "Cliente Eliminado correctamente";
    }

}
