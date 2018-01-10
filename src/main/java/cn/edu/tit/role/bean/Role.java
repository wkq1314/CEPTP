package cn.edu.tit.role.bean;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.tit.user.bean.Teacher;
@Repository
public class Role {
	private String role_id;  //角色id
	private List<Integer> privilegeIdList; //权限id
	private String role_name;  //角色名称
	private String parent_role_id;  //父角色id
	private String create_user;  //创建人id
	private String create_time; //创建时间
	private List<Teacher> teacherList;  //角色对应的用户 
	
	//setter-getter
	
	public String getParent_role_id() {
		return parent_role_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public void setParent_role_id(String parent_role_id) {
		this.parent_role_id = parent_role_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public List<Integer> getPrivilegeIdList() {
		return privilegeIdList;
	}
	public void setPrivilegeIdList(List<Integer> privilegeIdList) {
		this.privilegeIdList = privilegeIdList;
	}
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	
	
	
}
