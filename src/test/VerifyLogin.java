package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Util.Authentication;
import page.home.HomePage;
import page.login.LoginPage;
import provider.ProviderClass;


/**
 * Title: Verify that a user is authenticated
 * @author Ruben Blanco
 *
 */
public class VerifyLogin {	
	
	@Test(dataProvider = "Login", dataProviderClass = ProviderClass.class)	
	public void testVerifyLogin(String user, String pass) {
		Authentication authentication = new Authentication();
		HomePage hp = new HomePage();
		LoginPage loginPage = hp.clickSignonLink();
		page.reserve.FlightFinderPage flightFind = loginPage.doLogin(user, pass);
		Assert.assertEquals(flightFind.getLogOutLink(), "SIGN-OFF");
		authentication.logOut(); 
	}
}
