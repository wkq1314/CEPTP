package cn.edu.tit.user.Idao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.tit.user.bean.Student;
import cn.edu.tit.user.bean.Teacher;

public interface IUserDao {
	/**
	 * 更具工号查询教师对象
	 * @param staff_id：工号
	 * @return：教师对象列表
	 */
	public List<Teacher> findTeaById(String staff_id);
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
	
}
