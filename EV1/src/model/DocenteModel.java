package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.Docente;
import util.MySqlCon;

public class DocenteModel {
	public int insertaDocente(Docente docente) {
		int insertados = 0;
			
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlCon.getConexion();
			String sql = "INSERT INTO docente(nombres, apellidos, fechaNacimiento, fechaIngreso, dni, direccion, estado) VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, docente.getNombres());
			ps.setString(2, docente.getApellidos());
			ps.setString(3, docente.getFechaNacimiento());
			ps.setString(4, docente.getFechaIngreso());
			ps.setString(5, docente.getDni());
			ps.setNString(6, docente.getDireccion());
			ps.setInt(7, docente.getEstado());

			insertados = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al insertar el docente: " + e.getMessage());
		} finally {
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion: " + e.getMessage());
			}
		}
		
		return insertados;
	}
}
