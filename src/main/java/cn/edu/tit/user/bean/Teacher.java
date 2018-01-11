package cn.edu.tit.user.bean;


public class Teacher {
	private String staff_id;  //教师工号
	private String staff_name;  //教师名
	private String password;  //登录密码
	private Boolean sex;  //性别
	private Integer degree_id;  //学位id
	private Integer pro_title_id;  //职称id
	private Integer college_id;  //所在学院
	private Integer dept_id;  //所在系部
	private Integer pro_id;  //所在专业
	private String email;  //邮箱
	private Boolean is_dimission;  //是否离职
	private String phone;  //固定电话
	private String mobile;  //移动电话
	//Teacher构造函数
	public Teacher() {

	}

	public Teacher(String staff_id, String staff_name, String password, Boolean sex, Integer degree_id, Integer pro_title_id,
			Integer college_id,Integer dept_id, Integer pro_id, String email, Boolean is_dimission, String phone, String mobile ) {
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.password = password;
		this.sex = sex;
		this.degree_id = degree_id;
		this.pro_title_id = pro_title_id;
		this.college_id = college_id;
		this.dept_id = dept_id;
		this.pro_id = pro_id;
		this.email = email;
		this.is_dimission = is_dimission;
		this.phone = phone;
		this.mobile = mobile;
	}
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
		this.staff_name = staff_name == null ? null : staff_name.trim();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public int getDegree_id() {
		return degree_id;
	}
	public void setDegree_id(Integer degree_id) {
		this.degree_id = degree_id;
	}
	public int getPro_title_id() {
		return pro_title_id;
	}
	public void setPro_title_id(Integer pro_title_id) {
		this.pro_title_id = pro_title_id;
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
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}
	public boolean isIs_dimission() {
		return is_dimission;
	}
	public void setIs_dimission(Boolean is_dimission) {
		this.is_dimission = is_dimission;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile== null ? null : mobile.trim();
	}
}
