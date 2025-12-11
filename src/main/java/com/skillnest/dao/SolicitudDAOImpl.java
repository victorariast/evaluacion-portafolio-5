package com.skillnest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.skillnest.modelo.Solicitud;

public class SolicitudDAOImpl implements SolicitudDAO{
	private Connection conn;

    public SolicitudDAOImpl() {
        conn = ConexionDB.getInstancia().getConexion();
    }

	@Override
	public void create(Solicitud solicitud) {
		try {
            String sql = "INSERT INTO solicitud (nombre, correo, id_libro) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, solicitud.getNombre());
            ps.setString(2, solicitud.getCorreo());
            ps.setInt(3, solicitud.getId_libro());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<Solicitud> readAll() {
		List<Solicitud> lista = new ArrayList<>();
        try {
            String sql = "SELECT id, nombre, correo, id_libro FROM solicitud";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Solicitud solicitud = new Solicitud(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getInt("id_libro")
                );
                lista.add(solicitud);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
	}

}
