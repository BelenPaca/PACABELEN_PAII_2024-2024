package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model_package.IDAOTeacher;
import model_package.Student;
import model_package.Teacher;

public class DAOTeacher extends Teacher implements IDAOTeacher {

	private PreparedStatement pre;
	private String table = "Student";

	public DAOTeacher(int id_Student, String name, String lastname, int age) {
		super(id_Student, name, lastname, age);
		// TODO Auto-generated constructor stub
		

	}

	@Override
	public void create(Connection conection, Teacher teacher) throws SQLException {
		// TODO Auto-generated method stub
		pre = conection.prepareStatement("INSERT INTO" + table + "(idStudent, name, lastname,age) VALUES(?,?,?,?)");
		pre.setInt(1, teacher.getId());
		pre.setString(2, teacher.getName());
		pre.setString(3, teacher.getLastname());
		pre.setInt(4, teacher.getAge());
		pre.execute();
		pre.close();
		
	}

	@Override
	public void read(Connection connection, Teacher teacher, int id_Teacher) throws SQLException {
		// TODO Auto-generated method stub
		
		ResultSet results = null;
		String sql = null;
		teacher = new Teacher (0, "", "", 0);

		try {
			sql = "SELECT * FROM " + table + " WHERE id = ?";
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id_Teacher);
			results = pre.executeQuery();

			if (results.next()) {
				teacher.setId(results.getInt(1));
				teacher.setName(results.getString(2));
				teacher.setLastname(results.getString(3));
				teacher.setAge(results.getInt(4));
			}

			System.out.println(teacher.toString());;

			pre.execute();
			pre.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
		
	

	@Override
	public void update(Connection connection, Teacher teacher, int id_Teacher) throws SQLException {
		// TODO Auto-generated method stub
		
		pre= connection.prepareStatement("UPDATE " + table + " SET name=?, lastname=?, age=? WHERE id=?");
		pre.setString(1, teacher.getName());
		pre.setString(2, teacher.getLastname());
		pre.setInt(3, teacher.getAge());
		pre.setInt(4, id_Teacher);
		pre.execute();
		pre.close();
		
	}

	@Override
	public void delete(Connection connection, int id_Teacher) throws SQLException {
		// TODO Auto-generated method stub
		
		pre = connection.prepareStatement("DELETE FROM " + table + " WHERE id=?");
		pre.setInt(1, id_Teacher);
		pre.execute();
		pre.close();
		
	}

	@Override
	public void createTable(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		String query = "CREATE TABLE IF NOT EXISTS " + table + " ( " + "id INT PRIMARY KEY," + "name VARCHAR(45),"
				+ "lastname VARCHAR(45)," + "age INT" + ")";
		connection.createStatement().executeUpdate(query);
		System.out.println("La tabla ya existe.");
	}




}
