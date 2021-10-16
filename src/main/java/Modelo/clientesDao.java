package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.conexion;

// como se encuentra clientes en BD
public class clientesDao {

	conexion cnn = new conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean insertar_Cliente(clientesDto cliente) {

		boolean resul = false;
		clientesDto UsuarioEx = null;

		try {
			UsuarioEx = buscar_Cliente(cliente.getCedula_cliente());
			if (UsuarioEx == null) {
				String sql = "insert into clientes values(?,?,?,?,?)";
				ps = conec.prepareStatement(sql);
				ps.setLong(1, cliente.getCedula_cliente());				
				ps.setString(2, cliente.getDireccion_cliente());
				ps.setString(3, cliente.getEmail_cliente());
				ps.setString(4, cliente.getNombre_cliente());
				ps.setString(5, cliente.getTelefono_cliente());
				resul = ps.executeUpdate() > 0; 
			} else {
				JOptionPane.showMessageDialog(null, "El Usuario ya existe...");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Registrar al cliente" + e);
		}
		return resul;

	}

	public clientesDto buscar_Cliente(long cedula) {

		clientesDto usu = null;

		try {
			String sql = "select * from clientes where cedula_cliente=?";
			ps = conec.prepareStatement(sql);
			ps.setLong(1, cedula);
			res = ps.executeQuery();

			while (res.next()) {
				usu = new clientesDto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		return usu;
	}
	
	public boolean actualizar_Cliente(clientesDto cliente) {

		boolean resul = false;
		try {
			String sql = "update clientes set direccion_cliente=?, email_cliente=?, nombre_cliente=?,  telefono_cliente=? where cedula_cliente=?";
			ps = conec.prepareStatement(sql);
			ps.setLong(1, cliente.getCedula_cliente());
			ps.setString(2, cliente.getDireccion_cliente());
			ps.setString(3, cliente.getEmail_cliente());
			ps.setString(4, cliente.getNombre_cliente());
			ps.setString(5, cliente.getTelefono_cliente());
			resul = ps.executeUpdate() > 0; 

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Actualizar el cliente" + e);
		}
		return resul;
	}

	public boolean eliminar_Cliente(int cedula) {

		boolean resul = false;
		try {
			String sql = "delete from clientes where cedula_cliente=?";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			resul = ps.executeUpdate() > 0;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Eliminar el cliente" + e);
		}
		return resul;
	}
	
	public ArrayList<clientesDto> listarClientes(){
		clientesDto cDTO = null;
		ArrayList<clientesDto> lista = new ArrayList<>();
		try {
			String seleccionar = "SELECT * FROM clientes";
			ps = conec.prepareStatement(seleccionar);
			res = ps.executeQuery();
			while(res.next()) {
				cDTO = new clientesDto(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
				lista.add(cDTO);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al listar los clientes en dao. "+sqle);
		}
		return lista;
	}

}
