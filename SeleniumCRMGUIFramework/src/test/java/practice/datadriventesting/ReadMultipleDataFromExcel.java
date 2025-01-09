package practice.datadriventesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\New folder\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int rowcount = sh.getLastRowNum();
		for(int i=1; i<=rowcount;i++)
		{
		Row row = sh.getRow(i);
		String column1data = row.getCell(0).toString();
		String column2data = row.getCell(1).toString();
		System.out.println(column1data +"\t"+ column2data );
		}
		wb.close();
	}
}
