package framework.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.SeleniumDriverManager;

import framework.page.reserve.FlightFinderPage;

/**
 * 
 * @author Ruben Blanco
 *
 */
public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(name = "userName") WebElement txtName; //userName field
	@FindBy(name = "password") WebElement txtPass; //password field
	@FindBy(name = "login") WebElement btnSubmit;  //submit button	 
	
	public LoginPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Login method
	 * @param user is a valid userName
	 * @param pass is a valid password of user
	 * @return FlightFinderPage object
	 */
	public FlightFinderPage doLogin(String user, String pass) {			
		//clear user name field
		txtName.clear();
		
		//enter user name
		txtName.sendKeys(user);
		
		//clear password field
		txtPass.clear();
		
		//enter password
		txtPass.sendKeys(pass);
		
		//click on submit button
		btnSubmit.click();
		
		return new FlightFinderPage();
	}
} 
