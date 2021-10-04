package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelo.dao;
import Modelo.dto;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public Clientes() {
		super();
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao libdao = new dao();

		if (request.getParameter("insertar") != null) {
			String direccion, email, nombre, telefono;
			int cedula;
			cedula = Integer.parseInt(request.getParameter("cedula_cliente"));
			direccion = request.getParameter("cedula_cliente");
			email = request.getParameter("email_cliente");
			nombre = request.getParameter("nombre_cliente");
			telefono = request.getParameter("telefono_cliente");
			dto lib = new dto(cedula, direccion, email, nombre, telefono);
			if (libdao.insertar_Usuario(lib)) {

				//JOptionPane.showMessageDialog(null, "Se registro el cliente");
				response.sendRedirect("clientes.jsp?men=Se registro el cliente");
			} else {
				//JOptionPane.showMessageDialog(null, "no se registro el cliente...!!");
				response.sendRedirect("clientes.jsp?men=no se registro el cliente...!!");
			}
		}
	}

}
