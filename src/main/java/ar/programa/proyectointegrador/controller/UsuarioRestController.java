package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.entity.TipoUsuario;
import ar.programa.proyectointegrador.entity.Usuario;
import ar.programa.proyectointegrador.service.TipoUsuarioService;
import ar.programa.proyectointegrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class UsuarioRestController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    // Create
    @PostMapping("/Usuario")
    public Usuario createUsuario(@Validated @RequestBody Map<String, Object> body) {


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
        Usuario user = new Usuario();
        user.setNombreUsuario(username);
        user.setPass(password);
        user.setTipousuario_id(tipoUsuario);
        return usuarioService.save(user);


    }
}
