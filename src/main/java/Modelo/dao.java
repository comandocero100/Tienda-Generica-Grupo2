package Modelo;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import java.sql.*;

import Controlador.conexion;

public class dao {

	conexion cnn = new conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean insertar_Usuario(dto usuario) {

		boolean resul = false;
		dto UsuarioEx = null;

		try {
			UsuarioEx = buscar_Usuario(usuario.getCedula());
			if (UsuarioEx == null) {
				String sql = "insert into usuarios values(?,?,?,?,?)";
				ps = conec.prepareStatement(sql);
				ps.setInt(1, usuario.getCedula());				
				ps.setString(2, usuario.getEmail());
				ps.setString(3, usuario.getNombre());
				ps.setString(4, usuario.getClave());
				ps.setString(5, usuario.getUsuario());
				resul = ps.executeUpdate() > 0; 
			} else {
				JOptionPane.showMessageDialog(null, "El Usuario ya existe...");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Registrar al Usuario" + e);
		}
		return resul;

	}

	public dto buscar_Usuario(int cedula) {

		dto usu = null;

		try {
			String sql = "select * from usuarios where cedula_usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			res = ps.executeQuery();

			while (res.next()) {
				usu = new dto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		return usu;
	}
	
	public boolean actualizar_Usuario(dto usuario) {

		boolean resul = false;
		try {
			String sql = "update usuarios set email_usuario=?, nombre_usuario=?, password_usuario=?, usuario=? where cedula_usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getClave());
			ps.setString(4, usuario.getUsuario());
			ps.setInt(5, usuario.getCedula());
			resul = ps.executeUpdate() > 0; 

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Actualizar el Usuario" + e);
		}
		return resul;
	}

	public boolean eliminar_Usuario(int cedula) {

		boolean resul = false;
		try {
			String sql = "delete from usuarios where cedula_usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setInt(1, cedula);
			resul = ps.executeUpdate() > 0;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Eliminar el Usuario" + e);
		}
		return resul;
	}

}
