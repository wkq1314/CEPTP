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
import cn.edu.tit.util.RoleUtil;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	@Autowired
	private RoleUtil roleUtil;
	//private Logger log = Logger.getLogger(RoleController.class);
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
		String[] np = newPrivilegeStrs.split(",");
		for(String p : np){
			newPrivilegeList.add(Integer.parseInt(p));
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
		//String role_id = (String) request.getSession().getAttribute("role_id");
		String role_id = "C";
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
}
