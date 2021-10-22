package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ventasDAO {
	
	conexion cnn = new conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	
	public boolean crearDetalleventas(Detalle_VentasDTO detaDTO,long codigo_venta) {
		boolean resul=false;
		
		try {			
			 String insertar="INSERT INTO detalle_ventas(cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valor_iva) VALUES (?,?,?,?,?,?)";	
			 ps=conec.prepareStatement(insertar);	
			 ps.setInt(1,detaDTO.getCantidad_producto());
			 ps.setLong(2,detaDTO.getCodigo_producto());
			 ps.setLong(3,codigo_venta);
			 ps.setDouble(4,detaDTO.getValor_total());
			 ps.setDouble(5,detaDTO.getValor_venta());
			 ps.setDouble(6,detaDTO.getValor_iva());
			 resul=ps.executeUpdate()>0;
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al insertar el detalle de ventas "+ ex);
		}
		return resul;
	}
	
	
	public long consultarCodigoventa() {
		long cod = 0;
		
		try {			
			String ordenar="SELECT codigo_venta FROM ventas ORDER BY codigo_venta DESC LIMIT 1";
			 ps=conec.prepareStatement(ordenar);
			 res=ps.executeQuery();
			 while(res.next()) {
				 cod=res.getLong(1);
			 }		
		
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al Consultar el codigo en la base de datos "+ ex);
		}
		return cod;
	}
	
	public boolean crearVenta(ventasDTO venta, Detalle_VentasDTO dvDTO1, Detalle_VentasDTO dvDTO2, Detalle_VentasDTO dvDTO3) {
		boolean bool = false;

		try {
			String insertar="INSERT INTO ventas (cedula_cliente, cedula_usuario, iva_venta, total_venta, valor_venta) VALUES (?,?,?,?,?)";
			ps=conec.prepareStatement(insertar);			
			ps.setLong(1,venta.getCedulaCliente());
			ps.setLong(2,venta.getCedulaUsuario());
			ps.setDouble(3,venta.getIvaVenta());
			ps.setDouble(4,venta.getTotalVenta());
			ps.setDouble(5,venta.getValorVenta());		
			bool=ps.executeUpdate()>0;
			
			if(bool) {
				long codigo = consultarCodigoventa();
				crearDetalleventas(dvDTO1, codigo);
				crearDetalleventas(dvDTO2, codigo);
				crearDetalleventas(dvDTO3, codigo);
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al insertar la venta en dao "+ ex);
		}
		return bool;
	} 

	public ArrayList<ventasDTO> listarVentas() {
		ventasDTO ventDTO = null;
		ArrayList<ventasDTO> lista = new ArrayList<>();
		try {
			String sql = "select * from ventas";
			ps = conec.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()) {
				ventDTO = new ventasDTO(res.getLong(1), res.getLong(2), res.getLong(3), res.getDouble(4), res.getDouble(5), res.getDouble(6));
				lista.add(ventDTO);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al listar las ventas. "+ ex);
		}
		return lista;
	}
}