package cn.edu.tit.user.bean;

import java.util.Arrays;

import org.springframework.stereotype.Component;
@Component
public class User {
	private String user_id;// 学号、工号
	private String user_name;// 姓名
	private Boolean sex;// 性别
	private String password;// 密码
	private String class_name;// 班级
	private String professional_title; //职称
	private String degree; //学位
	private String detail; //简介
	private byte[] face; //头像
	private String pro;// 专业
	private String qq;// QQ号
	private String mobile;// 移动电话
	private String college;// 所在学院
	private String sec_college;// 二级学院（系）
	private Boolean delete_flg;//是否删除
	private String create_user;//创建者
	private String create_time;//创建时间
	private String update_user;//更新者
	private String update_time;//更新时间
	public User() {
		super();
	}
	
	public User(String user_id, String user_name, String class_name, String professional_title, String degree,
			String detail, byte[] face, String pro, String qq, String mobile, String college, String sec_college,
			String create_user, String create_time, String update_user, String update_time) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.class_name = class_name;
		this.professional_title = professional_title;
		this.degree = degree;
		this.detail = detail;
		this.face = face;
		this.pro = pro;
		this.qq = qq;
		this.mobile = mobile;
		this.college = college;
		this.sec_college = sec_college;
		this.create_user = create_user;
		this.create_time = create_time;
		this.update_user = update_user;
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", sex=" + sex + ", password=" + password
				+ ", class_name=" + class_name + ", professional_title=" + professional_title + ", degree=" + degree
				+ ", detail=" + detail + ", face=" + Arrays.toString(face) + ", pro=" + pro + ", qq=" + qq + ", mobile="
				+ mobile + ", college=" + college + ", sec_college=" + sec_college + ", delete_flg=" + delete_flg
				+ ", create_user=" + create_user + ", create_time=" + create_time + ", update_user=" + update_user
				+ ", update_time=" + update_time + "]";
	}

	public User(String user_id, String user_name, Boolean sex, String password, String class_name,
			String professional_title, String degree, String detail, byte[] face, String pro, String qq, String mobile,
			String college, String sec_college, Boolean delete_flg, String create_user, String create_time,
			String update_user, String update_time) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.sex = sex;
		this.password = password;
		this.class_name = class_name;
		this.professional_title = professional_title;
		this.degree = degree;
		this.detail = detail;
		this.face = face;
		this.pro = pro;
		this.qq = qq;
		this.mobile = mobile;
		this.college = college;
		this.sec_college = sec_college;
		this.delete_flg = delete_flg;
		this.create_user = create_user;
		this.create_time = create_time;
		this.update_user = update_user;
		this.update_time = update_time;
	}

	public User(String user_id, String user_name, Boolean sex, String password, String class_name,
			String professional_title, String degree, String detail, byte[] face, String pro, String qq, String mobile,
			String college, String sec_college) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.sex = sex;
		this.password = password;
		this.class_name = class_name;
		this.professional_title = professional_title;
		this.degree = degree;
		this.detail = detail;
		this.face = face;
		this.pro = pro;
		this.qq = qq;
		this.mobile = mobile;
		this.college = college;
		this.sec_college = sec_college;
	}

	//setter-getter
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getProfessional_title() {
		return professional_title;
	}
	public void setProfessional_title(String professional_title) {
		this.professional_title = professional_title;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public byte[] getFace() {
		return face;
	}
	public void setFace(byte[] face) {
		this.face = face;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getSec_college() {
		return sec_college;
	}
	public void setSec_college(String sec_college) {
		this.sec_college = sec_college;
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
	
	
}
