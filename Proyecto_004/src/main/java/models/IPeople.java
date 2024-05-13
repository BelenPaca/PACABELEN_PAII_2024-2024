package models;

public interface IPeople {
	
	public void create(People people);
	public void update(People people, int id);
	public void delete(People people, int id);
	<T> T read(Class<T> entityClass, String name);

}
