package cn.edu.tit.user.Iservice.serviceImp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.transaction.Transactional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tit.user.Idao.IUserDao;
import cn.edu.tit.user.Iservice.IUserService;
import cn.edu.tit.user.bean.DownExcels;
import cn.edu.tit.user.bean.DownExcelt;
import cn.edu.tit.user.bean.Student;
import cn.edu.tit.user.bean.Teacher;
import cn.edu.tit.user.bean.Student;
import cn.edu.tit.user.bean.Teacher;
import cn.edu.tit.user.utils.ExcelUtils;
import cn.edu.tit.user.utils.RequestUtils;
import cn.edu.tit.util.RoleUtil;

@Service
@Transactional
public class UserServiceImp implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	@Autowired
	IUserDao userDao;
	@Autowired
	private RoleUtil roleUtil;
	@Override
	public Map<String, Object> teaSignIn(String userid, String password) {
		Map<String, Object> mapList = new HashMap<>();
		List<Teacher> teacherList = new ArrayList<>();
				teacherList.add(userDao.findTeaById(userid));
		Teacher teacher = null;
		if (teacherList != null && teacherList.size() > 0) {
			teacher = teacherList.get(0);
		}
		if (password.equals(teacher.getPassword())) {
			// 密码正确，判断是否是admin
			if ("admin".equals(userid)) {
				// 是admin，判断是否是第一次登录
				Boolean is_firstLogin = teacher.getIs_firstLogin();
				if (is_firstLogin) {
					// 是第一次登录，修改admin登录状态
					is_firstLogin = false;
					Boolean is_success = null;
					try {
						// 根据工号修改教师对象的is_firstLogin
						userDao.modifyIs_firstLogin(userid, is_firstLogin);
						is_success = true;
					} catch (Exception e) {
						e.printStackTrace();
						is_success = false;
					}
					if (is_success) {
						// 修改成功，跳转到导入页面
						String page = roleUtil.getPage("initialise");
						mapList.put("1", teacher);
						mapList.put("2", page);
						return mapList;
					} else {
						// 修改失败，跳转到登录界面
						String page = roleUtil.getPage("login");
						mapList.put("1", teacher);
						mapList.put("2", page);
						return mapList;
					}
				} else {
					// 不是第一次登录，跳转到主界面
					String page = roleUtil.getPage("index");
					mapList.put("1", teacher);
					mapList.put("2", page);
					return mapList;
				}
			} else {
				// 不是admin
				// 获得教师的角色和权限
				// 跳到index.jsp ---??
				String page = roleUtil.getPage("index");
				mapList.put("1", teacher);
				mapList.put("2", page);
				return mapList;
			}
		} else {
			// 密码不正确，跳转到登录页面
			String page = roleUtil.getPage("login");
			mapList.put("1", teacher);
			mapList.put("2", page);
			return mapList;
		}
		
	}

	@Override
	public Map<String, Object> stuSignIn(String userid, String password) {
		Map<String, Object> mapList = new HashMap<>();
		List<Student> studentList = userDao.findStuById(userid);
		Student student = null;
		if (studentList != null && studentList.size() > 0) {
			student = studentList.get(0);
		}
		if (password.equals(student.getPassword())) {
			// 用户名密码正确，跳转到首页
			String page = roleUtil.getPage("index");
			mapList.put("1", student);
			mapList.put("2", page);
			return mapList;
		} else {
			// 密码不正确，跳转到登录页面
			String page = roleUtil.getPage("login");
			mapList.put("1", student);
			mapList.put("2", page);
			return mapList;
		}
	}

	@Override
	public List<Integer> importInfo(Workbook wb, String fileName) throws Exception {
		// TODO Auto-generated method stub
		// 得到第一个sheet
		Sheet sheet = wb.getSheetAt(0);
		// 得到Excel的行数
		int totalRows = sheet.getPhysicalNumberOfRows();

		// 得到Excel的列数(前提是有行数)
		int totalCells = 0;
		if (totalRows >= 1 && sheet.getRow(0) != null) {
			totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}

		List<Teacher> teacherList = new ArrayList<Teacher>();

		// 循环Excel行数,从第二行开始。标题不入库
		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				continue;
			}
			// 获取cell(0)值，赋值给staff_id，空报错，跳过此条数据，进行下一条数据
			String staff_id = null;
			if (row.getCell(0) != null && !("".equals(row.getCell(0).toString()))) {
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				staff_id = row.getCell(0).getStringCellValue();
			}
			// 获取cell(1)值，赋值给staff_name，空报错，跳过此条数据，进行下一条数据
			String staff_name = null;

			if (row.getCell(1) != null && !("".equals(row.getCell(1).toString()))) {
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				staff_name = row.getCell(1).getStringCellValue();
			}
			// 获取cell(2)值，赋值给password，空报错，跳过此条数据，进行下一条数据
			String password = "123";
			if (row.getCell(2) != null && !("".equals(row.getCell(2).toString()))) {
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				password = row.getCell(2).getStringCellValue();
			}
			// 获取cell(3)值，赋值给sex，空报错，跳过此条数据，进行下一条数据
			Boolean sex = true;// true 男 false 女
			// String s = row.getCell(3).toString();
			if ("".equals(row.getCell(3).toString())) {
				sex = null;
			}
			if ("女".equals(row.getCell(3).toString()) && row.getCell(3) != null
					&& !("".equals(row.getCell(3).toString()))) {
				sex = false;
			}
			// 获取cell(4)值，赋值给degree_id
			Integer degree_id = row.getCell(4).getCellType();
			// 获取cell(5)值，赋值给pro_title_id
			Integer pro_title_id = row.getCell(5).getCellType();
			// 获取cell(6)值，赋值给college_id，空报错，跳过此条数据，进行下一条数据
			Integer college_id = 0;
			if ("".equals(row.getCell(6).toString())) {
				college_id = null;
			}
			if (row.getCell(6) != null && !("".equals(row.getCell(6).toString()))) {
				row.getCell(6).setCellType(Cell.CELL_TYPE_BLANK);

				college_id = row.getCell(6).getCellType();
			}
			// 获取cell(7)值，赋值给dept_id，空报错，跳过此条数据，进行下一条数据
			Integer dept_id = 0;
			if ("".equals(row.getCell(7).toString())) {
				dept_id = null;
			}
			if (row.getCell(7) != null && !("".equals(row.getCell(7).toString()))) {
				row.getCell(7).setCellType(Cell.CELL_TYPE_BLANK);

				dept_id = row.getCell(7).getCellType();
			}
			// 获取cell(8)值，赋值给pro_id，空报错，跳过此条数据，进行下一条数据
			Integer pro_id = 0;
			if ("".equals(row.getCell(8).toString())) {
				pro_id = null;
			}
			if (row.getCell(8) != null && !("".equals(row.getCell(8).toString()))) {
				row.getCell(8).setCellType(Cell.CELL_TYPE_BLANK);
				pro_id = row.getCell(8).getCellType();
			}
			// 获取cell(9)值，赋值给email
			String email = null;
			if (row.getCell(9) != null) {
				row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
				email = row.getCell(9).getStringCellValue();
			}
			// 获取cell(10)值，赋值给is_dimission，空报错，跳过此条数据，进行下一条数据
			Boolean is_dimission = true;// true 是 false 否
			if ("".equals(row.getCell(10).toString())) {
				is_dimission = null;
			}
			if ("否".equals(row.getCell(10).toString()) && row.getCell(10) != null
					&& !("".equals(row.getCell(3).toString()))) {
				is_dimission = false;
			}
			// 获取cell(11)值，赋值给phone
			String phone = null;
			if (row.getCell(11) != null) {
				row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);

				phone = row.getCell(11).getStringCellValue();
			}
			// 获取cell(12)值，赋值给mobile
			String mobile = null;
			if (row.getCell(12) != null) {
				row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
				mobile = row.getCell(12).getStringCellValue();
			}
			// 创建teacher对象，对其赋值
			Teacher teacher = new Teacher(staff_id, staff_name, password, sex, degree_id, pro_title_id, college_id,
					dept_id, pro_id, email, is_dimission, phone, mobile);
			// 将teacher对象存到teacherList中
			teacherList.add(teacher);
		}
		// 创建者ID即admin。后期可根据前端传入数据进行修改
		String create_user = "admin";
		// 导入正确个数
		int flagT = 0;
		// 导入错误个数
		int flagF = 0;
		// 创建list集合，用来存储flagT和flagF
		List<Integer> list = new ArrayList<Integer>();
		// 对teacherList进行循环，将其传入Dao层
		for (int i = 0; i < teacherList.size(); i++) {
			try {
				userDao.importInfo(teacherList.get(i), create_user, new Date(), create_user, new Date());
				// 正确个数++
				flagT++;
			}
			// 捕获异常，对失败个数进行++
			catch (Exception e) {
				e.printStackTrace();
				// 失败列
				Integer false_i = i + 2;
				list.add(false_i);
				flagF++;

			}
		}
		list.add(flagT);// 添加入list中
		list.add(flagF);// 添加入list中
		return list;
	}

	@Override
	public List<Integer> importInfoStudent(Workbook wb, String sfileName) throws Exception {
		// TODO Auto-generated method stub
		// 得到第一个sheet
		Sheet sheet = wb.getSheetAt(0);
		// 得到Excel的行数
		int totalRows = sheet.getPhysicalNumberOfRows();

		// 得到Excel的列数(前提是有行数)
		int totalCells = 0;
		if (totalRows >= 1 && sheet.getRow(0) != null) {
			totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}

		List<Student> studentList = new ArrayList<Student>();

		// 循环Excel行数,从第二行开始。标题不入库
		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				continue;
			}
			// 获取cell(0)值，赋值给staff_id，空报错，跳过此条数据，进行下一条数据
			String stu_id = null;
			if (row.getCell(0) != null && !("".equals(row.getCell(0).toString()))) {
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				stu_id = row.getCell(0).getStringCellValue();
			}
			// 获取cell(1)值，赋值给staff_name，空报错，跳过此条数据，进行下一条数据
			String stu_name = null;
			if (row.getCell(1) != null && !("".equals(row.getCell(1).toString()))) {
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				stu_name = row.getCell(1).getStringCellValue();
			}
			// 获取cell(2)值，赋值给sex，空报错，跳过此条数据，进行下一条数据
			Boolean sex = true;// true 男 false 女
			// String s = row.getCell(2).toString();
			if ("".equals(row.getCell(2).toString())) {
				sex = null;
			}
			if ("女".equals(row.getCell(2).toString()) && row.getCell(2) != null
					&& !("".equals(row.getCell(2).toString()))) {
				sex = false;
			}
			// 获取cell(3)值，赋值给password，空报错，跳过此条数据，进行下一条数据
			String password = "123";
			if (row.getCell(3) != null && !("".equals(row.getCell(3).toString()))) {
				row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				password = row.getCell(3).getStringCellValue();
			}
			// 获取cell(4)值，赋值给class_id，空报错，跳过此条数据，进行下一条数据
			String class_id = null;
			if (row.getCell(4) != null && !("".equals(row.getCell(4).toString()))) {
				row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				class_id = row.getCell(4).getStringCellValue();
			}
			// 获取cell(5)值，赋值给pro_id，空报错，跳过此条数据，进行下一条数据
			Integer pro_id = 0;
			if ("".equals(row.getCell(5).toString())) {
				pro_id = null;
			}
			if (row.getCell(5) != null && !("".equals(row.getCell(5).toString()))) {
				row.getCell(5).setCellType(Cell.CELL_TYPE_BLANK);

				pro_id = row.getCell(5).getCellType();
			}
			// 获取cell(6)值，赋值给qq
			String qq = null;
			if (row.getCell(6) != null) {
				row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
				qq = row.getCell(6).getStringCellValue();
			}
			// 获取cell(7)值，赋值给mobile
			String mobile = null;
			if (row.getCell(7) != null) {
				row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
				mobile = row.getCell(7).getStringCellValue();
			}
			// role_id为固定权限，根据后期要求做修改
			String role_id = "0";
			// 获取cell(8)值，赋值给role_id，空报错，跳过此条数据，进行下一条数据
			Integer college_id = 0;
			if ("".equals(row.getCell(8).toString())) {
				college_id = null;
			}
			if (row.getCell(8) != null && !("".equals(row.getCell(8).toString()))) {
				row.getCell(8).setCellType(Cell.CELL_TYPE_BLANK);

				college_id = row.getCell(8).getCellType();
			}
			// 获取cell(9)值，赋值给dept_id，空报错，跳过此条数据，进行下一条数据
			Integer dept_id = 0;
			if ("".equals(row.getCell(9).toString())) {
				dept_id = null;
			}
			if (row.getCell(9) != null && !("".equals(row.getCell(9).toString()))) {
				row.getCell(9).setCellType(Cell.CELL_TYPE_BLANK);

				dept_id = row.getCell(9).getCellType();
			}
			Student student = new Student(stu_id, stu_name, sex, password, class_id, pro_id, qq, mobile, role_id,
					college_id, dept_id);
			studentList.add(student);
		}
		// 创建者ID即admin。后期可根据前端传入数据进行修改
		String create_user = "admin";
		// 导入正确个数
		int flagT = 0;
		// 导入错误个数
		int flagF = 0;
		// 创建list集合，用来存储flagT和flagF
		List<Integer> list = new ArrayList<Integer>();
		// 对teacherList进行循环，将其传入Dao层
		for (int i = 0; i < studentList.size(); i++) {
			try {
				userDao.importInfoStudent(studentList.get(i), create_user, new Date(), create_user, new Date());
				// 正确个数++
				flagT++;
			}
			// 捕获异常，对失败个数进行++
			catch (Exception e) {
				e.printStackTrace();
				// 失败列
				Integer false_i = i + 2;
				list.add(false_i);
				flagF++;
			}
		}
		list.add(flagT);// 添加入list中
		list.add(flagF);// 添加入list中
		return list;
	}

	@Override
	public List<Teacher> findAllTea() {
		return userDao.findAllTea();

	}

	@Override
	public File exportTeacher() {
		// TODO Auto-generated method stub
		List<Teacher> teacherList = userDao.findAllTea();
		List<DownExcelt> teacherlist = new ArrayList<DownExcelt>();
		try {
			for (int i = 0; i < teacherList.size(); i++) {
				// 创建de对象，通过将从数据库中取得的值赋值给de，将de添加到teacherlist中，使其可以按固定格式输出
				DownExcelt de;
				Teacher et = teacherList.get(i);
				de = new DownExcelt(et.getStaff_id(), et.getStaff_name(), et.getDegree_id(), et.getPro_id(),
						et.getCollege_id(), et.getDept_id(), et.getPro_id(), et.getEmail(), et.getPhone(),
						et.getMobile(), et.getCreate_user(), et.getCreate_time(), et.getUpdate_user(),
						et.getUpdate_time());
				boolean sex = teacherList.get(i).getSex();
				if (sex) {
					de.setSex("男");
				} else {
					de.setSex("女");
				}
				boolean is_dimission = teacherList.get(i).getIs_dimission();
				if (is_dimission) {
					de.setIs_dimission("是");
				} else {
					de.setIs_dimission("否");
				}
				boolean is_firstLogin = teacherList.get(i).getIs_firstLogin();
				if (is_firstLogin) {
					de.setIs_firstLogin("是");
				} else {
					de.setIs_firstLogin("否");
				}
				boolean delete_flg = teacherList.get(i).getDelete_flg();
				if (delete_flg) {
					de.setDelete_flg("是");
				} else {
					de.setDelete_flg("否");
				}
				teacherlist.add(de);
			}
			// 对excel的表头进行赋值
			File file = ExcelUtils.exportExcel(teacherlist,
					RequestUtils.getRequest().getSession().getServletContext().getRealPath(File.separator)
							+ UUID.randomUUID().toString() + ".xls",
					new String[] { "教师工号", "教师名", "性别", "学位id", "职称id", "所在学院", "所在系部", "所在专业", "邮箱", "是否在岗", "固定电话",
							"移动电话", "是否第一次登陆", "是否删除", "创建者", "创建时间", "更新者", "更新时间" },
					"updateTime");
			return file;
		} catch (IOException e) {
			logger.error(e.getMessage(), e.toString());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e.toString());
		}
		return null;
	}

	@Override
	public void findAllStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public File exportStudent() {
		// TODO Auto-generated method stub
		List<Student> studentList = userDao.findAllStudent();
		List<DownExcels> studentlist = new ArrayList<DownExcels>();
		try {
			for (int i = 0; i < studentList.size(); i++) {
				//建立ds对象，通过对ds对象进行赋值，使其具有数据库中student所具有的值，将ds存进studentlist中，用来对excel表格进行赋值
				DownExcels ds;
				Student es = studentList.get(i);
				ds = new DownExcels(es.getStu_id(), es.getStu_name(), es.getClass_id(), es.getPro_id(), es.getqq(),
						es.getMobile(), es.getRole_id(), es.getCollege_id(), es.getDept_id(), es.getCreate_user(),
						es.getCreate_time(), es.getUpdate_user(), es.getUpdate_time());
				boolean sex = studentList.get(i).getSex();
				if (sex) {
					ds.setSex("男");
				} else {
					ds.setSex("女");
				}
				boolean delete_flg = studentList.get(i).getDelete_flg();
				if (delete_flg) {
					ds.setDelete_flg("是");
				} else {
					ds.setDelete_flg("否");
				}
				studentlist.add(ds);
			}
			// 对excel的表头进行赋值
			File file = ExcelUtils.exportExcel(studentlist,
					RequestUtils.getRequest().getSession().getServletContext().getRealPath(File.separator)
							+ UUID.randomUUID().toString() + ".xls",
					new String[] { "学生学号", "姓名", "性别", "班级", "专业", "QQ号", "移动电话", "角色ID", "所以学院ID", "所在系部ID", "是否删除",
							 "创建者", "创建时间", "更新者", "更新时间" },
					"updateTime");
			return file;
		} catch (IOException e) {
			logger.error(e.getMessage(), e.toString());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e.toString());
		}
		return null;
	}

	@Override

	public List<String> findTeacherId() {
		
		return userDao.findTeacherId();
	}

	@Override
	public Teacher findTeaById(String staff_id) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return userDao.findTeaById(staff_id);
=======
		userDao.findTeaById(staff_id);
		return null;
>>>>>>> ac0c6ab1d51d441854b954251689601f4ee02647
	}
	public Student findStuById(String stu_id) {
		List<Student> studentList = userDao.findStuById(stu_id);
		Student student = null;
		if (studentList != null && studentList.size() > 0) {
			student = studentList.get(0);
			return student;
		}
		return student;
<<<<<<< HEAD

	}
=======
>>>>>>> ac0c6ab1d51d441854b954251689601f4ee02647

	}
	@Override
	public List<Teacher> findUserByCondition(String staff_id, String staff_name) {
		List<Teacher> teacherList = userDao.findUserByCondition(staff_id,staff_name);
		return teacherList;
	}
}
