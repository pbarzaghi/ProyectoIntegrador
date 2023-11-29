# TRABAJO PRACTICO INTEGRADOR 📘

#INTEGRANTE
Pablo Barzaghi
gitHub:  https://github.com/pbarzaghi/ProyectoIntegrador

## ENTREGA ETAPA 3
1-El proyecto cuenta con 7 Archivos RestController para poder distrubuir y encontrar facilmente la Api Rest la hora
  de realizar las consultas por PostMan

  - ConsultaRestController : Estan las 3 consultas solicitadas en el trabajo integrador.

  - TecnicoRestController : Crud de Tecnico
                            Tecnico asociar una Incidencia
                            Tecnico asociar una Especialidad

  - IncidenciaRestController : Crud de Incidencia
                               Incidencia asociar un DetalleIncidencia

 - ClienteRestController:  Crud de Cliente
                           Cliente asociar un Servicio
                           Cliente asociar una Incidencia

  - DetalleIncidenciaRestController: Crud de DetalleIncidencia

  - EspecialidadRestController: Crud de Especialidad

  - ServicioRestController: Crud de Servicio
                            Servicio asociar un DetalleIncidencia

  - TipoProblemaRestController: Crud de TipoProblema
                                TipoProblema asociar una Incidencia
                                TipoProblema asociar una Especialidad

  - UsuarioRestController: Crud de Usuario

  2) Se crearon  7 Dto con su Builder en su interior para que la respuesta no sea el Entity

     - ClienteDto
     - DetalleIncidenciaDto
     - EspecialidadDto
     - IncidenciaDto
     - ServicioDto
     - TecnicoDto
     - TipoProblemaDto
     - UsuarioDto

  3)  Service , Repository y Entity tienen los mismo nombre pero con sus terminacion correcpondiente
     Ejemplo:
              TecnicoService y TecnicoServiceImpl
              TecnicoRepository
              Tecnico

  4) Consideracion al momento de realizar la consulta:
         La primera consulta me costo mucho realizarla con QLPL asi que las demas las realice consulta
         sql nativo agregandole true a la condicion.


  5) En la carpeta src\main\resources se encuetra el der
        modeloDer.png

  6) Ejemplos de Crud, asociaciones y las consultas realizada con PostMan.
     En dichas carpeta se encuetran la imagenes como iba quedando la bd y el resultado de la operacion
     devolviendo un dto y visualidado con Json

         src\main\resources\ejemploCrud
                           Carpeta
                                   - cliente : Se escuentra la realizacion del Crud.
                                   - Incidencia: Se escuentra la realizacion del Crud
                                            -> dependencias: Las asociaciones con Tecnico,Cliente y TipoProblema
                                   - Tecnico: Se encuentra la realizacion del Crud
                                   - Consultas Pedidas: Son las 3 consultas pedidas en el proyecto y tambien deje la consulta
                                               del qry nativo utilizado.




Clonar el projecto
src\main\resources
```bash
  git clone https://github.com/pbarzaghi/ProyectoIntegrador
```

Instalar las dependencias del pom.xml

```maven
  mvn clean install
```

Ejecutar el servidor con maven

```bash
  mvn spring-boot:run
```


