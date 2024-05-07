package model_package;

public class Teacher {
	
	int id_Teacher;
	String name;
	String lastname;
	int age;
	
	public  Teacher (	int id_Teacher,	String name,	String lastname,int age) {
		// TODO Auto-generated constructor stub
		this.id_Teacher = id_Teacher;
		this.name = name;
		this.lastname = lastname;
		this.age = age;

}

	@Override
	public String toString() {
		return "Teacher [id=" + id_Teacher + ", name=" + name + ", lastname=" + lastname + ", age=" + age + "]";
	}

	
	
	public int getId() {
		return id_Teacher;
	}

	public void setId(int id) {
		this.id_Teacher = id;
	}

	public 	String getName() {
		return name;
	}

	public void setName(	String name) {
		this.name = name;
	}

	public 	String getLastname() {
		return lastname;
	}

	public void setLastname(	String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	}

