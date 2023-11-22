package ar.programa.proyectointegrador;

import ar.programa.proyectointegrador.enumerado.TipoUsuarioEmun;
import ar.programa.proyectointegrador.entity.Usuario;
import ar.programa.proyectointegrador.service.UsuarioService;
import ar.programa.proyectointegrador.service.UsuarioServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 @author pabloBarzaghi
 */
@SpringBootApplication
public class ProyectoIntegradorApplication {


	public static void main(String[] args) {
	SpringApplication.run(ProyectoIntegradorApplication.class, args);



	}


}

