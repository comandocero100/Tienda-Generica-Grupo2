package Modelo;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;

import Controlador.conexion;

public class dao {
	
	conexion cnn = new conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps=null;
	Resultset ress=null;
	
	public boolean lib_insertar(dto lib) {
		boolean resul=false;
		try {
			String sql="insert into clientes values(?,?,?,?,?)";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, lib.getCedula_cliente());
			ps.setString(2, lib.getDireccion_cliente());
			ps.setString(3, lib.getEmail_cliente());
			ps.setString(4, lib.getNombre_cliente());
			ps.setString(5, lib.getTelefono_cliente());
			resul=ps.executeUpdate()>0;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al insertar clientes"+e);
			
		}
		return resul;
	}
	
}
