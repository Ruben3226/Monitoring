package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.page.home.HomePage;
import framework.page.registry.RegistryConfirmationPage;
import framework.page.registry.RegistryPage;
import util.Authentication;
import util.provider.ProviderClass;

/**
 * Title: Verify that a new user is created
 * @author Ruben Blanco
 *
 */
public class NewUserTest {

	@Test(dataProvider = "newUser", dataProviderClass = ProviderClass.class)	
	public void ReservationTest(String firstName, String lastName,String phone,String email,String address,String city,String stateProvince,
			String postalCode, String country, String userName, String pass, String rePass) {			
		HomePage hp = new HomePage();		
		RegistryPage regisUser = hp.clickNewUserLink();
		RegistryConfirmationPage confirmPage = regisUser.createNewUser(firstName, lastName, phone, email, address, city, stateProvince, postalCode,
				country, userName, pass, rePass);
		String expectedMessage = "Note: Your user name is " + userName + ".";
		Assert.assertEquals(confirmPage.getConfirmMessage(),expectedMessage);		
		Authentication login = new Authentication();		
		login.logOut();
	}

}
