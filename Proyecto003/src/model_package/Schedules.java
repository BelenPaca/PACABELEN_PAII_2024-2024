package model_package;

public class Schedules {
	
	int id_Schedules;
	int id_Subjects;
	int id_Student;
	int id_Teacher;
	int star_time;
	int end_time;
	String day;
	
	public Schedules(int id_Schedules,int id_Subject,int id_Student,int id_Teacher, int star_time,int end_time,String day) {
		this.id_Schedules = id_Schedules;
		this.id_Subjects = id_Subjects;
		this.id_Student = id_Student;
		this.id_Teacher = id_Teacher;
		this.star_time = star_time;
		this.end_time = end_time;
		this.day = day;
		
	}

	@Override
	public String toString() {
		return "Schedules [id=" + id_Schedules + ", id_Schedules=" + id_Subjects + ", id_Student=" + id_Student + ", id_Teacher="
				+ id_Teacher + ", star_time=" + star_time + ", end_time=" + end_time + ", day=" + day + "]";
	}

}

