package cn.edu.tit.role.Iservice;

import java.util.List;

import cn.edu.tit.role.bean.Role;

public interface IRoleService {

	/**
	 * 查看角色信息
	 * @return：查看的角色对象
	 */
	public Role schRoleInfo(int role_id);
	
	/**
	 * 添加角色
	 * @param role：添加的角色信息
	 */
	public void addRole(Role role); 
	
	/**
	 * 修改角色信息
	 * @param role_id
	 */
	public void editRole(int role_id);
	
	/**
	 * 为角色添加用户
	 * @param role_id：角色id
	 * @param staff_id：添加的用户id列表
	 */
	public void addUserForRole(int role_id,List<String> staff_id);
}
