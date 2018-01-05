package cn.edu.tit.role.Iservice;

import java.util.List;

import cn.edu.tit.role.bean.Role;

/**
 * 角色类业务逻辑接口
 * @author huang
 *
 */
public interface IRoleService {

	/**
	 * 查看角色的用户信息
	 * @return
	 * 查看的角色对象 包括(role_id,teacherList)
	 */
	public Role schRoleInfo(String role_id);
	
	/**
	 * 添加角色
	 * @param role
	 * 添加的角色信息  包括(权限id列表，角色名称，父角色id)
	 */
	public void addRole(Role role); 
	
	/**
	 * 修改角色信息
	 * @param role_id
	 */
	public void editRole(String role_id);
	/**
	 * 添加角色权限
	 * @param role_id
	 * 被修改角色id
	 */
	public void addRolePrivilege(String role_id);
	
	/**
	 * 删除角色权限
	 * @param role_id
	 * 被修改角色id
	 */
	public void delRolePrivilege(String role_id);
	
	/**
	 * 为角色添加用户
	 * @param role_id：角色id
	 * @param staff_id：添加的用户id列表
	 */
	public void addUserForRole(String role_id,List<String> staff_id);
	
	/**
	 * 查询所有角色
	 * @return：查询到的角色列表
	 */
	public List<Role> schAllRole();
	
	/**
	 * 查询某角色的所有字角色
	 * @param role_id
	 * 父角色id
	 * @return
	 * 自角色列表
	 */
	public List<Role> schAllChildRole(String role_id);
}
