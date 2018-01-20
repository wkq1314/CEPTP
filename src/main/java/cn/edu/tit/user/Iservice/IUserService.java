package cn.edu.tit.user.Iservice;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;



import cn.edu.tit.user.bean.User;
import cn.edu.tit.user.bean.Student;


public interface IUserService {
	/**
	 * 用户登录
	 * @param username
	 * 用户名
	 * @param password
	 * 密码
	 * @return
	 */
	public User userSignIn(String username,String password);
	/**
	 * 用户注册
	 * @param user
	 * 用户信息
	 */
	public void userSignUP(User user);
	
//	/**
//	 * 导入教师信息
//	 * @param wb
//	 * @param fileName
//	 * @return
//	 * @throws Exception
//	 */
//	public List<Integer> importInfo(Workbook wb, String fileName) throws Exception;
	/**
	 * 导入用户信息
	 * @param wb
	 * @param sfileName
	 * @return
	 * @throws Exception
	 */
	public List<Integer> importInfoStudent(Workbook wb, String sfileName)throws Exception;
	/**
	 * 根据学生id查询用户
	 * @param stu_id
	 * @return
	 */
	public User findStuById(String user_id);
	/**
	 * 查询用户全部信息（不包含密码）
	 */
	public List<User> findAllUser();
	/**
	 * 导出用户全部信息（不包含密码）
	 * @return
	 */
	public File exportUser();

//	/**
//	 * 查询学生全部信息（不包含密码）
//	 */
//	public File exportStudent();
	
	/**
	 * 获取所有的教师id
	 * @return
	 */
	public List<String> findUserId();
	
	/**
	 * 根据条件查询用户
	 * @param staff_id
	 * @param staff_name
	 * @return
	 * 教师列表
	 */
	public List<User> findUserByCondition(String staff_id, String staff_name);
}
