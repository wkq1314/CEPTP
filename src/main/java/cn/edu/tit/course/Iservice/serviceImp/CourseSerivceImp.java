package cn.edu.tit.course.Iservice.serviceImp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.tit.course.Idao.ICourseDao;
import cn.edu.tit.course.Iservice.ICourseService;
import cn.edu.tit.course.bean.Accessory;
import cn.edu.tit.course.bean.Course;
import cn.edu.tit.course.bean.Task;
import cn.edu.tit.util.StatusCode;
@Service
public class CourseSerivceImp implements ICourseService{

	@Autowired
	private ICourseDao courseDao;
	
	@Transactional
	@Override
	public void createCourse(Course course) {
		// 接收课程信息将课程信息存入数据库
		courseDao.addCourse(course);
	}
	@Transactional
	@Override
	public String joinCourse(String verify,String user_id,String course_id) {
		//通过课程id查询邀请码
		Course course = courseDao.getverify(course_id);
		String invitationCode = course.getInvitation_code();
		String create_user = course.getCreate_user();
		//校验邀请码
		if(invitationCode.equals(verify)){
			//正确将申请者加入
			courseDao.joinCourse(user_id, course_id, create_user);
			return StatusCode.SUCCESS_CREATE;
		}
		else{
			return StatusCode.EXECUTE_ERROR;
		}
	}
	@Transactional
	@Override
	public String addTask(Task task) {
		try {
			// 将为课程添加的任务加入数据库
			courseDao.addTask(task);
			//获取附件添加
			List<Accessory> accessoryList = new ArrayList<Accessory>();
			accessoryList = task.getPubAccs();
			if(accessoryList.size()!=0){
				for(Accessory acc : accessoryList){
					//附件信息存库
					courseDao.addAcc(acc);
				}
			}
			return StatusCode.SUCCESS_CREATE;
		} catch (Exception e) {
			e.getMessage();
			return StatusCode.EXECUTE_ERROR;
		}
	}

	@Transactional
	@Override
	public void uploadTask(Task task) {
		try {
			//通过id获取任务创建者id
			String create_user = courseDao.getTaskCreater(task.getTask_id());
			task.setCreate_user(create_user);
			//将提交的内容存库
			courseDao.uploadTask(task);
			List<Accessory> accessoryList = new ArrayList<Accessory>();
			accessoryList = task.getPubAccs();
			if(accessoryList.size()!=0){
				for(Accessory acc : accessoryList){
					//附件存库
					courseDao.addAcc(acc);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Transactional
	@Override
	public void evaluateTask(int grade,String task_id) {
		//将评分给相应的任务
		try {
			courseDao.evaluateTask(grade, task_id);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Transactional
	@Override
	public Course secCourseBycon(String kind, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Task secTaskBycon(String kind, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 附件存盘
	 * @param accessory
	 * 附件
	 */
	public void saveAccessory(File accessory){
		InputStream in = ClassLoader.getSystemResourceAsStream("page.properties");
		Properties properties = new Properties();
		BufferedOutputStream bw = null;
		try {
			properties.load(in);
			//获取存储路径
			String path = properties.getProperty("path")+accessory.getName();
			//创建文件输入流
			InputStream input = new FileInputStream(accessory);
			BufferedInputStream bin = new BufferedInputStream(input);
			byte[] b = new byte[10240];
			//创建文件输出流
			
			OutputStream out = new FileOutputStream(path);
			bw = new BufferedOutputStream(out);
			bin.read(b);
			bw.write(b);
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
