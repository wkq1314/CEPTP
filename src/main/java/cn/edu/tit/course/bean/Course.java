package cn.edu.tit.course.bean;

public class Course {
	
	private String course_id; //课程id
	private String course_name; //课程名
	private String course_lable; //课程标签
	private byte[] course_img; //课程图片
	private String course_notes; //课程备注（简介）
	private String application_pro; //适合专业
	private Boolean delete_flg;//是否删除
	private String create_user;//创建者
	private String create_time;//创建时间
	private String update_user;//更新者
	private String update_time;//更新时间
	
	
	//setter-getter
	public String getCourse_id() {
		return course_id;
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
	
	public String getCourse_lable() {
		return course_lable;
	}
	public void setCourse_lable(String course_lable) {
		this.course_lable = course_lable;
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
