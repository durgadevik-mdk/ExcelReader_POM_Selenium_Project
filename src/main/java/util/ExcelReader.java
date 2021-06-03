package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {	
	
	public String path;
	public FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	
	// Constructor to initialize variables
	public ExcelReader(String path) {
	this.path = path;
	try {
	fis = new FileInputStream(path);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);
	fis.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}

	// Method to call the value
	public String getCellData(String sheetName, String colName, int rowNum) {
	// For Sheet
	int index = workbook.getSheetIndex(sheetName);
	int col_Num = 0;
	sheet = workbook.getSheetAt(index);

	// For Row
	row = sheet.getRow(0);
	for (int i = 0; i < row.getLastCellNum(); i++) {
	if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
	col_Num = i;
	}
	}

	// For Column
	row = sheet.getRow(rowNum - 1);
	cell = row.getCell(col_Num);
	return cell.getStringCellValue();
	}

	
	public int testReadCellNumeric() throws FileNotFoundException, IOException 
	{
	         //path=System.getProperty("user.dir"); 

	         // load workbook
	XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(path));

	        // read numeric data 
	int data= (int)wb.getSheetAt(0).getRow(0).getCell(1).getNumericCellValue();

	        // print on console
	System.out.println("Data from Excel is >>> "+data);
	return data;

	}
	


}
