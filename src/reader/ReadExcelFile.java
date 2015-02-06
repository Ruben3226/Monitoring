package reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {

	/**
	 * This method read a xlsx or xls files
	 * @param filePath is the path of the file that contains the data
	 * @param fileName is the name of xlsx or xls file
	 * @param sheetName is the name of sheet into the main file (xlsx or xls) 
	 * @return a object that contains the data of a row
	 */
	@SuppressWarnings("resource")
	public Object[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{
		File file = new File(filePath+"\\"+fileName); 												//join the file path and the file name
		Object[][] data = new Object[2][12]; 														//matrix to contain the data of external file
		FileInputStream inputStream = new FileInputStream(file);									//load the file into the inputStream
		Workbook excelWorkbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));						//get the index
		
		//verify the file type
		if(fileExtensionName.equals(".xlsx")){			
			excelWorkbook = new XSSFWorkbook(inputStream);											//when the file is .xlsx
		}
		else if(fileExtensionName.equals(".xls")){
			excelWorkbook = new HSSFWorkbook(inputStream);											//when the file is xls
		}
		Sheet excelSheet = excelWorkbook.getSheet(sheetName);
		int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum();
		
		//iteration row by row into the file 
		for (int i = 0; i < rowCount+1; i++) {			
			//get data of row
			Row row = excelSheet.getRow(i);
			
			//iteration column by column
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//load values into the matrix
				data[i][j]=row.getCell(j).getStringCellValue();
			}			
		}
		return data;
	}
}
