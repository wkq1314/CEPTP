package cn.edu.tit.user.Idao;

import java.util.List;

import cn.edu.tit.user.bean.Teacher;

public interface IUserDao {
	/**
	 * 更具工号查询教师对象
	 * @param staff_id：工号
	 * @return：教师对象列表
	 */
	public List<Teacher> findTeaById(String staff_id);
}
