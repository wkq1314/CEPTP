package cn.edu.tit.user.Idao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.tit.user.bean.Student;
import cn.edu.tit.user.bean.Teacher;
import cn.edu.tit.user.bean.Student;
import cn.edu.tit.user.bean.Teacher;

public interface IUserDao {
	/**
	 * 根据工号修改教师对象的is_firstLogin
	 * @param staff_id
	 * @param is_firstLogin
	 */
	public void modifyIs_firstLogin(@Param("staff_id")String staff_id,@Param("is_firstLogin")Boolean is_firstLogin);
	/**
	 * 根据工号查询教师对象
	 * @param staff_id：工号
	 * @return：教师对象列表
	 */
	public Teacher findTeaById(String staff_id);
	/**
	 * 根据工号查询学生对象
	 * @param stu_id
	 * @return
	 */
	public List<Student> findStuById(String stu_id);
	/**
	 * 超级管理员向教师表单中添加教师
	 * @param teacher
	 * @param create_user
	 * @param create_time
	 * @param update_user
	 * @param update_time
	 */
	public void importInfo(@Param("teacher")Teacher teacher,@Param("create_user")String create_user,@Param("create_time")Date create_time,
			@Param("update_user")String update_user,@Param("update_time")Date update_time);
	
	
	
	public void importInfoStudent(@Param("student")Student student,@Param("create_user")String create_user,@Param("create_time")Date create_time,
			@Param("update_user")String update_user,@Param("update_time")Date update_time);
	/**
	 * 获取所有教师信息
	 * @return
	 */
	public List<Teacher> findAllTea();

	public List<String> findTeacherId();
	
	/**
	 * 获取所有学生信息
	 * @return
	 */
	public List<Student> findAllStudent();
	
	/**
	 * 根据条件查询教师
	 * @param staff_id
	 * @param staff_name
	 * @return
	 * 教师列表
	 */
	public List<Teacher> findUserByCondition(@Param("staff_id")String staff_id, @Param("role_id")String role_id);
	/**
	 * 按user_id查询role_id
	 * @param user_id
	 * @return
	 */
	public String findrole_id(String user_id);

}
