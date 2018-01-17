package cn.edu.tit.role.Idao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Component;

import cn.edu.tit.role.bean.Privilege;
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
	 * @param parentRoleId
	 * 父角色id
	 * @return
	 * 已有子角色数量
	 */
	public int findChildRoleNumById(String parentRoleId);
	
	/**
	 * 向数据库中保存role
	 * @param role
	 * 得到的role对象数据
	 */
	public void addRole(@Param("role_id")String role_id,@Param("role_name")String role_name,
			@Param("parent_role_id")String parent_role_id,@Param("create_user")String create_user);

	/**
	 * 修改角色名
	 * @param role_id
	 * 被修改角色id
	 * @param roleName
	 * 被修改的新角色名
	 * @param updateUser
	 * 修改人id
	 */
	public void updateRoleName(@Param("role_id")String role_id,@Param("role_name")String roleName,
			@Param("update_user")String updateUser);
	
	/**
	 * 向数据库中保存role-privilege关系
	 * @param role_id
	 * 角色id
	 * @param privilege_id
	 * 权限id
	 */
	public void addRolePrivilege(@Param("role_id")String role_id,@Param("privilege_id")int privilege_id,
			@Param("create_user")String create_user);
	
	/**
	 * 获得被修改角色及其所有子角色的id
	 * @param role_id
	 * 被修改角色id
	 */
	public List<String> getAllChildRoleId(String role_id);
	
	/**
	 * 根据id删除角色权限（逻辑删除）
	 * @param role_id
	 * 被修改角色id
	 */
	public void delRolePrivilegeById(@Param("role_id")String role_id,@Param("privilege_id")int privilege_id);
	
	/**
	 * 为角色绑定用户
	 * @param role_id
	 * 绑定的角色id
	 * @param user_id
	 * 添加的用户id
	 */
	public void addUserForRole(@Param("role_id")String role_id,@Param("user_id")String user_id,
			@Param("create_user")String create_user);
	/**
	 * 为角色解绑用户
	 * @param role_id
	 * 被修改的角色id
	 * @param user_id
	 * 解绑的用户id
	 */
	public void delUsersOfRole(@Param("role_id")String role_id,@Param("user_id")String user_id);
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> findAllRole();
	/**
	 * 查询所有子角色
	 * @param role_id
	 * 父角色id
	 * @return
	 */
	public List<Role> findAllChildRole(String role_id);
	
	/**
	 * 得到角色的权限id集
	 * @param role_id
	 * 角色id
	 * @return
	 */
	public List<Integer> findPrivilegeIdByRid(String role_id);
	
	/**
	 * 通过权限id得到权限
	 * @param Privilege_id
	 * 权限id
	 * @return
	 */
	public Privilege findPrivilegeByPid(int privilege_id);
	/**
	 * 按条件查询角色信息
	 * @param role_name
	 * @return
	 * 角色列表
	 */
	public List<Role> findRoleByCondition(@Param("role_name")String role_name, @Param("user_id")String user_id);
}
