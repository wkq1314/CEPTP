package cn.edu.tit.course.bean;

import java.util.Date;

import org.springframework.stereotype.Repository;
@Repository
public class Course {
	
	private String course_id; //课程id (发布者id_时间戳)
	private String course_name; //课程名
	private String course_label; //课程标签
	private byte[] course_img; //课程图片
	private String course_notes; //课程备注（简介）
	private String college; //所属学校
	private String application_pro; //适合专业
	private int course_flag; //课程状态标志位（1：开始，2：截止）
	private String invitation_code; //邀请码
	private Boolean delete_flg;//是否删除
	private String create_user;//创建者
	private Date create_time;//创建时间
	private String update_user;//更新者
	private Date update_time;//更新时间
	
	
	//setter-getter
	
	public String getCourse_id() {
		return course_id;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getInvitation_code() {
		return invitation_code;
	}
	public void setInvitation_code(String invitation_code) {
		this.invitation_code = invitation_code;
	}
	public int getCourse_flag() {
		return course_flag;
	}
	public void setCourse_flag(int course_flag) {
		this.course_flag = course_flag;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public String getCourse_label() {
		return course_label;
	}
	public void setCourse_lable(String course_lable) {
		this.course_label = course_lable;
	}
	public byte[] getCourse_img() {
		return course_img;
	}
	public void setCourse_img(byte[] course_img) {
		this.course_img = course_img;
	}
	public String getCourse_notes() {
		return course_notes;
	}
	public void setCourse_notes(String course_notes) {
		this.course_notes = course_notes;
	}
	public String getApplication_pro() {
		return application_pro;
	}
	public void setApplication_pro(String application_pro) {
		this.application_pro = application_pro;
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
	
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
	public Course(String course_id, String course_name, String course_label, byte[] course_img, String course_notes,
			String college, String application_pro, int course_flag, String invitation_code, 
			String create_user) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_label = course_label;
		this.course_img = course_img;
		this.course_notes = course_notes;
		this.college = college;
		this.application_pro = application_pro;
		this.course_flag = course_flag;
		this.invitation_code = invitation_code;
		this.create_user = create_user;
	}
	public Course(){}
}
