package test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jxl.JXLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import page.home.HomePage;
import page.login.LoginPage;
import provider.ProviderClass;
import Util.ExcelSheetReader;
import Util.ManageUsersSuiteSetup;

public class CreateUserandLoginFlow {

	@BeforeTest  
	public void flowCreateUsers() throws JXLException, IOException {
		List<Map<String, String>> usersXLS;
		String[] user = new String[2];
		
		ExcelSheetReader xlsFile = new ExcelSheetReader(System.getProperty("user.dir") + "/src/data/ManageUsersSuiteSetup.xls");
		usersXLS = xlsFile.getValues("Users");	
		
		user = ManageUsersSuiteSetup.getCreatedUser(usersXLS);
				
		ManageUsersSuiteSetup.createUsersByUI(usersXLS);
		HomePage homePage = new HomePage();
		LoginPage loginpage = homePage.clickSignonLink();		
		loginpage.doLogin(user[0],user[1]);
	}
}
