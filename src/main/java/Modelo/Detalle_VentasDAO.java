package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import Controlador.conexion;

public class Detalle_VentasDAO {
	
	conexion cnn = new conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;
	
public productosDTO Buscar_Producto(long codigo_producto) {
		
	productosDTO deta=null;
		try {
		String sql="SELECT codigo_producto, iva_compra, nombre_producto, precio_venta FROM productos where codigo_producto=?";
		ps=conec.prepareStatement(sql);		
		ps.setLong(1,codigo_producto);
		res=ps.executeQuery();
		while(res.next()) {
			deta = new productosDTO(res.getLong(1),res.getDouble(2),res.getString(3),res.getDouble(4));
		}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al Consultar el productos"+ ex);
		}
		return deta;		
	}

	
	public clientesDto Buscar_Cliente (long cedula) {
		clientesDto cli=null;
    	
		try {
	    	String sql="SELECT cedula_cliente, nombre_cliente FROM clientes where cedula_cliente=?";
	    	ps=conec.prepareStatement(sql);
	    	ps.setLong(1, cedula);
	    	res=ps.executeQuery();
	    	while(res.next()) {
	    		cli= new clientesDto(res.getLong(1),res.getString(2));
	    	}
    	}catch(SQLException ex) {
    		JOptionPane.showMessageDialog(null, "Error al Consultar"+ ex);
    	}
    	return cli;
    }
}