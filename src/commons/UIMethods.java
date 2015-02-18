package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import util.Authentication;
import framework.page.home.HomePage;
import framework.page.registry.RegistryConfirmationPage;
import framework.page.registry.RegistryPage;

public class UIMethods {

	static WebDriver driver = SeleniumDriverManager.getManager().getDriver();

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void createUserByUI(String firstName, String lastName, String phone,
			String email, String address1, String address2, String city, String	state,
			String postalCode, String country, String userName, String password,
			String repassword){

		HomePage hp = new HomePage();		
		RegistryPage regisUser = hp.clickNewUserLink();
		RegistryConfirmationPage confirmPage = regisUser.createNewUser(firstName, lastName, phone, email, address1, city, state, postalCode,
				country, userName, password, repassword);
		
		Authentication authentication = new Authentication();
		authentication.logOut();
	}

}
