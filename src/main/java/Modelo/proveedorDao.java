package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.conexion;

public class proveedorDao {

	conexion cnn = new conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean insertar_Proveedor(proveedorDto Proveedor) {

		boolean resul = false;
		proveedorDto ProveedorEx = null;

		try {
			ProveedorEx = buscar_Proveedor(Proveedor.getNit_proveedor());
			if (ProveedorEx == null) {
				String sql = "insert into Proveedores values(?,?,?,?,?)";
				ps = conec.prepareStatement(sql);
				ps.setLong(1, Proveedor.getNit_proveedor());
				ps.setString(2, Proveedor.getCiudad_proveedor());
				ps.setString(3, Proveedor.getDireccion_proveedor());
				ps.setString(4, Proveedor.getNombre_proveedor());
				ps.setString(5, Proveedor.getTelefono_proveedor());
				resul = ps.executeUpdate() > 0; 
			} else {
				JOptionPane.showMessageDialog(null, "El Proveedor ya existe...");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Registrar al Proveedor" + e);
		}
		return resul;
	}

	public proveedorDto buscar_Proveedor(long nit) {

		proveedorDto pro = null;

		try {
			String sql = "select * from proveedores where nit_proveedor=?";
			ps = conec.prepareStatement(sql);
			ps.setLong(1, nit);
			res = ps.executeQuery();

			while (res.next()) {
				pro = new proveedorDto(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar" + e);
		}
		return pro;
	}
	
	public boolean actualizar_Proveedor(proveedorDto prove) {

		boolean resul = false;
		try {
			String sql = "update proveedores set ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? where nit_proveedor=?";
			ps = conec.prepareStatement(sql);
			ps.setString(1, prove.getCiudad_proveedor());
			ps.setString(2, prove.getDireccion_proveedor());
			ps.setString(3, prove.getNombre_proveedor());
			ps.setString(4, prove.getTelefono_proveedor());
			ps.setLong(5, prove.getNit_proveedor());
			resul = ps.executeUpdate() > 0; 

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Actualizar el Proveedor" + e);
		}
		return resul;
	}

	public boolean eliminar_Proveedor(long nit) {

		boolean resul = false;
		try {
			String sql = "delete from proveedores where nit_proveedor=?";
			ps = conec.prepareStatement(sql);
			ps.setLong(1, nit);
			resul = ps.executeUpdate() > 0;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Eliminar el Proveedor" + e);
		}
		return resul;
	}

}
