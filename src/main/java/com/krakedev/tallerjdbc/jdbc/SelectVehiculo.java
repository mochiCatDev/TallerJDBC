package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.tallerjdbc.entidades.Vehiculo;

public class SelectVehiculo {
	private static final Logger log = LoggerFactory.getLogger(SelectVehiculo.class);

	public static void listar() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = """
			SELECT placa, marca, modelo, anio, precio, color, disponible, kilometraje 
			FROM vehiculos;
		""";

		try {
			con = Conexion.conectar();
			if (con != null) {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				log.info("Listando vehículos registrados:");
				while (rs.next()) {
					String placa = rs.getString("placa");
					String marca = rs.getString("marca");
					String modelo = rs.getString("modelo");
					int anio = rs.getInt("anio");
					double precio = rs.getDouble("precio");
					String color = rs.getString("color");
					boolean disponible = rs.getBoolean("disponible");
					int kilometraje = rs.getInt("kilometraje");

					Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, anio, precio, color, disponible, kilometraje);
					System.out.println(vehiculo);
				}
			}
		} catch (SQLException e) {
			log.error("Error al consultar los vehículos", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				log.error("Error al cerrar los recursos de la consulta", e);
			}
		}
	}
}