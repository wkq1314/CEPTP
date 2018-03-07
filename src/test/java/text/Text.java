package text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.tit.user.Iservice.IUserService;
import cn.edu.tit.user.utils.ReadExcel;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class Text {
	private static Logger logger = Logger.getLogger(Text.class);  
//  private ApplicationContext ac = null;  


    @Resource  
    private IUserService userService ; 
    
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
	@Test
	public void testimport() {
		List<Integer> list = null;
		// 创建处理EXCEL
		ReadExcel readExcel = new ReadExcel();
		String fileName = "123.xls";
		File file = new File("C:/Users/Administrator/Desktop/123.xls");
		// 解析excel，获取信息集合。
		Workbook wb = readExcel.getWorkbook(fileName , file );
		try {
			list = userService.importInfo(wb, fileName);
			for (Integer integer : list) {
				System.out.println(integer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("导入失败");
		}
	}
    

}
