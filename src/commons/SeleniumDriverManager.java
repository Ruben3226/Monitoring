/*
 *
 */
package commons;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.reader.xmlreader.XmlFileReader;

/**
 * Manages the web browser
 */
public class SeleniumDriverManager
{
	private static SeleniumDriverManager manager = null;
	private WebDriver driver;
	private WebDriverWait wait;
	//private String baseUrl = "http://newtours.demoaut.com/";
	XmlFileReader xmlReader = new XmlFileReader();

	protected SeleniumDriverManager()
	{
		initializeDriver();
	}

	/**
	 * Select a browser
	 */
	private void initializeDriver()
	{   
		String browser = xmlReader.getValue("execution", "browser");

		switch (browser) {
		case "chrome":			
			System.setProperty("webdriver.chrome.driver", getUserDir());
			driver = new ChromeDriver(); 
			break;
		case "firefox": 
			driver = new FirefoxDriver();  
			break;
		case "iexplorer":    	 
		default:			
			System.setProperty("webdriver.ie.driver", getUserDir());
			driver = new InternetExplorerDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15, 50);
		driver.get(xmlReader.getValue("execution", "url"));
	}

	public String getUserDir(){    
		String driverPath = xmlReader.getValue("execution", "path");
		String userDir = (System.getProperty("user.dir")+driverPath);
		return userDir;
	}

	public static SeleniumDriverManager getManager()
	{
		if(manager == null)
		{
			manager = new SeleniumDriverManager();
		}
		return manager;
	}

	/**
	 * Get the Web driver
	 * @return
	 */
	public WebDriver getDriver()
	{
		return driver;
	}

	public WebDriverWait getWait()
	{
		return wait;
	}

	/**
	 * Set to null the webdriver
	 */
	public void quitDriver()
	{
		try
		{
			driver.quit();
		}
		catch (Exception e)
		{
			//Logger.getLogger(getClass()).error("Unable to quit the webdriver" , e);
		}
		driver = null;
	}
}