package cn.edu.tit.role.Iservice.serivceImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tit.role.Idao.IRoleDao;
import cn.edu.tit.role.Iservice.IRoleService;
import cn.edu.tit.role.bean.Privilege;
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
	public void addRole(String role_name,List<Integer> privilegeList,String parentRoleId,String create_user) {
		/*
		 * 根据父角色id获取当前角色id
		 * 获取对象信息
		 */
		int num = roleDao.findChildRoleNumById(parentRoleId);
		char name = roleUtil.getLetterByNum(num);
		String role_id = parentRoleId+name;   //获得id
		/*
		 * 调用持久层方法存储role
		 */
		roleDao.addRole(role_id, role_name,parentRoleId, create_user);
		for(int privilege_id : privilegeList){
			roleDao.addRolePrivilege(role_id, privilege_id, create_user);
		}
	}

	@Override
	public void editRole(String role_id,String role_name,String update_user,List<Integer>old_privilegeIdList,List<Integer>new_privilegeIdList) {
		if(old_privilegeIdList.size()!=0 || new_privilegeIdList.size()!=0){
			List<Integer> del_privilegeIdList = new ArrayList<>(); //要删除的权限集合
			for(int dp : old_privilegeIdList){
				del_privilegeIdList.add(dp);
			}
			List<Integer> upd_privilegeIdList = new ArrayList<>(); //要更新的权限集合
			for(int up : new_privilegeIdList){
				upd_privilegeIdList.add(up);
			}
			//通过差集得到要删除的权限集合
			del_privilegeIdList.removeAll(new_privilegeIdList);
			//通过差集得到要更新的权限集合
			upd_privilegeIdList.removeAll(old_privilegeIdList);
			//执行删除逻辑
			if(old_privilegeIdList.size()!=0){
				delRolePrivilege(role_id, del_privilegeIdList);
			}
			//执行添加逻辑
			if(new_privilegeIdList.size()!=0){
				addRolePrivilege(role_id, update_user, upd_privilegeIdList);
			}
		}
		roleDao.updateRoleName(role_id, role_name, update_user);
	}

	@Override
	public void addUserForRole(String role_id,String create_user, List<String> staff_idList) {
		//角色绑定选定用户
		for(String staffid : staff_idList ){
			roleDao.addUserForRole(role_id, staffid, create_user);
		}
	}

	@Override
	public void delUsersOfRole(String role_id, List<String> users) {
		//角色解绑选定用户
		for(String userid : users){
			roleDao.delUsersOfRole(role_id, userid);
		}
	}
	
	@Override
	public List<Role> schAllRole() {
		// 查询所有角色并返回
		List<Role> roleList = new ArrayList<>();
		roleList = roleDao.findAllRole();
		return roleList;
	}
	
	@Override
	public List<Role> schAllChildRole(String role_id) {
		//查询所有子角色并返回
		List<Role> roleList = new ArrayList<>();
		roleList = roleDao.findAllChildRole(role_id);
		return roleList;
	}

	@Override
	public List<Privilege> schPrivilegeByRId(String role_id) {
		//得到角色的权限id集
		List<Integer> privilegeIdList = new ArrayList<>();
		privilegeIdList = roleDao.findPrivilegeIdByRid(role_id);
		//通过权限id得到权限集
		List<Privilege> privilegeList = new ArrayList<>();
		for(int pid : privilegeIdList){
			privilegeList.add(roleDao.findPrivilegeByPid(pid));
		}
		return privilegeList;
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
