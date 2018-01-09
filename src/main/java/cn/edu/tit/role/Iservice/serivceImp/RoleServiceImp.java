package cn.edu.tit.role.Iservice.serivceImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tit.role.Idao.IRoleDao;
import cn.edu.tit.role.Iservice.IRoleService;
import cn.edu.tit.role.bean.Role;
import cn.edu.tit.util.RoleUtil;

/**
 * 角色类业务逻辑实现
 * @author huang
 *
 */
@Service
public class RoleServiceImp implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	RoleUtil roleUtil;

	@Override
	public Role schRoleInfo(String role_id) {
		//通过角色id获得相关用户信息并封装为role对象
		Role role = roleDao.findRoleById(role_id);
		return role;
	}

	@Override
	public void addRole(Role role) {
		/*
		 * 根据父角色id获取当前角色id
		 * 获取对象信息
		 */
		String create_user = role.getCreate_user();
		String parentRoleId = role.getParent_role_id();
		int num = roleDao.findChildRoleNumById(parentRoleId);
		char name = roleUtil.getLetterByNum(num);
		String role_id = parentRoleId+name;   //获得id
		String role_name = role.getRole_name();  //获得角色名
		role.setRole_id(role_id);  //封装为完整的Role对象
		/*
		 * 调用持久层方法存储role
		 */
		roleDao.addRole(role_id, role_name,parentRoleId, create_user);
		List<Integer> privilegeList = role.getPrivilegeIdList();   //获取role-privilege 并存储
		for(int privilege_id : privilegeList){
			roleDao.addRolePrivilege(role_id, privilege_id, create_user);
		}
	}

	@Override
	public void editRole(String role_id,String role_name,String create_user,List<Integer>old_privilegeIdList,List<Integer>new_privilegeIdList) {
		//得到权限的删除集合
		old_privilegeIdList.removeAll(new_privilegeIdList);
		//得到权限的添加集合
		new_privilegeIdList.removeAll(old_privilegeIdList);
		//执行删除逻辑
		delRolePrivilege(role_id, old_privilegeIdList);
		//执行添加逻辑
		addRolePrivilege(role_id, create_user, new_privilegeIdList);
	}

	@Override
	public void addUserForRole(String role_id,String create_user, List<String> staff_idList) {
		//子角色绑定选定用户
		for(String staffid : staff_idList ){
			roleDao.addUserForRole(role_id, staffid, create_user);
		}
	}

	@Override
	public List<Role> schAllRole() {
		// 查询所有角色并返回
		return null;
	}
	
	@Override
	public List<Role> schAllChildRole(String role_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> schPrivilegeById(String role_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 添加角色权限
	 * @param role_id
	 * 被修改角色id
	 * @param create_user
	 * 被修改角色的父角色id
	 * @param privilegeIdList
	 * 增加的权限列表
	 */
	private void addRolePrivilege(String role_id,String create_user,List<Integer> privilegeIdList) {
		//为选中的子角色增加权限
		for(int privilegeId : privilegeIdList){
			roleDao.addRolePrivilege(role_id, privilegeId, create_user);
		}
		
	}

	/**
	 * 删除角色权限
	 * @param role_id
	 * 被修改角色id
	 */
	private void delRolePrivilege(String role_id, List<Integer> privilegeIdList) {
		// 获得被修改角色id及其所有子角色id
		List<String> roleIdList = roleDao.getAllChildRoleId(role_id);
		// 删除获得的所有角色id的相关权限
		for(String roleid : roleIdList){
			for(int privilege_id : privilegeIdList){
				roleDao.delRolePrivilegeById(roleid, privilege_id);
			}
		}
	}
	

}
