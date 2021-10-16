package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.clientesDao;
import Modelo.clientesDto;

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
		
		
		clientesDao libdao = new clientesDao();

		if (request.getParameter("insertar") != null) {
			String direccion, email, nombre, telefono;
			int cedula;
			cedula = Integer.parseInt(request.getParameter("cedula"));
			direccion = request.getParameter("direccion");
			email = request.getParameter("email");
			nombre = request.getParameter("nombre");
			telefono = request.getParameter("tel");
			clientesDto lib = new clientesDto(cedula, direccion, email, nombre, telefono);
			if (libdao.insertar_Cliente(lib)) {

				//JOptionPane.showMessageDialog(null, "Se registro el cliente");
				response.sendRedirect("clientes.jsp?men=Se registro el cliente");
			} else {
				//JOptionPane.showMessageDialog(null, "no se registro el cliente...!!");
				response.sendRedirect("clientes.jsp?men=no se registro el cliente...!!");
			}
		}
		if (request.getParameter("consultar") != null) {			
			long cedula = Integer.parseInt(request.getParameter("cedula"));						
			clientesDto client = libdao.buscar_Cliente(cedula);
			
			if (client != null) {				
				String email, nombre, direccion, telefono;
				//String estado; 
				cedula = client.getCedula_cliente();				
				email = client.getEmail_cliente();
				nombre = client.getNombre_cliente();
				direccion = client.getDireccion_cliente();
				telefono = client.getTelefono_cliente();
				
				

				response.sendRedirect("clientes.jsp?cedula=" + cedula + "&&nombre=" + nombre + "&&direccion=" + direccion
						+ "&&telefono=" + telefono + "&&email=" + email);
			} else {				
				response.sendRedirect("clientes.jsp?men=El usuario no existe!!!");				
			}						
		}
		
		if (request.getParameter("actualizar") != null) {				
			String email, nombre, direccion, telefono;
			int cedula;

			cedula = Integer.parseInt(request.getParameter("ced"));				
			email = request.getParameter("email");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("tel");

			clientesDto usua = new clientesDto(cedula, email, nombre, direccion, telefono);

			if (libdao.actualizar_Cliente(usua)) {				
				response.sendRedirect("clientes.jsp?men=Se Actualizo el Usuario exitosamente!!!");
			} else {
				response.sendRedirect("clientes.jsp?men=El Usuario no existe!!!");
			}
		}

		if (request.getParameter("eliminar") != null) {
			int cedula;
			cedula = Integer.parseInt(request.getParameter("cedula"));			
			
			if (libdao.eliminar_Cliente(cedula)) {
				response.sendRedirect("clientes.jsp?men=Usuario Eliminado");
			} else {
				response.sendRedirect("clientes.jsp?men=El Usuario no existe!!!");
			}			
		}		
		
		if(request.getParameter("limpiar") !=null) {
			String cedula, email, nombre, direccion, telefono, estado;			
			
			cedula = "";
			email = "";
			nombre = "";
			direccion = "";
			telefono = "";				
			estado = "enabled";
									
			response.sendRedirect("clientes.jsp?cedula=" + cedula + "&&email=" + email + "&&nombre=" + nombre
					+ "&&direccion=" + direccion + "&&telefono=" + telefono + "&&estado=" + estado);
		}
		
	}

}
