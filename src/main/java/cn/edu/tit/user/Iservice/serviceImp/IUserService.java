package cn.edu.tit.user.Iservice.serviceImp;

import cn.edu.tit.user.bean.User;

public interface IUserService {

	/**
	 * 用户登录方法
	 * @param username：用户名
	 * @param password：密码
	 * @return：用户对象（教师或学生）
	 */
	public User signIn(String username,String password);
	/**
	 * 导入用户信息
	 * @return：完成状态信息
	 */
	public String importInfo();
}
