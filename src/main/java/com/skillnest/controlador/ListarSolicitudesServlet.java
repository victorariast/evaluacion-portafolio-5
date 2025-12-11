package com.skillnest.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.skillnest.dao.SolicitudDAOImpl;
import com.skillnest.modelo.Solicitud;

/**
 * Servlet implementation class ListarSolicitudesServlet
 */
@WebServlet("/listarSolicitudes")
public class ListarSolicitudesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SolicitudDAOImpl dao = new SolicitudDAOImpl();
        List<Solicitud> lista = dao.readAll();

        // Pasamos la lista como atributo a la JSP
        request.setAttribute("solicitudes", lista);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
