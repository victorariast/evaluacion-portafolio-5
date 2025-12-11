package com.skillnest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.skillnest.modelo.Libro;

public class LibroDAOImpl implements LibroDAO {
	private Connection conn;

    public LibroDAOImpl() {
        conn = ConexionDB.getInstancia().getConexion();
    }
    
	@Override
	public List<Libro> readAll() {
		List<Libro> lista = new ArrayList<>();
        try {
            String sql = "SELECT id, nombre, autor, disponible FROM libro";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("autor"),
                    rs.getBoolean("disponible")
                );
                lista.add(libro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
	}

	@Override
	public Libro readById(int id) {
		Libro libro = null;
        try{
            String sql = "SELECT id, nombre, autor, disponible FROM libro WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	libro = new Libro(
            		rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("autor"),
                    rs.getBoolean("disponible")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libro;
	}

}
