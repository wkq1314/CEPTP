package cn.edu.tit.role.Idao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import cn.edu.tit.role.bean.Role;

/**
 * 角色类持久层接口
 * @author huang
 *
 */
@Component
public interface IRoleDao {
	/**
	 * 通过id查询某角色的信息
	 * @param role_id：角色id
	 * @return: 角色对象
	 */
	public Role findRoleById(String role_id);
	
	/**
	 * 通过父角色id查找其已有子角色数量
	 * @param role_id
	 * 父角色id
	 * @return
	 * 已有子角色数量
	 */
	public int findChildRoleNumById(String role_id);
	
	/**
	 * 向数据库中保存role
	 * @param role
	 * 得到的role对象数据
	 */
	public void addRole(@Param("role_id")String role_id,@Param("role_name")String role_name,
			@Param("create_user")String create_user,@Param("create_time")String create_time,
			@Param("update_user")String update_user,@Param("update_time")String update_time);
	
	/**
	 * 向数据库中保存role-privilege关系
	 * @param role_id
	 * 角色id
	 * @param privilege_id
	 * 权限id
	 */
	public void addRolePrivilege(@Param("role_id")String role_id,@Param("privilege_id")int privilege_id,
			@Param("create_user")String create_user,@Param("create_time")String create_time,
			@Param("update_user")String update_user,@Param("update_time")String update_time);
	
}
