package ch01;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Test {
	private static String path = "C:\\Users\\tao\\Documents\\t114" ;
	public static void test1() throws Exception{
		// Workbook wb = new HSSFWorkbook();
		 Workbook wb =  new XSSFWorkbook();
		 FileOutputStream os = new FileOutputStream(new File(path + "\\t114names.xlsx")) ;
		 wb.write(os);
		 os.close(); 
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//test1() ;
		//test2() ;
		//test3() ;
		//test4() ;
		test5() ;
	}
	public static void test2() throws Exception{
		// Workbook wb = new HSSFWorkbook();
		FileInputStream is = new FileInputStream(new File(path +"\\t114names.xlsx")) ;
		Workbook wb =  new XSSFWorkbook(is);
		Sheet sheet = wb.createSheet("t114") ;
		OutputStream os = new FileOutputStream(new File(path +"\\t114names.xlsx")) ;
		wb.write(os);
		is.close();
		os.close();
	}
	public static void test3() throws Exception{
		// Workbook wb = new HSSFWorkbook();
		FileInputStream is = new FileInputStream(new File(path +"\\t114names.xlsx")) ;
		Workbook wb =  new XSSFWorkbook(is);
		//创建助手
	//	CreationHelper createHelper = wb.getCreationHelper();
		//单元格样式
	//	CellStyle cellStyle = wb.createCellStyle();
	//	cellStyle.setDataFormat(
	//	        createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
		
		Sheet sheet = wb.getSheet("t114") ;
		//1.创建一行
		Row row = sheet.createRow(0) ;
		//2.创建一列
		Cell cell = row.createCell(0) ;
		//3.向列中写入数据
		cell.setCellValue("好好学习天天向上");
		row.createCell(1).setCellValue(1.11);
		row.createCell(2).setCellValue(true);
	//	Cell cell3 = row.createCell(3) ;
	//	cell3.setCellStyle(cellStyle);
	//	cell3.setCellValue(new Date());
		OutputStream os = new FileOutputStream(new File(path +"\\t114names.xlsx")) ;
		wb.write(os);
		is.close();
		os.close();
	}
	
	public static void test4() throws Exception{
		//1.创建核心对象
		InputStream is = new FileInputStream(new File(path+"\\t114names.xlsx")) ;
		Workbook wb = new XSSFWorkbook(is) ;
		//2.得到表格中的那一页
		Sheet sheet = wb.getSheet("t114") ;
		//3.得到所有的行
		for(Row row:sheet){
			for(Cell c:row){
				/*if(c.getCellType() == Cell.CELL_TYPE_NUMERIC){
					System.out.print(c.getNumericCellValue());
				}
				else if(c.getCellType()==Cell.CELL_TYPE_BOOLEAN){
					System.out.println(c.getBooleanCellValue());
				}
				else{*/
					System.out.print(c.getStringCellValue());
				//}
			}
			System.out.println("");
		}
		is.close() ;
	}
	
	public static void test5() throws Exception{
		//输入流，以流的形式读取硬盘上的文件
		InputStream is = new FileInputStream(new File(path+"\\t114names.xlsx")) ;
		//到wb
		Workbook wb = new XSSFWorkbook(is) ;
		//2.得到表格中的那一页:t116
		Sheet sheet = wb.getSheet("116") ;
		//3.得到所有的行
		for(Row row:sheet){
			for(Cell c:row){
				if(c.getCellType() == Cell.CELL_TYPE_NUMERIC){
					
					System.out.print(c.getNumericCellValue());
				}
				else if(c.getCellType()==Cell.CELL_TYPE_BOOLEAN){
					System.out.println(c.getBooleanCellValue());
				}
				else{ 
					String s = c.getStringCellValue() ;
					int cindex = c.getColumnIndex() ;
					if(cindex==2){
						s = s.substring(1) ;
					}
					System.out.print(s + "\t");
				}
			}
			System.out.println("");
		}
		is.close() ;
	}
	
	
	
	
	
	
	
	
}
