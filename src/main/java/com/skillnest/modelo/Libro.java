package com.skillnest.modelo;

public class Libro {
	private int id;
	private String nombre;
	private String autor;
	private boolean disponible;
	
	public Libro() {
	}

	public Libro(String nombre, String autor, boolean disponible) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.disponible = disponible;
	}

	public Libro(int id, String nombre, String autor, boolean disponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.disponible = disponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
