package model_package;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAOSchedules {
	
	public void create(Connection conection, Schedules schedules) throws SQLException;
	public void read(Connection connection, Schedules schedules, int id_Schedules) throws SQLException;
	public void update(Connection connection, Student schedules, int id_Schedules) throws SQLException;
	public void delite(Connection connection,int id_Schedules) throws SQLException;
	public void createTable(Connection connection)throws SQLException;

}
