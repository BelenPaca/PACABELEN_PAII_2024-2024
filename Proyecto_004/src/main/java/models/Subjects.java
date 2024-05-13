package models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="subjects")
public class Subjects {
	
	@Id
	@Column(name="idsubjects")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="level")
	private int level;
	

public Subjects() {
	
}


public Subjects(int id, String name, String description, int level) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.level = level;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public int getLevel() {
	return level;
}


public void setLevel(int level) {
	this.level = level;
}

}



