package cn.edu.tit.user.Iservice;

import java.io.File;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import cn.edu.tit.user.bean.Teacher;

public interface IUserService {
	/**
	 * 鏁欏笀鐧诲綍鏂规硶
	 * @param username锛氱敤鎴峰悕
	 * @param password锛氬瘑鐮�
	 * @return锛氭暀甯�
	 */
	public Teacher teaSignIn(String username,String password);
	
	/**
	 * 瀛︾敓鐧诲綍鏂规硶
	 * @param username锛氱敤鎴峰悕
	 * @param password锛氬瘑鐮�
	 * @return锛氬鐢�
	 */
	public Teacher stuSignIn(String username,String password);
	/**
	 * 瀵煎叆鏁欏笀淇℃伅
	 * @return锛氬畬鎴愮姸鎬佷俊鎭�
	 */
	public List<Integer> importInfo(Workbook wb, String fileName) throws Exception;
	/**
	 * 瀵煎叆瀛︾敓淇℃伅
	 * @return:瀹屾垚鐘舵�佷俊鎭�
	 */
	public List<Integer> importInfoStudent(Workbook wb, String sfileName)throws Exception;
	/**
	 * 查询教师全部信息（无密码）
	 */
	public void findAllTea();
	/**
	 * 导出教师全部信息（无密码）
	 * @return
	 */
	public File exportTeacher();
	/**
	 * 查询学生全部信息（无密码）
	 */
	public void findAllStudent();
	/**
	 * 查询学生全部信息（无密码）
	 */
	public File exportStudent();
}
