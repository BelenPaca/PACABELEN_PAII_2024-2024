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
				boolean val = connection.isValid(5000);
				System.out.println(val ? "La conexión se arealizado con exito" : "Fallo de la conexion");
			} catch (java.sql.SQLException e) {
				System.out.println("Error:" + e.getErrorCode());
			}
		}
		return connection;

}
	}
