package test;

import java.io.IOException;
import java.sql.SQLException;

import jxl.JXLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.page.home.HomePage;
import framework.page.login.LoginPage;
import framework.page.reserve.FlightFinderPage;
import util.Authentication;
import util.ManageUsersSuiteSetup;
import util.provider.ProviderClass;
/**
 * Title: Verify that a user is authenticated
 * @author Ruben Blanco
 *
 */
public class VerifyLogin {	
	
	@Test(dataProvider = "Login", dataProviderClass = ProviderClass.class)	
	public void testVerifyLogin(String user, String pass) throws Exception {
		HomePage hp = new HomePage();
		LoginPage loginPage = hp.clickSignonLink();
		FlightFinderPage flightfFinder = loginPage.doLogin(user, pass);
		Assert.assertEquals(flightfFinder.getLogOutLink(), "SIGN-OFF");		
	}

	@AfterClass
	public void logOut() throws SQLException {
		Authentication authentication = new Authentication();
		authentication.logOut();
	}
}
