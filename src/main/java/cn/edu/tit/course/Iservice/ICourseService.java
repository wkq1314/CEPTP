package cn.edu.tit.course.Iservice;

import cn.edu.tit.course.bean.Course;
import cn.edu.tit.course.bean.Task;

public interface ICourseService {
	/**
	 * 创建课程
	 * @param course
	 * 创建课程名称-、状态-、介绍、教材、封面图片-、所属学校-
	 * 分类（标签）-、适合专业
	 */
	public void createCourse(Course course);
	
	/**
	 * 加入课程
	 * @param user_id
	 * 用户id
	 * @param course_id
	 * 课程id
	 * @param verify
	 * 加入课程的验证： 邀请码
	 * @return
	 * 返回状态代码
	 */
	public String joinCourse(String verify,String user_id,String course_id);
	
	/**
	 * 为发布的课程添加任务
	 * @param task
	 * 任务名、任务描述、附件、评价类型、评价人、所属课程id、创建者
	 * @return
	 * 状态码
	 */
	public String addTask(Task task);
	
	/**
	 * 提交任务
	 * @param task
	 * 提交内容描述、附件、提交者id、成绩、任务id
	 */
	public void uploadTask(Task task);
	
	/**
	 * 评价任务
	 * @param grade
	 */
	public void evaluateTask(int grade,String task_id);
	
	/**
	 * 根据条件查找课程
	 * @param kind
	 * 查询的方式
	 * @param condition
	 * 查询的条件
	 * @return
	 */
	public Course secCourseBycon(String kind,String condition);
	
	/**
	 * 根据条件查找任务
	 * @param kind
	 * 查询的方式
	 * @param condition
	 * 查询的条件
	 * @return
	 */
	public Task secTaskBycon(String kind,String condition);
}
