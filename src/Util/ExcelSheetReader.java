package util;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelSheetReader {	
	private String path;
	
	public ExcelSheetReader(String path){
		this.path = path;
	}

	public List<Map<String, String>> getValues(String sheetName) throws JXLException, IOException{	
		Workbook workbook = Workbook.getWorkbook(new File(path));

		List<Map<String, String>> values = new LinkedList<>();	

		Sheet sheet = (Sheet) workbook.getSheet(sheetName); 

		Map<String, String> dataXLS ;

		for (int i = 0; i < sheet.getRows(); i++) {
			dataXLS = new TreeMap<>();
			for (int j = 0; j < sheet.getColumns(); j++) {
				String key = sheet.getCell(j,0).getContents();
				String value = sheet.getCell(j,i).getContents();
				dataXLS.put(key, value);
				System.out.println("key = "+key+"-----------"+"value = "+value);
			}
			values.add(dataXLS);
		}		
		System.out.println("complete get values");
		return values;
	}
}
