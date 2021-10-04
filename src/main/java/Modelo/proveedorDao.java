package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import Controlador.conexion;

public class proveedorDao {

	conexion cnn = new conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	

}
