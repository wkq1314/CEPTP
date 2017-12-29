package cn.edu.tit.user.bean;

public class User {
	private Student student; //学生用户
	private Teacher teacher; //教师用户
	
	//setter-getter
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
