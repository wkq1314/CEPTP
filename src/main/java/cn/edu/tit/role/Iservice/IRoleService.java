package cn.edu.tit.role.Iservice;

import java.util.List;

import cn.edu.tit.role.bean.Privilege;
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
	 * 添加的角色信息  包括(权限id列表，角色名称，父角色id，创建人工号)
	 */
	public void addRole(String role_name,List<Integer> privilegeList,String parentRoleId,String create_user); 
	
	/**
	 * 修改角色信息
	 * @param role_id
	 * 被修改角色id
	 * @param role_name
	 * 被修改角色名
	 * @param update_user
	 * 修改人工号
	 * @param old_privilegeIdList
	 * 被修改角色原权限列表
	 * @param new_privilegeIdList
	 * 被修改角色修改后的权限列表
	 */
	public void editRole(String role_id,String role_name,String update_user,List<Integer>old_privilegeIdList,List<Integer>new_privilegeIdList);
	
	
	/**
	 * 为角色添加用户
	 * @param role_id
	 * 被修改角色id
	 * @param staff_id
	 * 添加的用户id列表
	 * @param create_user
	 * 修改人id
	 */
	public void addUserForRole(String role_id,String create_user,List<String> staff_id);
	
	/**
	 * 查询所有角色
	 * @return
	 * 查询到的角色列表
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
	
	/**
	 * 查询某角色的所有权限
	 * @param role_id
	 * 某角色的id
	 * @return
	 */
	public List<Privilege> schPrivilegeByRId(String role_id);
	
	/**
	 * 删除某角色绑定的用户
	 * @param role_id
	 * 被修改角色id
	 * @param users
	 * 被解绑用户的id列表
	 */
	public void delUsersOfRole(String role_id,List<String> users);
}
