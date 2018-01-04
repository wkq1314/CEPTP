package cn.edu.tit.user.bean;


public class Teacher {
	private String staff_id;  //教师工号
	private String staff_name;  //教师名
	private String password;  //登录密码
	private boolean sex;  //性别
	private int degree_id;  //学位id
	private int pro_title_id;  //职称id
	private int college_id;  //所在学院
	private int dept_id;  //所在系部
	private int pro_id;  //所在专业
	private String email;  //邮箱
	private boolean is_dimission;  //是否离职
	private String phone;  //固定电话
	private String mobile;  //移动电话
	
	
	//setter-getter
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getDegree_id() {
		return degree_id;
	}
	public void setDegree_id(int degree_id) {
		this.degree_id = degree_id;
	}
	public int getPro_title_id() {
		return pro_title_id;
	}
	public void setPro_title_id(int pro_title_id) {
		this.pro_title_id = pro_title_id;
	}
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIs_dimission() {
		return is_dimission;
	}
	public void setIs_dimission(boolean is_dimission) {
		this.is_dimission = is_dimission;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
