package cn.edu.tit.user.bean;
public class ExcelT {

	private String staff_id;  //教师工号
	private String staff_name;  //教师名
	//private String password;  //登录密码
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
	private Boolean is_firstLogin;//是否第一次登陆
	private Boolean delete_flg;//是否删除
	private String create_user;//创建者
	private String create_time;//创建时间
	private String update_user;//更新者
	private String update_time;//更新时间
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
	/*public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public Integer getDegree_id() {
		return degree_id;
	}
	public void setDegree_id(Integer degree_id) {
		this.degree_id = degree_id;
	}
	public Integer getPro_title_id() {
		return pro_title_id;
	}
	public void setPro_title_id(Integer pro_title_id) {
		this.pro_title_id = pro_title_id;
	}
	public Integer getCollege_id() {
		return college_id;
	}
	public void setCollege_id(Integer college_id) {
		this.college_id = college_id;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public Integer getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIs_dimission() {
		return is_dimission;
	}
	public void setIs_dimission(Boolean is_dimission) {
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
	public Boolean getIs_firstLogin() {
		return is_firstLogin;
	}
	public void setIs_firstLogin(Boolean is_firstLogin) {
		this.is_firstLogin = is_firstLogin;
	}
	public Boolean getDelete_flg() {
		return delete_flg;
	}
	public void setDelete_flg(Boolean delete_flg) {
		this.delete_flg = delete_flg;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "ExcelT [staff_id=" + staff_id + ", staff_name=" + staff_name + ",  sex=" + sex
				+ ", degree_id=" + degree_id + ", pro_title_id=" + pro_title_id + ", college_id=" + college_id
				+ ", dept_id=" + dept_id + ", pro_id=" + pro_id + ", email=" + email + ", is_dimission=" + is_dimission
				+ ", phone=" + phone + ", mobile=" + mobile + ", is_firstLogin=" + is_firstLogin + ", delete_flg="
				+ delete_flg + ", create_user=" + create_user + ", create_time=" + create_time + ", update_user="
				+ update_user + ", update_time=" + update_time + "]";
	}
	
	//password=" + password + "
	
	
}
