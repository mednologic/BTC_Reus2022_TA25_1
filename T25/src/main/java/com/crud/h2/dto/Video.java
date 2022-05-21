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
