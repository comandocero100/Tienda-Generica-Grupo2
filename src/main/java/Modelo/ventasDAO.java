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
	
	public ArrayList<ventasDTO> listarVentas() {
		ventasDTO vDTO = null;
		ArrayList<ventasDTO> lista = new ArrayList<>();
		try {
			String seleccionar = "SELECT * FROM ventas";
			ps = conec.prepareStatement(seleccionar);
			res = ps.executeQuery();
			while(res.next()) {
				vDTO = new ventasDTO(res.getLong(1), res.getLong(2), res.getLong(3), res.getDouble(4), res.getDouble(5), res.getDouble(6));
				lista.add(vDTO);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al listar las ventas en dao. "+sqle);
		}
		return lista;
	}
}
