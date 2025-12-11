package com.skillnest.dao;

import java.util.List;

import com.skillnest.modelo.Solicitud;

public interface SolicitudDAO {
	void create(Solicitud solicitud); 
	List<Solicitud> readAll();
}
