package cn.edu.tit.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.tit.user.Iservice.IUserService;
import cn.edu.tit.user.bean.User;
import cn.edu.tit.util.RoleUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
    @Autowired
	private RoleUtil roleUtil;
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
		// 创建session
		HttpSession session = request.getSession();
		String user_id = request.getParameter("userid");
		String password = request.getParameter("password");
		User user = null;
		if (user_id != null && !("".equals(user_id))) {
			try {
				Map<String, Object> userMap = userService.userSignIn(user_id, password);
				//System.out.println(userMap);
				String page = (String) userMap.get("2");
				user = (User) userMap.get("1");
				session.setAttribute("user", user);
				return page;
			} catch (Exception e) {
				e.printStackTrace();
				// 登录失败，跳回登录界面，返回错误信息
				String page = roleUtil.getPage("login");
				return page;
			}
		} else {
			// 用户id为空，返回登录界面，输出错误信息"用户名或密码错误"
			String page = roleUtil.getPage("login");
			return page;
		}

	}
	@RequestMapping(value = "/userSignUP")
	public String userSignUP(HttpServletRequest request) {
		User user=null;
		user.setUser_id(request.getParameter("userid"));
		user.setUser_name(request.getParameter("username"));
		user.setSex(true);
		user.setPassword(request.getParameter("password"));
		user.setMobile(request.getParameter("mobile"));
		user.setCollege(request.getParameter("college"));
		try {
			userService.userSignUP(user);
			Boolean b=userService.userSignUP(user);
			if(b==true) {
				String page = roleUtil.getPage("注册成功界面");
				return page;
			}
			else {
				String page = roleUtil.getPage("注册失败界面");
				return page;
			}
		} catch (Exception e) {
			// TODO: handle exception
			String page = roleUtil.getPage("注册失败界面");
			return page;
		}
	}
}
