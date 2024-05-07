package model_package;

import java.sql.Connection;
import java.sql.SQLException;
public interface IDAOStudent {
	
	public void create(Connection conection, Student student) throws SQLException;
	public void read(Connection connection, Student student, int id_Student) throws SQLException;
	public void update(Connection connection, Student student, int id_Student) throws SQLException;
	public void delete(Connection connection,int id_Studen) throws SQLException;
	public void createTable(Connection connection)throws SQLException;
	

}
