package cn.edu.tit.user.bean;

public class Student {

	private String stu_id;// 学生学号
	private String stu_name;// 姓名
	private Boolean sex;// 性别
	private String password;// 密码
	private String class_id;// 班级
	private Integer pro_id;// 专业
	private String qq;// QQ号
	private String mobile;// 移动电话
	private String role_id;// 角色ID
	private Integer college_id;// 所以学院ID
	private Integer dept_id;// 所在系部ID
	// 学生构造函数
	public Student() {
	}

	public Student(String stu_id, String stu_name, Boolean sex, String password, String class_id, Integer pro_id,
			String qq, String mobile, String role_id, Integer college_id, Integer dept_id) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.sex = sex;
		this.password = password;
		this.class_id = class_id;
		this.pro_id = pro_id;
		this.qq = qq;
		this.mobile = mobile;
		this.role_id = role_id;
		this.college_id = college_id;
		this.dept_id = dept_id;
	}

	// setter-getter
	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public int getCollege_id() {
		return college_id;
	}

	public void setCollege_id(Integer college_id) {
		this.college_id = college_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

}
