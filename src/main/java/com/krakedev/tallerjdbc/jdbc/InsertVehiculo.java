package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.tallerjdbc.entidades.Vehiculo;

public class InsertVehiculo {
	private static final Logger log = LoggerFactory.getLogger(InsertVehiculo.class);

	public static void insertar(Vehiculo vehiculo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
			INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible, kilometraje)
			VALUES (?, ?, ?, ?, ?, ?, ?, ?);
		""";

		try {
			con = Conexion.conectar();
			if (con != null) {
				ps = con.prepareStatement(sql);
				ps.setString(1, vehiculo.getPlaca());
				ps.setString(2, vehiculo.getMarca());
				ps.setString(3, vehiculo.getModelo());
				ps.setInt(4, vehiculo.getAnio());
				ps.setDouble(5, vehiculo.getPrecio());
				ps.setString(6, vehiculo.getColor());
				ps.setBoolean(7, vehiculo.isDisponible());
				ps.setInt(8, vehiculo.getKilometraje());

				ps.executeUpdate();
				log.info("Vehículo insertado con éxito: {}", vehiculo.getPlaca());
			}
		} catch (SQLException e) {
			log.error("Error al insertar el vehículo", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar la conexión o el PreparedStatement", e);
			}
		}
	}
}