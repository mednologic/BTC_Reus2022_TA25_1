<table>
 <tr>
    <td width="100px"><img src="https://github.com/OctavioBernalGH/BTC_Reus2022_UD16/blob/main/dou_logo.png" alt="Team DOU"/></td>
  <td width="1000px"> <h2> Spring + JPA + H2 + Maven Ejercicio 4 Unidad 25 </h2> </td>
  
 </tr>
</table>

[![Java](https://img.shields.io/badge/Java-FrontEnd-informational)]()
[![JBuilder](https://img.shields.io/badge/JBuilder-View-critical)]()
[![JUnit 5](https://img.shields.io/badge/JUnit%205-Testing-success)]()
[![GitHub](https://img.shields.io/badge/GitHub-Repository-lightgrey)]()
[![SQL](https://img.shields.io/badge/SQL-DataBase-yellowgreen)]()
[![Spring](https://img.shields.io/badge/Spring-infrastructure-brightgreen)]()
[![Maven](https://img.shields.io/badge/Maven-ProjectStructure-blueviolet)]()

Este ejercicio ha sido realizado por los miembros del equipo 1. Dicho equipo esta formado por:

  [- Ixabel Justo Etxeberria](https://github.com/Kay-Nicte)<br>
  [- J.Oriol López Bosch](https://github.com/mednologic)<br>
  [- Octavio Bernal](https://github.com/OctavioBernalGH)<br>
  [- David Dalmau](https://github.com/DavidDalmauDieguez)

<p align="justify">Se crea un proyecto Maven utilizando la tecnología spring, se definen como componentes los spring services, la base de datos H2 y JPA. Se crea la estructura de proyecto en capas definiendo los paquetes de controllers, dao, dto y services. Para proseguir se crean las entidades 'clientes' y 'videos' con una relación de uno a muchos (one to many). Se definen las columnas y mediante anotaciones se mapea con los atributos de la entidad.</p>

<p align="justify">Antes de proceder con la creación de paquetes y estructuras se definirán los parámetros de acceso a la base de datos H2, para ello se añaden las siguiente línas en el fichero 'application.propierties' ubicado en 'src/main/resources/.</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/103035621/169650442-7c57e6ec-69cd-42de-a819-2d1a3c47fee4.png">
</p>

<p align="justify">A vez este definido el application.propierties se procederá a la creación de la estructura de proyecto, en este caso queda tal que así:</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/103035621/169661811-94ba4262-022f-4c46-9b6b-fa6a76e69258.png">
</p>

Lo primero que hay que hacer a la hora de programar un MVC es comenzar por la capa DTO, en esta capa van las entidades (clase que representan tablas), donde se mapearán las columnas a los atributos java, de esta forma se podrán realizar las acciones CRUD utilizando atributos en java. Primero de todo se crea la clase Cliente.Java en el paquete DTO:

```java
package com.crud.h2.dto;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente") // en caso que la tabla sea diferente
public class Cliente {

	// Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "nombre") // no hace falta si se llama igual
	private String nombre;
	@Column(name = "apellido") // no hace falta si se llama igual
	private String apellido;
	@Column(name = "direccion") // no hace falta si se llama igual
	private String direccion;
	@Column(name = "dni") // no hace falta si se llama igual
	private int dni;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Video> video;

	// Constructores

	public Cliente() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param dni
	 * @param fecha
	 */
	public Cliente(Long id, String nombre, String apellido, String direccion, int dni, Date fecha) {
		// super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.fecha = fecha;
	}

	// Getters y Setters

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Video")
	public List<Video> getVideo() {
		return video;
	}

	/**
	 * @param video the video to set
	 */
	public void setVideo(List<Video> video) {
		this.video = video;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", dni=" + dni + ", fecha=" + fecha + "]";
	}

}

```

Remarcar que en este ejercicio hay una relación "One to Many" donde un cliente tiene muchos videos. Por lo tanto cliente está en el lado de uno, para mostrar está relación se utilizará la anotación @OneToMany en "Cliente.Java". A parte de esta anotación se utilizarán las anotaciones @Entity para definir esta clase como entidad y @Table(name = "nombre tabla") para definir el nombre de la tabla referenciada. Existe también la anotación @Column para referenciar el atributo de la clase Java a una columna de la tabla.

```java
package com.crud.h2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videos") // en caso que la tabla sea diferente

public class Video {

	// Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "title") // no hace falta si se llama igual
	private String title;
	@Column(name = "director") // no hace falta si se llama igual
	private String director;

	@ManyToOne
	@JoinColumn(name = "cli_id")
	private Cliente cliente;

	// Constructores
	/**
	 * 
	 */
	public Video() {

	}

	/**
	 * @param id
	 * @param title
	 * @param director
	 * @param cliente
	 */
	public Video(Long id, String title, String director, Cliente cliente) {
		// super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.cliente = cliente;
	}

	// getter y setter
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// metodo toString
	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", director=" + director + ", cliente=" + cliente + "]";
	}

}

```

En el fragmento de código anterior se realizará el mismo procedimiento que en la clase 'Cliente'. La diferencia principal es que como la clase 'Video' está en el lado de muchos esta contendrá la anotación @ManyToOne.

A continuación se crearán las interfaces que forman la capa DAO. En el código siguiente vienen definidas las dos interfaces (están separadas en ficheros diferentes).

```java
package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Cliente;

public interface IClienteDAO extends JpaRepository<Cliente, Long> {

}

package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Video;

public interface IVideoDAO extends JpaRepository<Video, Long>{

}

```

El siguiente paso será definir la capa service, esta capa estará formada por interfaces y clases, en el caso de este ejercicio al tener 2 entidades se deberán crear dos interfaces y dos clases que las implementarán. En el siguiente código se observarán las interfaces:

```java
package com.crud.h2.service;

import java.util.List;
import com.crud.h2.dto.Cliente;

public interface IClienteService {

	public List<Cliente> listarClientes(); // Listar All

	public Cliente guardarCliente(Cliente cliente); // Guarda un cliente CREATE

	public Cliente clienteXID(Long id); // Leer datos de un cliente READ

	public Cliente actualizarCliente(Cliente cliente); // Actualiza datos del cliente UPDATE

	public void eliminarCliente(Long id);// Elimina el cliente DELETE

}

package com.crud.h2.service;

import java.util.List;
import com.crud.h2.dto.Video;

public interface IVideoService {

	public List<Video> listarVideos(); // Listar All

	public Video guardarVideo(Video video); // Guarda un video CREATE

	public Video videoXID(Long id); // Leer datos de un video READ

	public Video actualizarVideo(Video video); // Actualiza datos del video UPDATE

	public void eliminarVideo(Long id);// Elimina el video DELETE
}

```

Una vez estén definidas ambas interfaces, se implementarán en las clases 'ClienteServiceImpl' y 'VideoServiceImpl':

```java
package com.crud.h2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.h2.dao.IClienteDAO;
import com.crud.h2.dto.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	// Utilizamos los metodos de la interface IClienteDAO, es como si instaciaramos.
	@Autowired
	IClienteDAO iClienteDAO;

	@Override
	public List<Cliente> listarClientes() {

		return iClienteDAO.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {

		return iClienteDAO.save(cliente);
	}

	@Override
	public Cliente clienteXID(Long id) {

		return iClienteDAO.findById(id).get();
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {

		return iClienteDAO.save(cliente);
	}

	@Override
	public void eliminarCliente(Long id) {

		iClienteDAO.deleteById(id);

	}

}

```

A continuación se muestra el código generado para la clase 'VideoServiceImpl':

```java
package com.crud.h2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.h2.dao.IVideoDAO;
import com.crud.h2.dto.Video;

@Service
public class VideoServiceImpl implements IVideoService {

	@Autowired
	IVideoDAO iVideoDAO;

	@Override
	public List<Video> listarVideos() {

		return iVideoDAO.findAll();
	}

	@Override
	public Video guardarVideo(Video video) {

		return iVideoDAO.save(video);
	}

	@Override
	public Video videoXID(Long id) {

		return iVideoDAO.findById(id).get();
	}

	@Override
	public Video actualizarVideo(Video video) {

		return iVideoDAO.save(video);
	}

	@Override
	public void eliminarVideo(Long id) {

		iVideoDAO.deleteById(id);

	}
}

```

Muy importante el uso de anotaciones, en ambas clases se utiliza la anotacion @Service para definir esta clase como servicio del aplicativo y la anotación @Autowired para acceder a los métodos del DAO, los métodos del DAO son heredados de la clase JpaRepository.

A continuación se proseguirá con la creación de los controladores, tiene que haber tantos controladores como entidades, en los controladores se definirá el comportamiento y enrutado del aplicativo mediante el uso de anotaciones. La primera anotación destacada en el controlador es @RestController marca la clase como un controlador donde cada método devuelve un objeto de dominio en lugar de una vista. La siguiente anotación a utilizar es la de @RequestMapping("/ruta aplicativo") para definir la ruta del aplicativo.

A continuación es muestra el código generador para la clase ClienteController:

```java
package com.crud.h2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.h2.dto.Cliente;
import com.crud.h2.service.ClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	ClienteServiceImpl clienteServideImpl;

	@GetMapping("/clientes")
	public List<Cliente> listarClientes() {
		return clienteServideImpl.listarClientes();
	}

	@PostMapping("/clientes")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {

		return clienteServideImpl.guardarCliente(cliente);
	}

	@GetMapping("/clientes/{id}")
	public Cliente clienteXID(@PathVariable(name = "id") Long id) {

		Cliente cliente_xid = new Cliente();

		cliente_xid = clienteServideImpl.clienteXID(id);

		System.out.println("Cliente XID: " + cliente_xid);

		return cliente_xid;
	}

	@PutMapping("/clientes/{id}")
	public Cliente actualizarCliente(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {

		Cliente cliente_seleccionado = new Cliente();
		Cliente cliente_actualizado = new Cliente();

		cliente_seleccionado = clienteServideImpl.clienteXID(id);

		cliente_seleccionado.setNombre(cliente.getNombre());
		cliente_seleccionado.setApellido(cliente.getApellido());
		cliente_seleccionado.setDireccion(cliente.getDireccion());
		cliente_seleccionado.setDni(cliente.getDni());
		cliente_seleccionado.setFecha(cliente.getFecha());

		cliente_actualizado = clienteServideImpl.actualizarCliente(cliente_seleccionado);

		System.out.println("El cliente actualizado es: " + cliente_actualizado);

		return cliente_actualizado;
	}

	@DeleteMapping("/clientes/{id}")
	public void eleiminarCliente(@PathVariable(name = "id") Long id) {
		clienteServideImpl.eliminarCliente(id);
	}

}

```

En en el siguiente fragmento de código se muestra el otro controlador a utilizar llamado "VideoController.Java":

```java
package com.crud.h2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dto.Video;
import com.crud.h2.service.VideoServiceImpl;

@RestController
@RequestMapping("/api")
public class VideoController {

	@Autowired
	VideoServiceImpl videoServideImpl;

	@GetMapping("/videos")
	public List<Video> listarVideos() {
		return videoServideImpl.listarVideos();
	}

	@PostMapping("/videos")
	public Video salvarVideo(@RequestBody Video video) {

		return videoServideImpl.guardarVideo(video);
	}

	@GetMapping("/videos/{id}")
	public Video videoXID(@PathVariable(name = "id") Long id) {

		Video video_xid = new Video();

		video_xid = videoServideImpl.videoXID(id);

		System.out.println("Video XID: " + video_xid);

		return video_xid;
	}

	@PutMapping("/videos/{id}")
	public Video actualizarVideo(@PathVariable(name = "id") Long id, @RequestBody Video video) {

		Video video_seleccionado = new Video();
		Video video_actualizado = new Video();

		video_seleccionado = videoServideImpl.videoXID(id);

		video_seleccionado.setTitle(video.getTitle());
		video_seleccionado.setDirector(video.getDirector());
		video_seleccionado.setCliente(video.getCliente());

		video_actualizado = videoServideImpl.actualizarVideo(video_seleccionado);

		System.out.println("El video actualizado es: " + video_actualizado);

		return video_actualizado;
	}

	@DeleteMapping("/videos/{id}")
	public void eliminarVideo(@PathVariable(name = "id") Long id) {
		videoServideImpl.eliminarVideo(id);
	}

}

```

En ambos controladores se utilizan las anotaciones que hacen referencia al tipo de método HTTP utilizado y la ruta de acceso al aplicativo. Cada método + ruta tendrá una funcionalidad asociada como por ejemplo el @GetMapping("/videos"), esta ruta con este método GET indica que obtendrá 'x' valores de video. Para finalizar el tema de Spring del aplicativo se deberá generar un fichero 'data.sql' con la estructura de tablas y columnas utilizadas para el ejercicio.

El código generado para la creación de tablas y los inserts para verificar el funcionamiento del aplicativo es el siguiente:

```sql
DROP TABLE IF EXISTS `videos`;
DROP table IF EXISTS `cliente`;

CREATE TABLE `cliente` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(250) DEFAULT NULL,
    `apellido` VARCHAR(250) DEFAULT NULL,
    `direccion` VARCHAR(250) DEFAULT NULL,
    `dni` INT(11) DEFAULT NULL,
    `fecha` DATE DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `videos` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(250) DEFAULT NULL,
    `director` VARCHAR(250) DEFAULT NULL,
    `cli_id` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `videos_fk` FOREIGN KEY (`cli_id`)
        REFERENCES `cliente` (`id`)
);

insert into `cliente` (`nombre`, `apellido`,`direccion`,`dni`,`fecha`)values('Jose','Marin','calle imaginaria 1',123456789, NOW());
insert into `cliente` (`nombre`, `apellido`,`direccion`,`dni`,`fecha`)values('Juan','Lopez','calle imaginaria 2',122222222, NOW());
insert into `cliente` (`nombre`, `apellido`,`direccion`,`dni`,`fecha`)values('Pedro','Guillem','calle imaginaria 3',123333333, NOW());
insert into `cliente` (`nombre`, `apellido`,`direccion`,`dni`,`fecha`)values('Jordi','Martin','calle imaginaria 4',123444444, NOW());
insert into `cliente` (`nombre`, `apellido`,`direccion`,`dni`,`fecha`)values('Jonatan','Vicente','calle imaginaria 5',123455555, NOW());

insert into `videos` (`title`, `director`,`cli_id`) values ('Titulo 01','Director 01',1);
insert into `videos` (`title`, `director`,`cli_id`) values ('Titulo 02','Director 02',1);
insert into `videos` (`title`, `director`,`cli_id`) values ('Titulo 03','Director 03',2);
insert into `videos` (`title`, `director`,`cli_id`) values ('Titulo 04','Director 04',2);
```

Para verificar el correcto funcionamiento del aplicativo spring se utilizará la herramienta postman, con esta herramienta verificaremos todos y cada uno de los endpoints, a continuación se muestran varias capturas:

<p align="center">
   <img src="https://user-images.githubusercontent.com/103035621/169662694-913acaef-6cd9-4fa4-86f9-871c94f4d0e3.PNG"> 
</p>

En la captura anterior se muestra que mediante el método get y la dirección a la api referente al listar mostrará todos los clientes.

<p align="center">
   <img src="https://user-images.githubusercontent.com/103035621/169662705-6ac22689-08fd-49c9-9f54-cc827043c3e9.PNG"> 
</p>

En la imagen anterior se podrá comprobar el mismo funcionamiento, mediante get y la ruta a la api se obtendrá un listado de videos. En la siguiente imagen se puede observar que mediante el método HTTP Get y un identificador de cliente, postman devolverá un único cliente filtrado por el ID:

<p align="center">
   <img src="https://user-images.githubusercontent.com/103035621/169662745-ab56d7c9-84fc-4367-b8e7-92324c1d0cbc.PNG"> 
</p>

Se realiza el mismo proceso pero con videos:

<p align="center">
   <img src="https://user-images.githubusercontent.com/103035621/169662774-a46c81f1-d51d-4eb7-b013-d6fd01a5e323.PNG"> 
</p>

A continuación se creará un video con un cliente asociado para comprobar la correcta integridad referencial entre tablas:

<p align="center">
   <img src="https://user-images.githubusercontent.com/103035621/169662803-41eb7e2a-fd9c-48bf-8ade-7894b7511207.PNG"> 
</p>

Se prosigue verificando el método DELETE en el cual se eliminará un registro con integridad referencial entre ambas tablas, no se mostrará ningún mensaje puesto que la función es del tipo void (el contenido del body es de otra de las funcionalidades).

<p align="center">
   <img src="https://user-images.githubusercontent.com/103035621/169662871-7ed4fbdb-e898-4ce2-a4a7-e39211817662.PNG"> 
</p>

Por último se modificará un registro con integridad referencial entre tablas, para ello se utiliza el método HTTP PUT introduciendo por ruta un identificador y introduciendo el nuevo valor del objeto en el body. Todo esto viene definido en la función del controlador donde en los parámetros que recibe se define que el identificador será enviado mediante ruta de la api y el contenido del objeto en el body.

<p align="center">
   <img src="https://user-images.githubusercontent.com/103035621/169662940-0124218e-655d-4b0d-ad1e-37d76c2cde9e.PNG"> 
</p>

Muy importante fijarse en las anotaciones utilizadas en el ejercicio así como generar comentarios de guía en las diferentes partes del código.
