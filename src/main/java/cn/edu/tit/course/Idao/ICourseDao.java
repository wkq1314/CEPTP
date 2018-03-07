package cn.edu.tit.course.Idao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import cn.edu.tit.course.bean.Accessory;
import cn.edu.tit.course.bean.Course;
import cn.edu.tit.course.bean.Task;

@Component
public interface ICourseDao {
	/**
	 * 添加课程
	 * @param course
	 * 创建课程名称、状态、介绍、教材、封面图片、所属学校 分类（标签）、适合专业
	 */
	public void addCourse(Course course);
	/**
	 * 获取某课程邀请码
	 * @param course_id
	 * 课程id
	 * @return
	 * 邀请码 & 创建者id
	 */
	public Course getverify(String course_id);
	
	/**
	 * 将申请者加入课程
	 * @param user_id
	 * 申请人id
	 * @param course_id
	 * 加入的课程
	 */
	public void joinCourse(@Param("user_id")String user_id,@Param("course_id")String course_id,@Param("create_user")String create_user);
	/**
	 * 为课程添加任务
	 * @param task
	 */
	public void addTask(Task task);
	
	/**
	 * 添加附件
	 * @param acc
	 */
	public void addAcc(Accessory acc);
	
	/**
	 * 通过id获取任务创建者id
	 * @param task_id
	 * 任务id
	 * @return
	 * 任务创建者id
	 */
	public String getTaskCreater(String task_id);
	
	/**
	 * 将提交的任务存到数据库
	 * @param task
	 */
	public void uploadTask(Task task);
	
	/**
	 * 给任务相应的评分
	 * @param grade
	 */
	public void evaluateTask(@Param("grade")int grade,@Param("task_id")String task_id);
	
	/*
	 * 课程查找
	 */
	
	/**
	 * 根据名字查找课程
	 * @param course_name
	 * 课程名
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByName(String course_name);
	
	/**
	 * 根据标签查找课程
	 * @param course_label
	 * 课程标签
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByLabel(String course_label);
	
	/**
	 * 根据适合专业查找课程
	 * @param application_pro
	 * 适合专业
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByAppro(String application_pro);
	
	/**
	 * 根据发布者查找课程
	 * @param creater
	 * 发布者
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByCreater(String creater);
	
	/**
	 * 根据学校查找课程
	 * @param college
	 * 学校
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByCollege(String college);
	
}
