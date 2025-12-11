package com.skillnest.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.skillnest.dao.LibroDAOImpl;
import com.skillnest.modelo.Libro;


/**
 * Servlet implementation class CatalogoServlet
 */
@WebServlet("/catalogo")
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroDAOImpl dao = new LibroDAOImpl();
        List<Libro> lista = dao.readAll();

        // Pasamos la lista como atributo a la JSP
        request.setAttribute("libros", lista);
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
