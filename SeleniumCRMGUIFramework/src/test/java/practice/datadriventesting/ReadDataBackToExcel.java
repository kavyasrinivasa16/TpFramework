package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\New folder\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(4);
		cel.setCellType(CellType.STRING);
		cel.setCellValue("PASS");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\New folder\\TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("----executed----");
		
			
	}

}
