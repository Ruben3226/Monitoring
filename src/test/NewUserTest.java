package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Util.Authentication;
import page.home.HomePage;
import page.registry.RegistryConfirmationPage;
import page.registry.RegistryPage;
import provider.ProviderClass;

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
