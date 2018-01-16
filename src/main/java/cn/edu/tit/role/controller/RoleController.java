package cn.edu.tit.role.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.tit.role.Iservice.IRoleService;
import cn.edu.tit.role.bean.Privilege;
import cn.edu.tit.role.bean.Role;
import cn.edu.tit.user.Iservice.IUserService;
import cn.edu.tit.user.bean.Teacher;
import cn.edu.tit.user.bean.Teacher;
import cn.edu.tit.util.RoleUtil;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserService userService;
	@Autowired
	private RoleUtil roleUtil;
	//private Logger log = Logger.getLogger(RoleController.class);
	
	/**
	 * 按条件查询角色信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/toSeaRole")
	public String toSeaRole(HttpServletRequest request){
		String role_id = request.getParameter("role_id");
		String role_name = request.getParameter("role_name");
		//List<Role> roleList = new ArrayList<Role>();
		List<Role> roleList = roleService.findRoleByCondition(role_id,role_name);		
		return null;
	}
	/**
	 * 跳转到角色-权限页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/toRolePage")
	public String toRolePage(HttpServletRequest request){
		//获得角色信息
		List<Role> roleList = new ArrayList<>();
		roleList = roleService.schAllChildRole("C");
		//获取访问页面
		String page = roleUtil.getPage("role");
		request.setAttribute("roleList", roleList);
		return page;
	}
	/**
	 * 跳转到修改角色页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/toUpdateRole")
	public String toUpdateRolePage(HttpServletRequest request){
		//获取要修改的角色名
		String role_id = request.getParameter("role_id");
		String parent_role_id = request.getParameter("parent_role_id");
		String role_name = request.getParameter("role_name");
		//获取要修改角色父角色的所有权限
		List<Privilege> pPrivilegeList = roleService.schPrivilegeByRId(parent_role_id);
		//获取要修改角色的所有权限
		List<Privilege> cPrivilegeList = roleService.schPrivilegeByRId(role_id);
		List<Integer> chPrivilegeIdList = new ArrayList<>();//被修改角色权限id列表
		for(Privilege p : cPrivilegeList){
			chPrivilegeIdList.add(p.getPrivilege_id());
		}
		//存入request中
		request.setAttribute("role_id", role_id);
		request.setAttribute("chPrivilegeList", chPrivilegeIdList);
		request.getSession().setAttribute("oldPrivilegeIdList", chPrivilegeIdList);//将被修改角色的原权限id列表放入session
		request.setAttribute("parent_role_id", parent_role_id);
		request.setAttribute("role_name", role_name);
		request.setAttribute("pPrivilegeList", pPrivilegeList);
		String page = roleUtil.getPage("addright");
		return page;
	}
	
	/**
	 * 修改角色
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/editRoleInfo" )
	public String editRoleInfo(HttpServletRequest request){
		//获得相关信息
		String role_id = request.getParameter("role_id"); //被修改角色id
		String role_name = request.getParameter("role_name"); //被修改角色名
		//String updateUser = (String) request.getSession().getAttribute(""); //修改人工号
		String updateUser = "152056138"; 
		List<Integer> oldPrivilegeIdList = new ArrayList<>();
		oldPrivilegeIdList = (List<Integer>) request.getSession().getAttribute("oldPrivilegeIdList"); //从session获取被修改角色原权限id列表
		//从页面获取更新后的权限列表
		String newPrivilegeStrs = request.getParameter("newPrivilegeList");
		List<Integer> newPrivilegeList = new ArrayList<>();
		if(!("".equals(newPrivilegeStrs))){
			String[] np = newPrivilegeStrs.split(",");
			for(String p : np){
				newPrivilegeList.add(Integer.parseInt(p));
			}
		}
		//调用业务逻辑
		roleService.editRole(role_id, role_name, updateUser, oldPrivilegeIdList, newPrivilegeList);
		
		return toRolePage(request);
	}
	/**
	 * 跳转到添加角色页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/toAddRole")
	public String toAddRole(HttpServletRequest request){
		//获取当前角色拥有的权限列表
		String role_id = (String) request.getSession().getAttribute("role_id");
		//String role_id = "C";
		List<Privilege> privilegeList = roleService.schPrivilegeByRId(role_id);
		//存入request中
		request.setAttribute("privilegeList", privilegeList);
		//访问添加页面
		String page = roleUtil.getPage("addrole");
		return page;
	}
	
	/**
	 * 添加角色
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addRole")
	public String addRole(HttpServletRequest request){
		//获取页面的添加角色信息
		String role_name = request.getParameter("role_name"); //角色名
		//从页面获取更新后的权限列表
		String newPrivilegeStrs = request.getParameter("newPrivilegeList");  //添加的权限列表
		List<Integer> newPrivilegeList = new ArrayList<>();
		String[] np = newPrivilegeStrs.split(",");
		for(String p : np){
			newPrivilegeList.add(Integer.parseInt(p));
		}
		//String parent_role_id = (String) request.getSession().getAttribute("role_id"); //父角色id
		String parent_role_id = "C";
		//String user_id = (String) request.getSession().getAttribute("user_id"); //创建人id
		String user_id ="152056138";
		//调用业务逻辑添加
		roleService.addRole(role_name, newPrivilegeList, parent_role_id, user_id);
		return toRolePage(request);
	}
	
	/**
	 * 跳转到绑定用户界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/tobindUserForRole")
	public String tobindUserForRole(HttpServletRequest request){
		//获取所需信息
		String role_id = request.getParameter("role_id"); //被修改角色id
		//获取所有教师id
		List<String> teacherIdList = userService.findTeacherId();
		//获得角色绑定的所有用户id
		Role role = roleService.schRoleInfo(role_id);
		List<String> teaOfRoleIds = new ArrayList<>();
		if(role!=null){
			for(Teacher t : role.getTeacherList()){
				teaOfRoleIds.add(t.getStaff_id());
			}
		}
		//获得用户未绑定的用户id
		teacherIdList.removeAll(teaOfRoleIds);
		//获得用户未绑定的用户
		List<Teacher> teacherList = new ArrayList<>();
		for(String tid : teacherIdList){
			teacherList.add(userService.findTeaById(tid));
		}
		//存入request
		request.setAttribute("role_id", role_id);
		request.setAttribute("teacherList", teacherList);
		//跳转到绑定页面
		String page = roleUtil.getPage("adduser");
		return page;
	}
	
	/**
	 * 为角色绑定用户
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bindUserForRole")
	public String bindUserForRole(HttpServletRequest request){
		//获取所需的信息
		String role_id = request.getParameter("role_id"); //被修改角色id
		//String user_id = (String) request.getSession().getAttribute("user_id"); //获取修改人id
		String user_id = "152056138";
		//获得绑定的用户列表
		String userIdStr = request.getParameter("userIdStrs");
		String[] userIdStrs = userIdStr.split(",");
		List<String> userIdList = new ArrayList<>();
		for(String userId : userIdStrs){
			userIdList.add(userId);
		}
		//调用业务逻辑绑定
		roleService.addUserForRole(role_id, user_id, userIdList);
		return toRolePage(request);
	}
}
