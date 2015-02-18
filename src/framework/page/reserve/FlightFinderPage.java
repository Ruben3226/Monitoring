package framework.page.reserve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.SeleniumDriverManager;

/**
 * 
 * @author Ruben Blanco
 *
 */
public class FlightFinderPage {	
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(linkText = "SIGN-OFF") WebElement logoutLink;
	@FindBy(css = "font > font > input[name=\"servClass\"]") WebElement rbtnFlightType;
	@FindBy(name = "findFlights") WebElement btnContinue;	
	
	public FlightFinderPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method fill the form to select the fight
	 * @return AirlinePage object
	 */
	public AirlinePage selectFlight(String passengerCount, String month, String day, String arriveCity, String returnMonth, String returnDay, String air){
		new Select(driver.findElement(By.name("passCount"))).selectByVisibleText(passengerCount);
		new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText(month);
		new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText(day);
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText(arriveCity);
		new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText(returnMonth);
		new Select(driver.findElement(By.name("toDay"))).selectByVisibleText(returnDay);
		rbtnFlightType.click();
		new Select(driver.findElement(By.name("airline"))).selectByVisibleText(air);
		btnContinue.click();
		return new AirlinePage();
	}
	
	/**
	 * This method get the logout text
	 * @return link text
	 */
	public String getLogOutLink() {	
		//clear user name field
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SIGN-OFF"))).getText();;
		return logoutLink.getText() ;		
	}
}
