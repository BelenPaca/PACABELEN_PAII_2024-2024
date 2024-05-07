package model_package;

public class Subjects {
	
	int id_Subject;
	int name;
	String description;
	int level;
	
	public  Subjects (	int id_Subject,int name,String description,int level) {
		// TODO Auto-generated constructor stub
		this.id_Subject = id_Subject;
		this.name = name;
		this.description = description;
		this.level = level;
	

}

	@Override
	public String toString() {
		return "Subjects [id=" + id_Subject + ", name=" + name + ", description=" + description + ", level=" + level + "]";
	}

	public int getId() {
		return id_Subject;
	}

	public void setId(int id) {
		this.id_Subject = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
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
