package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteVehiculo {
	private static final Logger log = LoggerFactory.getLogger(DeleteVehiculo.class);

	public static void eliminar(String placa) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
			DELETE FROM vehiculos 
			WHERE placa = ?;
		""";

		try {
			con = Conexion.conectar();
			if (con != null) {
				ps = con.prepareStatement(sql);
				ps.setString(1, placa);

				int filasAfectadas = ps.executeUpdate();
				log.info("Vehículo eliminado con éxito. Filas afectadas: {}", filasAfectadas);
			}
		} catch (SQLException e) {
			log.error("Error al eliminar el vehículo con placa: {}", placa, e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar los recursos de eliminación", e);
			}
		}
	}
}