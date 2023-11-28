package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.ServicioDto;
import ar.programa.proyectointegrador.dto.UsuarioDto;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.entity.TipoUsuario;
import ar.programa.proyectointegrador.entity.Usuario;
import ar.programa.proyectointegrador.service.TipoUsuarioService;
import ar.programa.proyectointegrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UsuarioRestController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    // Create
    @PostMapping("/Usuario")
    public UsuarioDto createUsuario(@Validated @RequestBody Map<String, Object> body) {


        //LECTURA DE DATOS:
        //Username
        String username = String.valueOf(body.get("username"));

        //password
        String password = String.valueOf(body.get("password"));

        String strTipoUsuario=String.valueOf(body.get("tipousuario_id"));
        System.out.println("Tipo de usuario es -->"+strTipoUsuario);
        // POr defecto vaa la mesa de ayuda
        Integer nroTipoUsurio=1;
        if("1".equals(strTipoUsuario)||"2".equals(strTipoUsuario)||"3".equals(strTipoUsuario)) {
            nroTipoUsurio=Integer.valueOf(strTipoUsuario);

        }
        //


        TipoUsuario tipoUsuario = tipoUsuarioService.findById(nroTipoUsurio).get();
        Usuario userCreate = new Usuario();
        userCreate.setNombreUsuario(username);
        userCreate.setPass(password);
        userCreate.setTipousuario_id(tipoUsuario);
        userCreate= usuarioService.save(userCreate);
        return UsuarioDto.builder()
                .nombreUsuario(userCreate.getNombreUsuario())
                .pass(userCreate.getPass())
                .tipousuario(userCreate.getTipousuario_id().getId())
                .build();

    }

    //Todo: Delete Listar Update
    @PutMapping("/usuario/{id}")
    public UsuarioDto updateUsuario(@Validated @RequestBody Map<String, Object> body,
                                     @PathVariable("id") Integer id) {

        Usuario usuarioUpdate = usuarioService.findById(id).get();
        String username = String.valueOf(body.get("username"));

        //password
        String password = String.valueOf(body.get("password"));


        if(! username.isEmpty())
            usuarioUpdate.setNombreUsuario(username);

        if(! password.isEmpty())
            usuarioUpdate.setPass(password);
        usuarioUpdate= usuarioService.update(usuarioUpdate);


        return UsuarioDto.builder()
                .nombreUsuario(usuarioUpdate.getNombreUsuario())
                .pass(usuarioUpdate.getPass())
                .tipousuario(usuarioUpdate.getTipousuario_id().getId())
                .build();



    }

    @GetMapping("/usuarios")
    public List<UsuarioDto> getAllUsuarios() {
        List<Usuario> usuarioList = usuarioService.findAll();

        return usuarioList.stream()
                .map(t -> UsuarioDto.builder()
                        .nombreUsuario(t.getNombreUsuario())
                        .pass(t.getPass())
                        .tipousuario(t.getTipousuario_id().getId())
                        .build())
                .collect(Collectors.toList());
    }


    @DeleteMapping("/usuario/{id}")
    public String deleteUsuarioById(@PathVariable("id") Integer id){
        usuarioService.deleteById(id);
        return "Usuario eliminado correctamente";
    }
}
