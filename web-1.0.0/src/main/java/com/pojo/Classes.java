package com.pojo;

public class Classes {
	private int id;
	private String name;
	private int teacher_id;
	private int student_id;
	private Teacher teacher;
	private Student student;

	public Classes(int id, String name, Teacher teacher, Student student) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.student = student;
	}

	public Classes(int id, String name, int teacher_id, int student_id, Teacher teacher, Student student) {
		this.id = id;
		this.name = name;
		this.teacher_id = teacher_id;
		this.student_id = student_id;
		this.teacher = teacher;
		this.student = student;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public Classes() {
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", teacher_id=" + teacher_id + ", student_id=" + student_id
				+ ", teacher=" + teacher + ", student=" + student + "]";
	}

}
