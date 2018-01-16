package cn.edu.tit.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.tit.role.Iservice.IRoleService;
import cn.edu.tit.role.bean.Privilege;
import cn.edu.tit.role.bean.Role;
import cn.edu.tit.user.Iservice.IUserService;
import cn.edu.tit.user.bean.Student;
import cn.edu.tit.user.bean.Teacher;
import cn.edu.tit.util.RoleUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserService userService;
	@Autowired
	private RoleUtil roleUtil;
	// private Logger log = Logger.getLogger(RoleController.class);
	/*
	 * 根据条件查找教师
	 */
	@RequestMapping(value = "/toSeaUser")
	public String toSeaUser(HttpServletRequest request) {
		String staff_id = request.getParameter("staff_id");
		String staff_name = request.getParameter("staff_name");
		List<Teacher> teacherList = userService.findUserByCondition(staff_id,staff_name);
		return null;
	}
	/**
	 * 验证用户身份
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/checkIdentity")
	public String checkIdentity(HttpServletRequest request) {
		// 获取表单数据
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String usercategory = request.getParameter("usercategory");
		// 判断用户是学生还是教师
		Teacher teacher = null;
		Student student=null;
		if (usercategory != null && !("".equals(usercategory))) {
			if (Integer.parseInt(usercategory) == 1) {
				// 用户是教师，判断用户输入的id是否为空
				if (userid != null && !("".equals(userid))) {
					//用户id不为空
					//调用service层方法，进行教师登录
					try {
						Map<String, Object> teaMap = userService.teaSignIn(userid, password);
						System.out.println(teaMap);
						String page = (String) teaMap.get("2");
						teacher = (Teacher) teaMap.get("1");
						return page;
					} catch (Exception e) {
						e.printStackTrace();
						//登录失败，跳回登录界面，返回错误信息
						String page = roleUtil.getPage("login");
						return page;
					}				
				}else{
					//用户id为空，返回登录界面，输出错误信息"用户名或密码错误"
					String page = roleUtil.getPage("login");
					return page;
				}
			} else {
				// 用户是学生，判断id是否为空
				if (userid != null && !("".equals(userid))) {
					try {
						//调用service层方法，进行学生登录
						Map<String, Object> stuMap = userService.stuSignIn(userid, password);
						System.out.println(stuMap);
						String page = (String) stuMap.get("2");
						student = (Student) stuMap.get("1");
						return page;
					} catch (Exception e) {
						e.printStackTrace();
						//登录失败，跳回登录界面，返回错误信息
						String page = roleUtil.getPage("login");
						return page;
					}	
				}else{
					//用户id为空，返回登录界面，输出错误信息"用户名或密码错误"
					String page = roleUtil.getPage("login");
					return page;
				}
			}
		}else{
			//usercategory为空，跳回登录页面，返回错误信息
			String page = roleUtil.getPage("login");
			return page;
		}

	}

	/**
	 * 跳转到角色-权限页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/toRolePage")
	public String toRolePage(HttpServletRequest request) {
		// 获得角色信息
		List<Role> roleList = new ArrayList<>();
		roleList = roleService.schAllChildRole("C");
		// 获取访问页面
		String page = roleUtil.getPage("role");
		request.setAttribute("roleList", roleList);
		return page;
	}

}
