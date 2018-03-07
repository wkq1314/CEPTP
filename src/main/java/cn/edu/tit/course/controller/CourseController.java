package cn.edu.tit.course.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.tit.course.Iservice.ICourseService;
import cn.edu.tit.course.bean.Accessory;
import cn.edu.tit.course.bean.Course;
import cn.edu.tit.course.bean.Task;
import cn.edu.tit.util.FileUtil;
import cn.itcast.commons.CommonUtils;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	@Autowired
	private FileUtil fileUtil;
	
	/**
	 * 添加课程
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addCourse")
	public String addCourse(HttpServletRequest request){
		//获取课程相关信息
		//String create_user = (String) request.getSession().getAttribute("user_id");
		String create_user = "1520561";
		String course_id = create_user+"_"+System.currentTimeMillis(); //课程id
		String college = request.getParameter("school");//学校
		String course_name = request.getParameter("course_name"); //课程名
		//String course_name = "comp";
		String course_lable = request.getParameter("course_lable"); //类型
		int course_flag = 1; //状态
		String course_notes = request.getParameter("course_notes"); //简介
		String application_pro = request.getParameter("application_pro"); //适合专业
		//测试数据
//		String course_notes = "xx"; 
//		String application_pro = "yy";
		String invitation_code = UUID.randomUUID().toString().replace("-", "").toUpperCase(); //邀请码
		byte[] course_img = request.getParameter("course_img").getBytes(); //图片
		//封装课程对象
		Course course = new Course(course_id, course_name, course_lable, course_img, course_notes, college, application_pro, course_flag, invitation_code, create_user);
		//存储课程信息
		courseService.createCourse(course);
		return null;
	}
	/**
	 * 加入课程
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/joinCourse")
	public String joinCourse(HttpServletRequest request){
		//获取加入的课程号
		String course_id = request.getParameter("course_id");
		//获取加入者id和邀请码
		String user_id = (String) request.getSession().getAttribute("user_id");
		String invitation_code = request.getParameter("invitation_code");
		//调用业务逻辑
		courseService.joinCourse(invitation_code, "1520561", "1520561_1517561047582");
		return null;
	}
	
	/**
	 * 发布任务
	 * @param request
	 */
	@RequestMapping(value="/publishTesk")
	public void publishTesk(HttpServletRequest request,HttpServletResponse response){
//		//接收参数
//		String task_name = request.getParameter("task_name");
////		String course_id = request.getParameter("course_id");
		String task_id = "1520561_1517561047582"+System.currentTimeMillis();
//		String task_details = request.getParameter("task_details");
////		String evaluate_kind = request.getParameter("evaluate_kind");
////		String evaluate_id = request.getParameter("evaluate_id");
////		String create_user = (String) request.getSession().getAttribute("username");
		String username = "1520561";
//		//封装对象
//		Task task = new Task(task_id, task_name, "1520561_1517561047582", task_details, "jiaohsi", "1520561", "1520561");
//		//获取附件对象集合，并存盘
//		List<Accessory> accList = new ArrayList<>();
//		accList = fileUtil.uploadAccessory(request, "1520561");
//		task.setPubAccs(accList);
		
		try {  
			//获取存储路径
//			InputStream in = ClassLoader.getSystemResourceAsStream("page.properties");
//			Properties properties = new Properties();
//			properties.load(in);
//			String path = properties.getProperty("path");
			String path = "D:\\accessory\\";
            DiskFileItemFactory factory = new DiskFileItemFactory();  
            ServletFileUpload upload = new ServletFileUpload(factory);  
            upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB  
            List<Accessory> accList = new ArrayList<>();
            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件  
            Map<String, Object> formdata = new HashMap<String, Object>();
            for (FileItem fi:items) {
            	Accessory acc = new Accessory();
            	if(!fi.isFormField()){
            		 String fileName = fi.getName();  
                     if (fileName != null) {  
                         File fullFile = new File(new String(fi.getName().getBytes(), "utf-8")); // 解决文件名乱码问题  
                         File savedFile = new File(path, username+"_"+fullFile.getName());  
                         fi.write(savedFile);  
                         acc.setAccessory_name(username+"_"+fullFile.getName());
                         acc.setAccessory_kind(1);
                         acc.setAccessory_path(path);
                         accList.add(acc);
                     }  
            	}
            	else{
            		formdata.put(fi.getFieldName(), fi.getString("UTF-8"));
            	}
            }  
            Task task =  CommonUtils.toBean(formdata, Task.class);
            task.setTask_id(task_id);
            task.setCourse_id("1520561_1517561047582");
            task.setPubAccs(accList);
//            task.setEvaluate_kind("jiaoshi");
//            task.setEvaluate_id("1520561");
//            task.setCreate_user("1520561");
          //调用service方法
    		courseService.addTask(task);
        } catch (Exception e) {  
        	e.getMessage();
        }  
		
		
	}
	@RequestMapping(value="/uploadImage")
	public Object uploadImage(@Param("upfile") MultipartFile img){
			Map<String, Object> param = new HashMap<>();
			MediaFile
	}
	
	
}
