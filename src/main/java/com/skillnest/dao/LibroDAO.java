package com.skillnest.dao;

import java.util.List;

import com.skillnest.modelo.Libro;

public interface LibroDAO { 
	List<Libro> readAll();
	Libro readById(int id);
}
