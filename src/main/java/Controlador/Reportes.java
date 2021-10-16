package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modelo.clientesDao;
import Modelo.clientesDto;
import Modelo.dao;
import Modelo.dto;
import Modelo.ventasDAO;
import Modelo.ventasDTO;


@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Reportes() {
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionjs");
		PrintWriter escribir = response.getWriter();
		Gson datos = new Gson();
		
		if(opcion.equals("Usuarios")) {
			dao uDAO = new dao();
			ArrayList<dto> listaU = new ArrayList<>();
			listaU = uDAO.listarUsuarios();
			escribir.println(datos.toJson(listaU));
		}
		
		if(opcion.equals("Clientes")) {
			clientesDao cDAO = new clientesDao();
			ArrayList<clientesDto> listaC = new ArrayList<>();
			listaC = cDAO.listarClientes();
			escribir.println(datos.toJson(listaC));
		}
		
		if(opcion.equals("Ventas")) {
			ventasDAO vDAO = new ventasDAO();
			ArrayList<ventasDTO> listaV = new ArrayList<>();
			listaV = vDAO.listarVentas();
			escribir.println(datos.toJson(listaV));
		}
	}

}
