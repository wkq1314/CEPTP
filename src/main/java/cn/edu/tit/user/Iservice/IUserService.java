package cn.edu.tit.user.Iservice;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import cn.edu.tit.user.bean.Teacher;

public interface IUserService {
	/**
	 * 教师登录方法
	 * @param username：用户名
	 * @param password：密码
	 * @return：教师
	 */
	public Teacher teaSignIn(String username,String password);
	
	/**
	 * 学生登录方法
	 * @param username：用户名
	 * @param password：密码
	 * @return：学生
	 */
	public Teacher stuSignIn(String username,String password);
	/**
	 * 导入教师信息
	 * @return：完成状态信息
	 */
	public List<Integer> importInfo(Workbook wb, String fileName) throws Exception;
	/**
	 * 导入学生信息
	 * @return:完成状态信息
	 */
	public List<Integer> importInfoStudent(Workbook wb, String sfileName)throws Exception;
}
