package framework.page.reserve;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.SeleniumDriverManager;

/**
 * Title:
 * @author Ruben Blanco
 *
 */
public class AirlinePage {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(name="reserveFlights") WebElement btnReservation;	
	
	public AirlinePage() {
		driver = SeleniumDriverManager.getManager().getDriver();		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method confirm the flight
	 * @return PurchasePage object
	 */
	public PurchasePage SelectAirline(){
		btnReservation.click();	
		return new PurchasePage();
	}	

}
