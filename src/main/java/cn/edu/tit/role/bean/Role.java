package cn.edu.tit.role.bean;

import java.util.List;

import cn.edu.tit.user.bean.Teacher;

public class Role {
	private int role_id;  //角色id
	private List<Integer> privilege_id; //权限id
	private String role_name;  //角色名称
	private String create_role_id;  //父角色id
	private List<Teacher> teacher;  //角色对应的用户 
	
	//setter-getter
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public List<Integer> getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(List<Integer> privilege_id) {
		this.privilege_id = privilege_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getCreate_role_id() {
		return create_role_id;
	}
	public void setCreate_role_id(String create_role_id) {
		this.create_role_id = create_role_id;
	}
	public List<Teacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}
	
	
	
}
