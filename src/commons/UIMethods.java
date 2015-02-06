package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import driver.SeleniumDriverManager;

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
}
