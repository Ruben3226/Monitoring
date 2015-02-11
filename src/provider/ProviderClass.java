package provider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import reader.ReadExcelFile;

/**
 * 
 * @author Ruben Blanco
 *
 */
public class ProviderClass {	
	
	/**
	 * This method provides data to VerifyLogin test
	 * @return a Object user that have login and password
	 */
	@DataProvider(name = "Login")
	public static Object[][] createData() {
		Object[][] user={{"user1","123"},{"Rub","456"},{"Rub","123"},{"user3","789"}};
		return(user);
	}	
	
	/**
	 * This method provides data from xlsx file to NewUserTest
	 * @return a data with the read values from xlsx file
	 */
	@DataProvider(name="newUser")
	public static Object[][] getReservFromXlsx() throws IOException{		
		ReadExcelFile excelFile = new ReadExcelFile();
		String filePath = System.getProperty("user.dir")+"\\src\\data";
		Object[][] data = excelFile.readExcel(filePath,"accountsData.xlsx","User");
		data.toString();
		return data;
	}
	
	/**
	 * This method provides a data to ReservationTest
	 * @return a object with data to do a reservation
	 */
	@DataProvider(name = "Reserv1")
	public static Object[][] createData2() {
		Object[][] reservation={{"2", "March", "3", "London", "July", "25", "Blue Skies Airlines", "CBBA", "1325 Borregas Avenue",
			"Pass2", "Pass2", "Pass2", "2010", "01", "456", "Visa", "Diabetic", "Pass1", "Pass1"}};
		return(reservation);
	}
}
