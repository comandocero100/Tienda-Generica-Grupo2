package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ventasDTO;
import Modelo.clientesDto;
import Modelo.Detalle_VentasDAO;
import Modelo.Detalle_VentasDTO;
import Modelo.productosDTO;
import Modelo.ventasDAO;

@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Ventas() {
        super();
   
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Detalle_VentasDAO DETADAO = new Detalle_VentasDAO();
		ventasDAO ventadao = new ventasDAO();

		if (request.getParameter("consultar") != null) {

			long codigo_producto = Long.parseLong(request.getParameter("codigo_producto"));
			productosDTO deta = DETADAO.Buscar_Producto(codigo_producto);
			if (deta != null) {
				String nombre_producto;
				double precio_venta, iva_compra;
				codigo_producto = deta.getCodigoProducto();
				iva_compra = deta.getIvaCompra();
				nombre_producto = deta.getNombreProducto();
				precio_venta = deta.getPrecioVenta();

				response.sendRedirect("Ventas.jsp?codigo_producto=" + codigo_producto + "&&iva_compra=" + iva_compra
						+ "&&nombre_producto=" + nombre_producto + "&&precio_venta=" + precio_venta);
			} else {
				response.sendRedirect("Clientes.jsp?men=El producto no Existe");
			}
		}

		if (request.getParameter("consultar1") != null) {

			long codigo_producto1 = Long.parseLong(request.getParameter("codigo_producto1"));
			productosDTO deta = DETADAO.Buscar_Producto(codigo_producto1);
			if (deta != null) {
				String nombre_producto1;
				double precio_venta1, iva_compra1;
				codigo_producto1 = deta.getCodigoProducto();
				iva_compra1 = deta.getIvaCompra();
				nombre_producto1 = deta.getNombreProducto();
				precio_venta1 = deta.getPrecioVenta();

				response.sendRedirect("Ventas.jsp?codigo_producto1=" + codigo_producto1 + "&&iva_compra1=" + iva_compra1
						+ "&&nombre_producto1=" + nombre_producto1 + "&&precio_venta1=" + precio_venta1);
			} else {
				response.sendRedirect("Clientes.jsp?men=El producto no Existe");
			}
		}

		if (request.getParameter("consultar2") != null) {

			long codigo_producto2 = Long.parseLong(request.getParameter("codigo_producto2"));
			productosDTO deta = DETADAO.Buscar_Producto(codigo_producto2);
			if (deta != null) {
				String nombre_producto2;
				double precio_venta2, iva_compra2;
				codigo_producto2 = deta.getCodigoProducto();
				iva_compra2 = deta.getIvaCompra();
				nombre_producto2 = deta.getNombreProducto();
				precio_venta2 = deta.getPrecioVenta();

				response.sendRedirect("Ventas.jsp?codigo_producto2=" + codigo_producto2 + "&&iva_compra2=" + iva_compra2
						+ "&&nombre_producto2=" + nombre_producto2 + "&&precio_venta2=" + precio_venta2);
			} else {
				response.sendRedirect("Clientes.jsp?men=El producto no Existe");
			}
		}

		if (request.getParameter("consultar_cli") != null) {
			long cedula = Long.parseLong(request.getParameter("cedula"));
			clientesDto cli = DETADAO.Buscar_Cliente(cedula);
			if (cli != null) {
				String nombre;
				cedula = cli.getCedula_cliente();
				nombre = cli.getNombre_cliente();
				response.sendRedirect("Ventas.jsp?cedula=" + cedula + "&&nombre=" + nombre);
			} else {
				JOptionPane.showMessageDialog(null, "El Cliente No existe");
				response.sendRedirect("Ventas.jsp");
			}
		}

		if (request.getParameter("calcular") != null) {
			int cantidad = 0, cantidad1 = 0, cantidad2 = 0;			

			double precioV = 0, precioV1 = 0, precioV2 = 0, ivaProducto = 0, ivaProducto1 = 0, ivaProducto2 = 0,
					totalventaconiva = 0, totalventaconiva1 = 0, totalventaconiva2 = 0, totalVenta = 0, totalVenta1 = 0,
					totalVenta2 = 0, valorTotal = 0, totalIva = 0, totalConIva = 0;

			cantidad = Integer.parseInt(request.getParameter("cantidad"));
			cantidad1 = Integer.parseInt(request.getParameter("cantidad1"));
			cantidad2 = Integer.parseInt(request.getParameter("cantidad2"));

			precioV = Double.parseDouble(request.getParameter("precioV"));
			precioV1 = Double.parseDouble(request.getParameter("precioV1"));
			precioV2 = Double.parseDouble(request.getParameter("precioV2"));			

			totalVenta = cantidad * precioV;
			totalVenta1 = cantidad1 * precioV1;
			totalVenta2 = cantidad2 * precioV2;

			ivaProducto = totalVenta / 100 * Double.parseDouble(request.getParameter("ivap"));
			ivaProducto1 = totalVenta1 / 100 * Double.parseDouble(request.getParameter("ivap1"));
			ivaProducto2 = totalVenta2 / 100 * Double.parseDouble(request.getParameter("ivap2"));

			totalventaconiva = totalVenta + ivaProducto;
			totalventaconiva1 = totalVenta1 + ivaProducto1;
			totalventaconiva2 = totalVenta2 + ivaProducto2;

			valorTotal = totalVenta + totalVenta1 + totalVenta2;
			totalIva = ivaProducto + ivaProducto1 + ivaProducto2;
			totalConIva = valorTotal + totalIva;

			response.sendRedirect("Ventas.jsp?cantidad=" + cantidad + "&&cantidad1=" + cantidad1 + "&&cantidad2="
					+ cantidad2 + "&&totalventa=" + totalVenta + "&&totalventa1=" + totalVenta1 + "&&totalventa2="
					+ totalVenta2 + "&&totalventaconiva=" + totalventaconiva + "&&totalventaconiva1="
					+ totalventaconiva1 + "&&totalventaconiva2=" + totalventaconiva2 + "&&valorTotal=" + valorTotal
					+ "&&totalIva=" + totalIva + "&&totalConIva=" + totalConIva);
		} 

		if (request.getParameter("confirmar") != null) {			
			
			long cedulaUsuario = 123;
			long cedulaCliente = Long.parseLong(request.getParameter("cedula"));
			long codigo_producto, codigo_producto1, codigo_producto2;
			int cantidad, cantidad1, cantidad2;
			double totalventaconiva = 0, totalventaconiva1 = 0, totalventaconiva2 = 0, totalVenta = 0, totalVenta1 = 0,
					totalVenta2 = 0, ivaProducto = 0, ivaProducto1 = 0, ivaProducto2 = 0, valorTotal = 0, totalIva = 0,
					totalConIva = 0;

			totalIva = Double.parseDouble(request.getParameter("totalIva"));
			valorTotal = Double.parseDouble(request.getParameter("valorTotal"));
			totalConIva = Double.parseDouble(request.getParameter("totalConIva"));

			cantidad = Integer.parseInt(request.getParameter("cantidad"));
			cantidad1 = Integer.parseInt(request.getParameter("cantidad1"));
			cantidad2 = Integer.parseInt(request.getParameter("cantidad2"));

			ivaProducto = Double.parseDouble(request.getParameter("ivap"));
			ivaProducto1 = Double.parseDouble(request.getParameter("ivap1"));
			ivaProducto2 = Double.parseDouble(request.getParameter("ivap2"));

			codigo_producto = Long.parseLong(request.getParameter("codigo_producto"));
			codigo_producto1 = Long.parseLong(request.getParameter("codigo_producto1"));
			codigo_producto2 = Long.parseLong(request.getParameter("codigo_producto2"));

			totalventaconiva = Double.parseDouble(request.getParameter("valor_venta"));
			totalventaconiva1 = Double.parseDouble(request.getParameter("valor_venta1"));
			totalventaconiva2 = Double.parseDouble(request.getParameter("valor_venta2"));

			totalVenta = Double.parseDouble(request.getParameter("totalventa"));
			totalVenta1 = Double.parseDouble(request.getParameter("totalventa1"));
			totalVenta2 = Double.parseDouble(request.getParameter("totalventa2"));				
			
			ventasDTO venta = new ventasDTO(cedulaCliente, cedulaUsuario, totalIva, valorTotal, totalConIva);
			
			Detalle_VentasDTO productoDTO1 = new Detalle_VentasDTO(cantidad, codigo_producto, 0, totalVenta, totalventaconiva, ivaProducto);
			Detalle_VentasDTO productoDTO2 = new Detalle_VentasDTO(cantidad1, codigo_producto1, 0, totalVenta1, totalventaconiva1, ivaProducto1);
			Detalle_VentasDTO productoDTO3 = new Detalle_VentasDTO(cantidad2, codigo_producto2, 0, totalVenta2, totalventaconiva2, ivaProducto2);
			
			ventadao.crearVenta(venta, productoDTO1, productoDTO2, productoDTO3);
			
			long codigoVenta=ventadao.consultarCodigoventa();
			response.sendRedirect("Ventas.jsp?codigoVenta=" + codigoVenta);				
		}
		
		if(request.getParameter("Limpiar") != null) {
			response.sendRedirect("Ventas.jsp?limpiarVenta");			
		}
	}
}
