package cn.edu.tit.user.Iservice.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tit.user.Idao.IUserDao;
import cn.edu.tit.user.Iservice.IUserService;
import cn.edu.tit.user.bean.Student;
import cn.edu.tit.user.bean.Teacher;

@Service
@Transactional
public class UserServiceImp implements IUserService {

	@Autowired
	IUserDao userDao;

	@Override
	public Teacher teaSignIn(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher stuSignIn(String username, String password) {
		// TODO Auto-generated method stub
		return null;
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

}
