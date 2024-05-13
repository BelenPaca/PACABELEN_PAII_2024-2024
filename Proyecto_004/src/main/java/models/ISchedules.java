package models;

public interface ISchedules {
	
	public void create(Schedules schedule);
	public Schedules read(Schedules schedules, String day);
	public void update(Schedules schedules, int id_schedules);
	public void delete(Schedules schedules, int id_schedules);	

}
