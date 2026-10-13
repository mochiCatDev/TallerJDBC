package com.krakedev.tallerjdbc;

import com.krakedev.tallerjdbc.entidades.Vehiculo;
import com.krakedev.tallerjdbc.jdbc.DeleteVehiculo;
import com.krakedev.tallerjdbc.jdbc.InsertVehiculo;
import com.krakedev.tallerjdbc.jdbc.SelectVehiculo;
import com.krakedev.tallerjdbc.jdbc.UpdateVehiculo;

public class Principal {
	public static void main(String[] args) {
		System.out.println("=== INICIO DE PRUEBAS CRUD JDBC CON KILOMETRAJE ===");

		Vehiculo vehiculoNuevo = new Vehiculo("XYZ-9876", "Chevrolet", "Aveo", 2021, 11500.0, "Negro", true, 45000);
		
		System.out.println("\n--- 1. INSERTAR VEHICULO ---");
		InsertVehiculo.insertar(vehiculoNuevo);

		System.out.println("\n--- 2. SELECCIONAR / LISTAR VEHICULOS ---");
		SelectVehiculo.listar();

		System.out.println("\n--- 3. ACTUALIZAR VEHICULO ---");
		Vehiculo vehiculoActualizado = new Vehiculo("XYZ-9876", "Chevrolet", "Sail", 2023, 13000.0, "Gris", false, 48000);
		UpdateVehiculo.actualizar(vehiculoActualizado);

		System.out.println("\n--- 4. LISTAR DESPUES DE ACTUALIZAR ---");
		SelectVehiculo.listar();

		System.out.println("\n--- 5. ELIMINAR VEHICULO ---");
		DeleteVehiculo.eliminar("XYZ-9876");

		System.out.println("\n--- 6. LISTAR FINAL ---");
		SelectVehiculo.listar();

		System.out.println("\n=== FIN DE PRUEBAS CRUD JDBC CON KILOMETRAJE ===");
	}
}