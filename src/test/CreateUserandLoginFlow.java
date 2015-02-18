package test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jxl.JXLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import framework.page.home.HomePage;
import framework.page.login.LoginPage;
import framework.page.registry.RegistryPage;
import framework.page.reserve.AirlinePage;
import framework.page.reserve.FlightConfirmationPage;
import framework.page.reserve.FlightFinderPage;
import framework.page.reserve.PurchasePage;
import util.ExcelSheetReader;
import util.ManageUsersSuiteSetup;
import util.provider.ProviderClass;

public class CreateUserandLoginFlow {

	@Test (dataProvider = "Reserv1", dataProviderClass = ProviderClass.class)
	public void flowCreateUsers(String passengerCount, String month, String day, String arriveCity, String returnMonth, String returnDay,
			String air,String City,	String BillAddress, String LastNameCard, String MidleNameCard,	String FirstNameCard,
			String ExpirationYear, String ExpirationMonth, String CardNumber, String CardType,	String MealType, String LastName, String FirstPassenger) throws JXLException, IOException {
		
		List<Map<String, String>> usersXLS;
		String[] user = new String[2];
		ExcelSheetReader xlsFile = new ExcelSheetReader(System.getProperty("user.dir") + "/src/data/ManageUsersSuiteSetup.xls");
		usersXLS = xlsFile.getValues("Users");	
		user = ManageUsersSuiteSetup.getCreatedUser(usersXLS);
		ManageUsersSuiteSetup.createUsersByUI(usersXLS);
		HomePage homePage = new HomePage();
		LoginPage loginpage = homePage.clickSignonLink();		
		FlightFinderPage fly = loginpage.doLogin(user[0],user[1]);		
	    AirlinePage airLine = fly.selectFlight(passengerCount,month,day,arriveCity,returnMonth, returnDay, air);
		PurchasePage purchasePage = airLine.SelectAirline();
		FlightConfirmationPage purchase = purchasePage.makePurchase(City,BillAddress,LastNameCard,MidleNameCard,FirstNameCard,ExpirationYear,
				ExpirationMonth,CardNumber,CardType,MealType,LastName,FirstPassenger);
		boolean isReserved = purchase.verifyConfirmMessage();
		Assert.assertTrue(isReserved);
		
	}
}
