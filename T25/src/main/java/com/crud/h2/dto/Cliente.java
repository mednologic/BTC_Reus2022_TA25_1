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
