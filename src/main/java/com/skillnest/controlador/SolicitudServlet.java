package com.skillnest.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.skillnest.dao.LibroDAOImpl;
import com.skillnest.dao.SolicitudDAOImpl;
import com.skillnest.modelo.Libro;
import com.skillnest.modelo.Solicitud;

/**
 * Servlet implementation class SolicitudServlet
 */
@WebServlet("/solicitud")
public class SolicitudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		LibroDAOImpl dao = new LibroDAOImpl();
        Libro libro = dao.readById(id);

        HttpSession session = request.getSession(); //para que se mantenga en el flujo y se pueda usar desde solicitud y en confirmacion
        session.setAttribute("libro", libro);
        request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre").trim();
        String correo = request.getParameter("correo").trim();
        String id_libro = request.getParameter("id_libro");
        
        //Validación de que nombre contiene dos o más palabras
        if(nombre.split(" ").length < 2) {
        	request.setAttribute("error", "Por favor ingresa nombre y apellido");
            request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
            return;
        }
        
        // Crear el DTO
        Solicitud solicitud = new Solicitud(nombre, correo, Integer.parseInt(id_libro));

        // Llamar al DAO
        SolicitudDAOImpl dao = new SolicitudDAOImpl();
        dao.create(solicitud);
        
        HttpSession session = request.getSession();
        session.setAttribute("solicitud", solicitud); //para uso en confirmación
        
        // Redirigir o reenviar
        response.sendRedirect("confirmacion.jsp");
        
	}

}
