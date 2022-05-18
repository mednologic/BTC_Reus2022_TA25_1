package com.crud.h2.dto;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "fabricante")
public class Fabricante {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Articulo> articulos;

	public Fabricante() {
		
	}

	public Fabricante(long id, String nombre, List<Articulo> articulos) {
		
		this.id = id;
		this.nombre = nombre;
		this.articulos = articulos;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	
	
	
}
