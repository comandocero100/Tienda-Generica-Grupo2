package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
import Controlador.conexion;

public class productosDAO {
	
	conexion cnn = new conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;	
	
	public boolean cargar_Productos(String Ruta) {	
		
		boolean resul=false;
		
		try {			
			
			String sql="load data infile '"+Ruta+"' replace into table productos fields terminated by ',' lines terminated by '\r\n'";
			//String sql="load data infile '"+Ruta+"' into table productos fields terminated by ',' lines terminated by '\r\n'";
			ps=conec.prepareStatement(sql);
			resul=ps.executeUpdate()>0;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: formato de archivo invalido " + ex);			
		}
		return resul;
	}		
}
