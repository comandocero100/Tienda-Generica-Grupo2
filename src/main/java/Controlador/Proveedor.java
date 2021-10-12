package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.proveedorDao;
import Modelo.proveedorDto;


@WebServlet("/Proveedor")
public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Proveedor() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		proveedorDao proveed = new proveedorDao();

		if (request.getParameter("insertar") != null) {			
			long nit;
			String ciudad, direccion, nombre, telefono;			

			nit = Long.parseLong(request.getParameter("nit"));
			ciudad = request.getParameter("ciudad");
			direccion = request.getParameter("direccion");			
			nombre = request.getParameter("nombre");			
			telefono = request.getParameter("tel");			

			proveedorDto proveeDTO = new proveedorDto(nit, ciudad, direccion, nombre, telefono);

			if (proveed.insertar_Proveedor(proveeDTO)) {
				response.sendRedirect("Proveedores.jsp?men=Se Registro el Proveedor exitosamente!!!");
			} else {
				response.sendRedirect("Proveedores.jsp?men=No se Registro el Proveedor...");
			}
		}
		
		if (request.getParameter("consultar") != null) {			
			long nit = Long.parseLong(request.getParameter("nit"));						
			proveedorDto pro = proveed.buscar_Proveedor(nit);
			
			if (pro != null) {				
				String ciudad, direccion, nombre, telefono;				
				nit = pro.getNit_proveedor();
				ciudad = pro.getCiudad_proveedor();
				direccion = pro.getDireccion_proveedor();				
				nombre = pro.getNombre_proveedor();
				telefono = pro.getTelefono_proveedor();

				response.sendRedirect("Proveedores.jsp?nit=" + nit + "&&ciudad=" + ciudad + "&&direccion=" + direccion
						+ "&&nombre=" + nombre + "&&tel=" + telefono);
			} else {
				response.sendRedirect("Proveedores.jsp?men=El Proveedor no existe...");
			}
		}
		
		if (request.getParameter("actualizar") != null) {				
			String ciudad, direccion, nombre, telefono;	
			long nit;

			nit = Long.parseLong(request.getParameter("nit"));	
			ciudad = request.getParameter("ciudad");
			direccion = request.getParameter("direccion");			
			nombre = request.getParameter("nombre");
			telefono = request.getParameter("tel");

			proveedorDto pro = new proveedorDto(nit, ciudad, direccion, nombre, telefono);

			if (proveed.actualizar_Proveedor(pro)) {				
				response.sendRedirect("Proveedores.jsp?men=Se Actualizo el Proveedor exitosamente!!!");
			} else {
				response.sendRedirect("Proveedores.jsp?men=No se Actualizo el Proveedor...");
			}
		}

		if (request.getParameter("eliminar") != null) {
			long nit;
			nit = Long.parseLong(request.getParameter("nit"));				
			
			if (proveed.eliminar_Proveedor(nit)) {
				response.sendRedirect("Proveedores.jsp?men=Proveedor Eliminado");
			} else {
				response.sendRedirect("Proveedores.jsp?men=El Proveedor no existe...");
			}			
		}	
		
		if(request.getParameter("limpiar") !=null) {
			String nit, ciudad, direccion, nombre, telefono;			
			
			nit = "";
			ciudad = "";
			direccion = "";
			nombre = "";
			telefono = "";				
												
			response.sendRedirect("Proveedores.jsp?nit=" + nit + "&&ciudad=" + ciudad + "&&direccion=" + direccion
					+ "&&nombre=" + nombre + "&&tel=" + telefono);
		}
		
	}

}
