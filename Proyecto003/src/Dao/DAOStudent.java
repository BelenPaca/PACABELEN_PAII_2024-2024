package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model_package.IDAOStudent;
import model_package.Student;

public class DAOStudent extends Student implements IDAOStudent {
	
	private PreparedStatement pre;
	private String table = "Student";

	public DAOStudent(int id_Student, String name, String lastname, int age) {
		super(id_Student, name, lastname, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Connection conection, Student student) throws SQLException {
		// TODO Auto-generated method stub
		pre = conection.prepareStatement("INSERT INTO" + table + "(idStudent, name, lastname,age) VALUES(?,?,?,?)");
		pre.setInt(1, student.getId());
		pre.setString(2, student.getName());
		pre.setString(3, student.getLastname());
		pre.setInt(4, student.getAge());
		pre.execute();
		pre.close();
		
	}

	@Override
	public void read(Connection connection, Student student, int id_Student) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet results = null;
		String sql = null;
		student = new Student (0, "", "", 0);

		try {
			sql = "SELECT * FROM " + table + " WHERE id = ?";
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id_Student);
			results = pre.executeQuery();

			if (results.next()) {
				student.setId(results.getInt(1));
				student.setName(results.getString(2));
				student.setLastname(results.getString(3));
				student.setAge(results.getInt(4));
			}

			System.out.println(student.toString());;

			pre.execute();
			pre.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

		
	

	@Override
	public void update(Connection connection, Student student, int id_Student) throws SQLException {
		// TODO Auto-generated method stub
		
		pre= connection.prepareStatement("UPDATE " + table + " SET name=?, lastname=?, age=? WHERE id=?");
		pre.setString(1, student.getName());
		pre.setString(2, student.getLastname());
		pre.setInt(3, student.getAge());
		pre.setInt(4, id_Student);
		pre.execute();
		pre.close();
		
	}

	@Override
	public void delete(Connection connection, int id_Studen) throws SQLException {
		// TODO Auto-generated method stub
		pre = connection.prepareStatement("DELETE FROM " + table + " WHERE id=?");
		pre.setInt(1, id_Studen);
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
