package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.SeleniumDriverManager;

public class Authentication {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(name = "userName") WebElement txtlogin;
	@FindBy(name = "password") WebElement txtPassword;
	@FindBy(name = "login") WebElement btnSubmit;
	@FindBy(linkText = "SIGN-OFF") WebElement signoffLink;
	
	
	public Authentication() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void logIn(String user, String pass){
		//clear user name field
		txtlogin.clear();
		//enter user name
		txtlogin.sendKeys(user);
		//clear password field
		txtPassword.clear();
		//enter password
		txtPassword.sendKeys(pass);
		//click submit button
		btnSubmit.click();	
	}
	
	public void logOut(){
		//logout user 
		signoffLink.click();		
	}	
}
