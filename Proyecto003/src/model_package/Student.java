package model_package;

public class Student {
	
	int id_Student;
	String name;
	String lastname;
	int age;
	
	public  Student (	int id_Student,String name,String lastname,int age) {
		// TODO Auto-generated constructor stub
		this.id_Student = id_Student;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
	

}

	@Override
	public String toString() {
		return "Student [id=" + id_Student + ", name=" + name + ", lastname=" + lastname + ", age=" + age + "]";
	}

	
	
	public int getId() {
		return id_Student;
	}

	public void setId(int id) {
		this.id_Student = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	}
