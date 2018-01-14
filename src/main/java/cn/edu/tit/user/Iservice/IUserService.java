package cn.edu.tit.user.Iservice;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import cn.edu.tit.user.bean.Student;
import cn.edu.tit.user.bean.Teacher;

public interface IUserService {
	/**
	 * 教师登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public Map<String, Object> teaSignIn(String userid,String password);
	
	/**
	 * 学生登录
	 * @param userid
	 * @param password
	 * @return
	 */
	public Map<String, Object> stuSignIn(String userid,String password);
	/**
	 * 导入教师信息
	 * @param wb
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List<Integer> importInfo(Workbook wb, String fileName) throws Exception;
	/**
	 * 导入学生信息
	 * @param wb
	 * @param sfileName
	 * @return
	 * @throws Exception
	 */
	public List<Integer> importInfoStudent(Workbook wb, String sfileName)throws Exception;
	/**
	 * 根据学生id查询学生
	 * @param stu_id
	 * @return
	 */
	public Student findStuById(String stu_id);
	/**
	 * 查询教师全部信息（不包含密码）
	 */
	public void findAllTea();
	/**
	 * 导出教师全部信息（不包含密码）
	 * @return
	 */
	public File exportTeacher();
	/**
	 * 查询学生全部信息（不包含密码）
	 */
	public void findAllStudent();
	/**
	 * 查询学生全部信息（不包含密码）
	 */
	public File exportStudent();
}
