package test;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import driver.SeleniumDriverManager;
import Util.Authentication;
import Util.ManageUsersSuiteSetup;
import page.home.HomePage;
import page.login.LoginPage;
import page.reserve.FlightFinderPage;
import provider.ProviderClass;
import report.RealReport;
import report.ScreenShot;

/**
 * Title: Verify that a user is authenticated
 * @author Ruben Blanco
 *
 */
//@Listeners(RealReport.class)
public class VerifyLogin {		
	private WebDriver driver;

	@Test(dataProvider = "Login", dataProviderClass = ProviderClass.class)	
	public void testVerifyLogin(String user, String pass) throws Exception {
		//ScreenShot screenShot = new ScreenShot();
				
		HomePage hp = new HomePage();
		LoginPage loginPage = hp.clickSignonLink();
		FlightFinderPage flightfFinder = loginPage.doLogin(user, pass);
		Assert.assertEquals(flightfFinder.getLogOutLink(), "SIGN-OFF");
		
		//screenShot.takeSnapShot(driver, "c://"+user);			
		ManageUsersSuiteSetup p = new ManageUsersSuiteSetup();
		p.init();		
	}

	@AfterClass
	public void deleteData() throws SQLException {
		Authentication authentication = new Authentication();
		authentication.logOut();
	}
}
