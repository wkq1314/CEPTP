package cn.edu.tit.user.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.tit.course.bean.Accessory;
import cn.edu.tit.course.bean.Task;
import cn.edu.tit.user.Iservice.IUserService;
import cn.edu.tit.user.bean.User;
import cn.edu.tit.util.RoleUtil;
import cn.itcast.commons.CommonUtils;
import cn.itcast.vcode.utils.VerifyCode;

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
		User user = new User();
		
		try {  
            DiskFileItemFactory factory = new DiskFileItemFactory();  
            ServletFileUpload upload = new ServletFileUpload(factory);  
            upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB  
            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件  
            Map<String, Object> formdata = new HashMap<String, Object>();
            byte[] by = new byte[5000000];
            for (FileItem fi:items) {
            	if(!fi.isFormField()){
            		by = fi.get();
            	}
            	else{
            		formdata.put(fi.getFieldName(), fi.getString("UTF-8"));
            	}
            }  
            user =  CommonUtils.toBean(formdata, User.class);
            user.setCreate_user(user.getUser_id());
    		user.setUpdate_user(user.getUser_id());
    		user.setFace(by);
    		//调用注册方法
    		userService.signUp(user);
        } catch (Exception e) {  
        	e.getMessage();
        	return null;
        }  
		
		String page = roleUtil.getPage("login");
		return page;
	}
	/**
	 * 验证码
	 */
	@RequestMapping(value="/verifyCode")
	public void verifyCode(HttpServletRequest request,HttpServletResponse response){
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();//获取一次性验证码图片
		// 该方法必须在getImage()方法之后来调用
//		System.out.println(vc.getText());//获取图片上的文本
		try {
			VerifyCode.output(image, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把图片写到指定流中
		
		// 把文本保存到session中，为LoginServlet验证做准备
		request.getSession().setAttribute("vCode", vc.getText());
	}
}
