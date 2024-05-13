package models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="schedules")

public class Schedules implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idschedules")
	private int id;
	
	@Id
	@Column(name="idStudent")
	private int idStudent;
	@Id
	@Column(name="idteacher")
	private int idTeacher;
	
	
	@Column(name="star_time")
	private int star_time;

	@Column(name="end_time")
	private int end_time;

	@Column(name="day")
	private String day;
	
	 public Schedules() {

		
	}

	public Schedules(int id, int idStudent, int idTeacher, int star_time, int end_time, String day) {
		super();
		this.id = id;
		this.idStudent = idStudent;
		this.idTeacher = idTeacher;
		this.star_time = star_time;
		this.end_time = end_time;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public int getStar_time() {
		return star_time;
	}

	public void setStar_time(int star_time) {
		this.star_time = star_time;
	}

	public int getEnd_time() {
		return end_time;
	}

	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	 
	 }
