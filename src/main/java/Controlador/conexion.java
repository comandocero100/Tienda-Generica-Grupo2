package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class conexion {

	private String bd = "tiendagenerica_bd";
	private String url = "jdbc:mysql://localhost:3306/" + bd;
	private String user = "root";
	private String pass = "";

	Connection conec = null;

	public Connection Conecta() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conec = DriverManager.getConnection(url, user, pass);
			JOptionPane.showMessageDialog(null, " conexion ok");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error de conexion..." + e);
		}
		
		return conec;
	}

}

