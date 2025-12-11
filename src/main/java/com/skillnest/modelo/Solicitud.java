package com.skillnest.modelo;

public class Solicitud {
	private int id;
	private String nombre;
	private String correo;
	private int id_libro;
	
	public Solicitud() {
	}

	public Solicitud(String nombre, String correo, int id_libro) {
		this.nombre = nombre;
		this.correo = correo;
		this.id_libro = id_libro;
	}

	public Solicitud(int id, String nombre, String correo, int id_libro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.id_libro = id_libro;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	
}
