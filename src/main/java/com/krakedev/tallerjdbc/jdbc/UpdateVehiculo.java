package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.tallerjdbc.entidades.Vehiculo;

public class UpdateVehiculo {
	private static final Logger log = LoggerFactory.getLogger(UpdateVehiculo.class);

	public static void actualizar(Vehiculo vehiculo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
			UPDATE vehiculos 
			SET marca = ?, modelo = ?, anio = ?, precio = ?, color = ?, disponible = ?, kilometraje = ?
			WHERE placa = ?;
		""";

		try {
			con = Conexion.conectar();
			if (con != null) {
				ps = con.prepareStatement(sql);
				ps.setString(1, vehiculo.getMarca());
				ps.setString(2, vehiculo.getModelo());
				ps.setInt(3, vehiculo.getAnio());
				ps.setDouble(4, vehiculo.getPrecio());
				ps.setString(5, vehiculo.getColor());
				ps.setBoolean(6, vehiculo.isDisponible());
				ps.setInt(7, vehiculo.getKilometraje());
				ps.setString(8, vehiculo.getPlaca());

				int filasAfectadas = ps.executeUpdate();
				log.info("Vehículo actualizado con éxito. Filas afectadas: {}", filasAfectadas);
			}
		} catch (SQLException e) {
			log.error("Error al actualizar el vehículo", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar los recursos de actualización", e);
			}
		}
	}
}