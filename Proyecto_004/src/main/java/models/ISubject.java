package models;

public interface ISubject {

	public void create(Subjects subject);
	public Subjects read(Subjects subject, String name);
	public void update(Subjects subject, int id);
	public void delete(Subjects subject, int id);

	
}
