package cn.edu.tit.user.Idao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import cn.edu.tit.user.bean.User;

public interface IUserDao {
	/**
	 * 通过user_id查询用户
	 * @param user_id
	 * @return
	 */
	public User findUserById(String user_id);

	/**
	 * 超级管理员添加用户
	 * @param teacher
	 * @param create_user
	 * @param create_time
	 * @param update_user
	 * @param update_time
	 */
	public void importInfo(@Param("user") User user, @Param("create_user") String create_user,
			@Param("create_time") Date create_time, @Param("update_user") String update_user,
			@Param("update_time") Date update_time);

	/**
	 * 获取所有User信息
	 * 
	 * @return
	 */
	public List<User> findAllUser();

	/**
	 * 查询所有用户Id
	 * @return
	 */
	public List<String> findUserId();

	/**
	 * 根据条件查询教师
	 * 
	 * @param staff_id
	 * @param staff_name
	 * @return 教师列表
	 */
	/*
	 * public List<Teacher> findUserByCondition(@Param("staff_id")String
	 * staff_id, @Param("role_id")String role_id);
	 */
}
