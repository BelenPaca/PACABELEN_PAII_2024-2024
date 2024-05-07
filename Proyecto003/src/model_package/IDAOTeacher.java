package model_package;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAOTeacher {
	
	public void create(Connection conection, Teacher teacher) throws SQLException;
	public void read(Connection connection, Teacher teacher, int id_Teacher) throws SQLException;
	public void update(Connection connection, Teacher teacher, int id_Teacher) throws SQLException;
	public void delete(Connection connection,int id_Teacher) throws SQLException;
	public void createTable(Connection connection)throws SQLException;
	

}
