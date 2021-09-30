package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				
		if (request.getParameter("enviar") != null) {
			String usuario, password;
			usuario = request.getParameter("usuario");
			password = request.getParameter("clave");

			if (usuario.equals("admininicial") && password.equals("admin123456")) {				
				response.sendRedirect("adminMenu.jsp");
			} else {				
				response.sendRedirect("login.jsp?men=Datos Incorrectos");
			}

		}
	}
}