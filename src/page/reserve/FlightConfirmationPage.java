package page.reserve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.SeleniumDriverManager;

/**
 * Title:
 * @author Ruben Blanco
 *
 */
public class FlightConfirmationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private boolean acceptNextAlert = true;
	
	public FlightConfirmationPage() {
		driver = SeleniumDriverManager.getManager().getDriver();		
		wait = SeleniumDriverManager.getManager().getWait();
	}
	
	/**
	 * 
	 * @return true if the reservation is correct
	 */
	public boolean verifyConfirmMessage(){			
	    String confirMessage = driver.findElement(By.xpath("//tr[3]/td/p/font")).getText();
	    if(confirMessage.contains("has been booked!")){
	    	return true;
	    }
	    else{
	    	return false;	    	
	    }		
	}
}
