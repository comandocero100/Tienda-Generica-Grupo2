package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelo.dao;
import Modelo.dto;

@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public Usuarios() {
        super();        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dao usu = new dao();

		if (request.getParameter("insertar") != null) {			
			int cedula;
			String email, nombre, clave, usuario;			

			cedula = Integer.parseInt(request.getParameter("cedula"));			
			email = request.getParameter("email");			
			nombre = request.getParameter("nombre");
			clave = request.getParameter("clave");
			usuario = request.getParameter("usuario");			

			dto usuDTO = new dto(cedula, email, nombre, clave, usuario);

			if (usu.insertar_Usuario(usuDTO)) {
				response.sendRedirect("Usuarios.jsp?men=Se Registro el Usuario exitosamente!!!");
			} else {
				response.sendRedirect("Usuarios.jsp?men=No se Registro el Usuario...");
			}
		}
		
		if (request.getParameter("consultar") != null) {			
			long cedula = Integer.parseInt(request.getParameter("cedula"));						
			dto usua = usu.buscar_Usuario(cedula);
			
			if (usua != null) {				
				String email, nombre, clave, usuario;				
				cedula = usua.getCedula();				
				email = usua.getEmail();
				nombre = usua.getNombre();
				clave = usua.getClave();
				usuario = usua.getUsuario();

				response.sendRedirect("Usuarios.jsp?cedula=" + cedula + "&&email=" + email + "&&nombre=" + nombre
						+ "&&clave=" + clave + "&&usuario=" + usuario);
			} else {				
				response.sendRedirect("Usuarios.jsp?men=El usuario no existe!!!");				
			}						
		}
		
		if (request.getParameter("actualizar") != null) {				
			String email, nombre, clave, usuario;
			int cedula;

			cedula = Integer.parseInt(request.getParameter("cedula"));				
			email = request.getParameter("email");
			nombre = request.getParameter("nombre");
			clave = request.getParameter("clave");
			usuario = request.getParameter("usuario");

			dto usua = new dto(cedula, email, nombre, clave, usuario);

			if (usu.actualizar_Usuario(usua)) {				
				response.sendRedirect("Usuarios.jsp?men=Se Actualizo el Usuario exitosamente!!!");
			} else {
				response.sendRedirect("Usuarios.jsp?men=El Usuario no existe!!!");
			}
		}

		if (request.getParameter("eliminar") != null) {
			int cedula;
			cedula = Integer.parseInt(request.getParameter("cedula"));			
			
			if (usu.eliminar_Usuario(cedula)) {
				response.sendRedirect("Usuarios.jsp?men=Usuario Eliminado");
			} else {
				response.sendRedirect("Usuarios.jsp?men=El Usuario no existe!!!");
			}			
		}		
		
		if(request.getParameter("limpiar") !=null) {
			String cedula, email, nombre, clave, usuario, estado;			
			
			cedula = "";
			email = "";
			nombre = "";
			clave = "";
			usuario = "";				
			estado = "enabled";
									
			response.sendRedirect("Usuarios.jsp?cedula=" + cedula + "&&email=" + email + "&&nombre=" + nombre
					+ "&&clave=" + clave + "&&usuario=" + usuario + "&&estado=" + estado);
		}
	}	
}