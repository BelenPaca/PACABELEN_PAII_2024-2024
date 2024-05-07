package main_package;
import java.sql.SQLException;

import Dao.Conexion;
import Dao.DAOStudent;
import Dao.DAOTeacher;
import model_package.Student;

/**
 * @author Belen Anahis Paca Silva
 * Tema: CONEXION BASE DE DATOS
 */

public class Main {

	public static void main(String[] args) throws SQLException {
    	// Crear un objeto Student
        DAOStudent student = new DAOStudent (1, "Alexander", "Freire", 25);
 
        
     // Metodo para crear la tabla
     student.createTable(Conexion.getConnection());
     
     
  // Creamos un profesor
     DAOTeacher teacher = new DAOTeacher(02, "Vinicio", "Lopez", 40);

	}

}
