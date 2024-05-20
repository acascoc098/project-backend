**Autora:** Andrea Castilla Cocera

**Grado:** Desarrollo de Aplicaciones Multiplataforma

**Curso:** 2023/24

**Centro:** IES Virgen del Carmen

#### Para acceder a spring en web

- user = user
- passxowd = *Using generated security password: ...*

### Repositorio del backend

[Backend proyecto final](https://github.com/acascoc098/project-backend.git)

# INTRODUCCIÓN

En esta parte tenemos la parte del backende del proyecto final, creado con Spring junto a un contenedor en Docker creado con MySql.

## MODELOS

En esta parte creamos los modelos que luego serán tablas en la base de datos, esto lo indicamos con:

- @Entity
- @Data

Y en cada modelos tenemos sus campos, por ejemplo en usuario:

``` java
@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String nombre;

    @Column(length = 75, nullable = false)
    private String password;

    @Column(unique = true, length = 70, nullable = false)
    private String correo;

    @Column(length = 9, nullable = false)
    private String telefono;
  
}
```

Y vemos lo siguiente:

- @Id -> Indicamos que este atributo será el id y le aplicamos la opción de autoincrementar gracias a `@GeneratedValue(strategy = GenerationType.IDENTITY)`
- @Column -> Indica que este atributo es una columna en la tabla

También vamos como se hacen las relaciones, por ejemplo en el modelo de reserva tenemos:

```java
    @ManyToOne
    private Usuario usuario;

    @OneToOne
    private Bar bar;
```

Donde:

- @ManyToOne -> Define una relcación de reserva con usuario de 1:M
- @OneToOne -> Define una relación de rserva con bar de 1:1

Además podemos dotarle a las comulnas de valor máximo, si puede ser null,...

```java
    @Column(unique = true, length = 70, nullable = false)
    private String correo;
```

## REPOSITORIOS

Estas interfaces nos ayudarán con las consultas a la base de datos de manera automática para las peticiones HTTP, veamos como sería el repostorío de un bar:

```java
@Repository
public interface BarRepo extends JpaRepository<Bar, Long>{
}
```

Gracias a esto podemos pasar al siguiente apartado de controladores, dodne manejamos las peticiones HTTP gracias al repositorio.

## CONTROLADORES O SERVICIOS

En estas clases manejamos las peticiones HTTP a través del repositorio de cada modelo, para el modelo de los bares tenemos el siguiente controlador:

```java
@RestController
@RequestMapping("/barteca")
public class BarController {
    @Autowired
    BarRepo repositorioBar;

    @GetMapping("bar")
    List<Bar> findAll(){
        return repositorioBar.findAll();
    }
    
    @GetMapping("bar/{id}")
    Bar findById(@PathVariable(value = "id") Long id){//Con esto le indicamos el parámetro necesario para la consulta
        return repositorioBar.findById(id).get();
    }

    @PostMapping("bar")
    Bar create(@RequestBody Bar barBody) {
        return repositorioBar.save(barBody);
    }

    @DeleteMapping("bar/{id}")
    void delete(@PathVariable(value = "id") Long id) {
        repositorioBar.deleteById(id);
    }

    @PutMapping("bar/{id}")
    Bar update(@PathVariable(value = "id") Long id, @RequestBody Bar nBar) {
        Bar barModify = findById(id);

        if (barModify != null) {
            barModify.setNombre(nBar.getNombre());
            barModify.setProvincia(nBar.getProvincia());
            barModify.setCalificacion(nBar.getCalificacion());
            barModify.setCiudad(nBar.getCiudad());
            barModify.setDireccion(nBar.getDireccion());
            barModify.setTelefono(nBar.getTelefono());
            barModify.setCorreo(nBar.getCorreo());

            return repositorioBar.save(barModify);
        } else {
            return barModify;
        }
    }
}
```

Donde vemos peticiones de GET, PUT, POST y DELETE, con la ruta de cada una indicando que tipo es:

- @GetMapping -> Peticiones GET
- @PostMapping -> Peticiones POST
- @PutMapping -> Peticiones PUT
- @DeleteMApping -> Peticiones DELETE

Además, a la clase le indicamos que es un controlador y la primera parte de la petición con:

- @RestController
- @RequestMapping("/barteca")

Estas peticiones se trabajan con los componentes de nuestro frontend.

## Lista de rutas

Para completar la aplicación, se definen una serie de end-points que serán completados en sucesivos sprints (un sprint en la metodología SCRUM de trabajo es una tarea que al completarla obtenemos un subproducto funcional).

RUTA | VERBO | DATOS | COMENTARIOS
-----|-------|-------|------------
/usuario | GET | - | Devuelve los usuarios
/usuario/x | GET | Parámetro x: ID de usuario | Devuelve el usuario con ID x
/usuario/correo/{correo} | GET | Parámetro correo: correo de usuario | Devuelve el usuario con ese correo
/usuario | POST | - | Añade el usuario
/usuario/x | DELETE | Parámetro x: ID de usuario | Elimina el usuario con ID x
/usuario/x | PUT | Parámetro x: ID de usuario | Modifica el usuario con ID x
/bar | GET | - | Devuelve los bares
/bar/x | GET | Parámetro x: ID de bar | Devuelve el bar con ID x
/bar | POST | - | Añade el bar
/bar/x | DELETE | Parámetro x: ID de bar| Elimina el bar con ID x
/bar/x | PUT | Parámetro x: ID de bar | Modifica el bar con ID x
/reserva | GET | - | Devuelve las reservas
/reserva/x | GET | Parámetro x: ID de reserva | Devuelve el reserva con ID x
/reserva | POST | - | Añade el reserva
/reserva/x | DELETE | Parámetro x: ID de reserva| Elimina el reserva con ID x
/reserva/x | PUT | Parámetro x: ID de reserva | Modifica el reserva con ID x
