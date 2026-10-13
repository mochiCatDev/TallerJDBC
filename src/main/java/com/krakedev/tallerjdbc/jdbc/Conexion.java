package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexion {
	private static final Logger log = LoggerFactory.getLogger(Conexion.class);
	private static final String URL = "jdbc:postgresql://localhost:5432/tallerjdbc";
	private static final String USER = "postgres";
	private static final String PASSWORD = "dilan428";

	public static Connection conectar() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			log.info("Conexión realizada con éxito a PostgreSQL");
		} catch (SQLException e) {
			log.error("Error de conexión a la base de datos", e);
		}
		return connection;
	}
}