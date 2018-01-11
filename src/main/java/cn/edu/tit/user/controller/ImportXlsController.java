package cn.edu.tit.user.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import cn.edu.tit.user.Iservice.IUserService;
import cn.edu.tit.user.utils.ReadExcel;
@Controller
@RequestMapping("/input")
@Scope("prototype")
public class ImportXlsController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/ImportXls", method = RequestMethod.POST)
	public ModelAndView ImporXls(@RequestParam(value = "filename") MultipartFile file,
			@RequestParam(value = "sfilename") MultipartFile sfile, HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException, IOException, ServletException {

		// 判断文件是否为空
		/*
		 * if (tfile == null) {System.out.println("文件为空");}
		 */

		// 获取文件名
		String fileName = file.getOriginalFilename();// 教师文件名
		String sfileName = sfile.getOriginalFilename();// 学生文件名
		// 进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
		long size = file.getSize();// 教师文件名长度
		long ssize = sfile.getSize();// 学生文件名长度
		/*
		 * if (fileName == null || ("").equals(fileName) && size == 0) {}
		 * System.out.println("文件名为空");
		 */

		if (fileName == null || ("").equals(fileName) && size == 0) {
			if (sfileName == null || ("").equals(sfileName) && ssize == 0) {
				System.out.println("文件名为空");
			} else {
				infoStudent(sfileName, sfile);
			}
		} else {
			if (sfileName == null || ("").equals(sfileName) && ssize == 0) {
				infoSteacher(fileName, file);
			} else {
				infoSteacher(fileName, file);
				infoStudent(sfileName, sfile);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("show");
		return mav;
	}

	public void infoSteacher(String fileName, MultipartFile file) {
		String errorInfo = null;
		// 批量导入。参数：文件,文件名。

		List<Integer> list = null;
		try {
			// 创建处理EXCEL
			ReadExcel readExcel = new ReadExcel();
			// 解析excel，获取信息集合。
			Workbook wb = readExcel.getWorkbook(fileName, file);
			errorInfo = readExcel.getErrorInfo();

			try {
				list = userService.importInfo(wb, fileName);
				for (Integer integer : list) {
					System.out.println(integer);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("导入失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(errorInfo);
	}

	public void infoStudent(String sfileName, MultipartFile sfile) {
		String errorInfo = null;
		// 批量导入。参数：文件,文件名。

		List<Integer> list = null;
		try {
			// 创建处理EXCEL
			ReadExcel readExcel = new ReadExcel();
			// 解析excel，获取信息集合。
			Workbook wb = readExcel.getWorkbook(sfileName, sfile);
			errorInfo = readExcel.getErrorInfo();
			try {
				list = userService.importInfoStudent(wb, sfileName);
				for (Integer integer : list) {
					System.out.println(integer);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("导入失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(errorInfo);

	}
}
