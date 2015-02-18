package framework.page.registry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.SeleniumDriverManager;
import commons.UIMethods;
import framework.page.login.LoginPage;

/**
 * Title: in this class is verified the confirmation message of created new user
 * @author Ruben Blanco
 *
 */
public class RegistryConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 
	@FindBy(css = "a > font > b") WebElement actualMessage; 
	@FindBy(name = "password") WebElement txtPass; 
	@FindBy(name = "login") WebElement btnSubmit;  
	
	public RegistryConfirmationPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
	} 	
		
	/**
	 * 
	 * @return a message that contains the new created userName
	 */
	public String getConfirmMessage() {
		//get the confirmation message after create new user
		return driver.findElement(By.cssSelector("a > font > b")).getText();
	}
	
	/**
	 * 
	 * @param userName is the userName of new created user
	 * @return
	 */
	public Boolean isUserCreated(String userName) {
		//get the confirmation message after create new user
		return UIMethods.isElementPresent(By.xpath("//b[contains(text(),'Note: Your user name is " + userName + ".')]"));
	}
	
	/**
	 * method to login with account of new user created
	 * @param newUser is the userName of new created user
	 * @param newPass is the password of new created user
	 * @return LoginPage object
	 */
	public LoginPage loginCreatedUser(String newUser, String newPass) {
		LoginPage lp = new LoginPage();
		lp.doLogin(newUser, newPass);
		return new LoginPage();
	}	
	
	
}
