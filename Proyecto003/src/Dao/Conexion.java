package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/instituto";
		String user = "root";
		String password = "root";

		Connection connection = null;

		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
				boolean valida = connection.isValid(5000);
				System.out.println(valida ? "La conexión se arealizado con exito" : "Fallo de conexion");
			} catch (java.sql.SQLException e) {
				System.out.println("Error sql:" + e.getErrorCode());
			}
		}
		return connection;

}
	}
