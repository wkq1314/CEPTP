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
import cn.edu.tit.user.bean.OutUser;
import cn.edu.tit.user.bean.User;
import cn.edu.tit.user.utils.ExcelUtils;
import cn.edu.tit.user.utils.RequestUtils;
import cn.edu.tit.user.utils.getByte;
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
	public Map<String, Object> userSignIn(String user_id, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> mapList = new HashMap<>();
		User user = userDao.findUserById(user_id);
		if (password.equals(user.getPassword())) {
			// 密码正确，判断是否是admin
			if ("admin".equals(user_id)) {
				try {
					String page = roleUtil.getPage("initialise");
					mapList.put("1", user);
					mapList.put("2", page);
					return mapList;
					/*
					 * String page = roleUtil.getPage("index"); mapList.put("1", user);
					 * mapList.put("2", page); return mapList;
					 */

				} catch (Exception e) {
					String page = roleUtil.getPage("login");
					mapList.put("1", user);
					mapList.put("2", page);
					return mapList;
				}
			} else {
				// 不是admin
				// 跳到index.jsp ---??
				String page = roleUtil.getPage("index");
				mapList.put("1", user);
				mapList.put("2", page);
				return mapList;
			}
		} else {
			// 密码不正确，跳转到登录页面
			String page = roleUtil.getPage("login");
			mapList.put("1", user);
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
		List<User> userList = new ArrayList<User>();
		// 循环Excel行数,从第二行开始。标题不入库
		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				continue;
			}
			// 获取cell(0)值，赋值给user_id，空报错，跳过此条数据，进行下一条数据
			String user_id = null;
			if (row.getCell(0) != null && !("".equals(row.getCell(0).toString()))) {
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				user_id = row.getCell(0).getStringCellValue();
			}
			// 获取cell(1)值，赋值给user_name，空报错，跳过此条数据，进行下一条数据
			String user_name = null;
			if (row.getCell(1) != null && !("".equals(row.getCell(1).toString()))) {
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				user_name = row.getCell(1).getStringCellValue();
			}

			// 获取cell(2)值，赋值给sex，空报错，跳过此条数据，进行下一条数据
			Boolean sex = true;// true 男 false 女
			// String s = row.getCell(3).toString();
			if ("".equals(row.getCell(2).toString())) {
				sex = null;
			}
			if ("女".equals(row.getCell(2).toString()) && row.getCell(2) != null
					&& !("".equals(row.getCell(2).toString()))) {
				sex = false;
			}
			// 获取cell(2)值，赋值给password，空报错，跳过此条数据，进行下一条数据
			String password = "123";
			if (row.getCell(3) != null && !("".equals(row.getCell(3).toString()))) {
				row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				password = row.getCell(3).getStringCellValue();
			}
			// 获取cell(4)值，赋值给class_name
			String class_name = row.getCell(4).getStringCellValue();
			// 获取cell(5)值，赋值给professional_title
			String professional_title = row.getCell(5).getStringCellValue();
			// 获取cell(6)值，赋值给degree，空报错，跳过此条数据，进行下一条数据
			String degree = row.getCell(6).getStringCellValue();
			// 获取cell(7)值，赋值给detail，空报错，跳过此条数据，进行下一条数据
			String detail = row.getCell(7).getStringCellValue();
			
			String path = "D:/3.jpg";
			File file = new File(path);
			byte[] face = getByte.getByte(file);		
			/*if ("".equals(row.getCell(8).toString())) {
				face = null;
			}
			if (row.getCell(8) != null && !("".equals(row.getCell(8).toString()))) {
				row.getCell(8).setCellType(Cell.CELL_TYPE_BLANK);
				// face = row.getCell(8).getArrayFormulaRange();

			}*/

			// 获取cell(9)值，赋值给pro
			String pro = null;
			if (row.getCell(8) != null && !("".equals(row.getCell(8).toString()))) {
				row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
				pro = row.getCell(8).getStringCellValue();
			}
			// 获取cell(10)值，赋值给qq
			String qq = row.getCell(9).getStringCellValue();
			// 获取cell(11)值，赋值给mobile
			String mobile = null;
			if (row.getCell(10) != null && !("".equals(row.getCell(10).toString()))) {
				row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
				mobile = row.getCell(10).getStringCellValue();
			}
			// 获取cell(12)的值，赋给college
			String college = null;
			if (row.getCell(11) != null && !("".equals(row.getCell(11).toString()))) {
				row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
				college = row.getCell(11).getStringCellValue();
			}
			// 获取cell(13)的值，赋给college
			String sec_college = row.getCell(12).getStringCellValue();

			// 创建user对象，对其赋值
			User user = new User(user_id, user_name, sex, password, class_name, professional_title, degree, detail,
					face, pro, qq, mobile, college, sec_college);

			// 将teacher对象存到teacherList中
			userList.add(user);
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
		for (int i = 0; i < userList.size(); i++) {
			try {
				userDao.importInfo(userList.get(i), create_user, new Date(), create_user, new Date());
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
	public File exportUser() {
		// TODO Auto-generated method stub
		List<User> userList = userDao.findAllUser();
		List<OutUser> userlist = new ArrayList<OutUser>();
		try {
			for (int i = 0; i < userList.size(); i++) {
				// 创建de对象，通过将从数据库中取得的值赋值给de，将de添加到teacherlist中，使其可以按固定格式输出
				OutUser de;
				User et = userList.get(i);
				de = new OutUser(et.getUser_id(), et.getUser_name(), et.getClass_name(), et.getProfessional_title(),
						et.getDegree(), et.getDetail(), et.getPro(), et.getQq(), et.getMobile(), et.getCollege(),
						et.getSec_college(), et.getCreate_user(), et.getCreate_time(), et.getUpdate_user(),
						et.getUpdate_time());
				boolean sex = userList.get(i).getSex();
				if (sex) {

					de.setSex("男");
				} else {
					de.setSex("女");
				}

				boolean delete_flg = userList.get(i).getDelete_flg();
				if (delete_flg) {
					de.setDelete_flg("是");
				} else {
					de.setDelete_flg("否");
				}
				userlist.add(de);
			}
			// 对excel的表头进行赋值
			File file = ExcelUtils.exportExcel(userlist,
					RequestUtils.getRequest().getSession().getServletContext().getRealPath(File.separator)
							+ UUID.randomUUID().toString() + ".xls",
					new String[] { "学号、工号", "姓名", "性别", "班级", "职称", "学位", "简介", "专业", "QQ号", "移动电话", "所在学院", "二级学院（系）",
							"是否删除", "创建者", "创建时间", "更新者", "更新时间" },
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
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

	@Override
	public List<String> findUserId() {

		return userDao.findUserId();
	}

	@Override
	public Boolean userSignUP(User user) {
		// TODO Auto-generated method stub
		User user1 = userDao.findUserById(user.getUser_id());
		if (user1 == null) {
			String create_user = user.getUser_id();
			String update_user = user.getUser_id();
			userDao.importInfo(user, create_user, new Date(), update_user, new Date());
			User user2 = userDao.findUserById(user.getUser_id());
			if (user2 != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public User findUserById(String user_id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(user_id);
	}
}
