package page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.login.LoginPage;
import page.registry.RegistryPage;
import driver.SeleniumDriverManager;

/**
 * 
 * @author Ruben Blanco
 *
 */
public class HomePage {
	
	private WebDriver driver;	
	private WebDriverWait wait;	
	@FindBy(linkText="SIGN-ON") WebElement loginLink;
	@FindBy(linkText="REGISTER") WebElement registerLink;
 
	public HomePage() {		
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * get home page title
	 * @return page title
	 */
	public String getHomeTitle(){		
		return driver.getTitle();
	}
	
	/**
	 * click on login link
	 * @return LoginPage object
	 */
	public LoginPage clickSignonLink() {		
		// wait for sign-on link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SIGN-ON")));
		loginLink.click();
		return new LoginPage();
	}
	
	/**
	 * click on create user link
	 * @return RegistryPage object
	 */
	public RegistryPage clickNewUserLink() {		
		// wait for Register link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("REGISTER")));
		registerLink.click();
		return new RegistryPage();
	}
}
