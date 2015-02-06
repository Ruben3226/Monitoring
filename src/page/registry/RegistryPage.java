package page.registry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.SeleniumDriverManager;

/**
 * Title: This class is performed to create the new user
 * @author Ruben Blanco
 *
 */
public class RegistryPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 	
	@FindBy(name="firstName") WebElement txtFirstName;
	@FindBy(name="lastName") WebElement txtLastName;
	@FindBy(name="phone") WebElement txtPhone;
	@FindBy(name="userName") WebElement txtEmail;
	@FindBy(name="address1") WebElement txtAddress;
	@FindBy(name="city") WebElement txtCity;
	@FindBy(name="state") WebElement txtState;
	@FindBy(name="postalCode") WebElement txtPostal;
	@FindBy(name="email") WebElement txtUsername;
	@FindBy(name="password") WebElement txtPass;
	@FindBy(name="confirmPassword") WebElement txtRepass;
	@FindBy(name="register") WebElement btnRegister;
	
	
	public RegistryPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method to fill the create new user form
	 * @param firstName is the user first name
	 * @param lName is the user last name
	 * @param phone is the user phone number
	 * @param email is a valid user email
	 * @param address the current user address
	 * @param city is the user city
	 * @param stateProvince is the user state or province
	 * @param postalCode is the user postal code
	 * @param country is the user country 
	 * @param userName is the userName
	 * @param pass is the user password
	 * @param rePass is the same that pass variable
	 * @return
	 */	
	public RegistryConfirmationPage setNewUser(String firstName,	String lastName, String phone, 
			String email, String address, String city, String stateProvince, String postalCode,
			String country, String userName, String pass, String rePass) {			
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phone);
		setEmail(email);
		setAddress(address);
		setCity(city);
		setStateProvince(stateProvince);
		setPostalCode(postalCode);
		selectCountry(country);
		setUserName(userName);
		setPassword(pass);
		confirmPassword(rePass);
		clickSubmitButton();	
		return new RegistryConfirmationPage();
	}
	
	/**
	 * Click after to fill the form
	 */
	public void clickSubmitButton() {
		btnRegister.click();
	}
	
	/**
	 * @param rePass is the same password in the setPassword method
	 */
	public void confirmPassword(String rePass) {
		txtRepass.clear();
		txtRepass.sendKeys(rePass);
	}
	
	/**
	 * @param pass is the user password 
	 */
	public void setPassword(String pass) {
		txtPass.clear();
		txtPass.sendKeys(pass);
	}
	
	/**
	 * @param userName is nick that will use the user
	 */
	public void setUserName(String userName) {
		txtUsername.clear();
		txtUsername.sendKeys(userName);
	}
	
	/**
	 * @param country is the country if user
	 */
	public void selectCountry(String country) {
		new Select(driver.findElement(By.name("country"))).selectByVisibleText(country);//"BAHAMAS"
	}
	
	/**
	 * @param postalCode is the postal code that have the user
	 */
	public void setPostalCode(String postalCode) {
		txtPostal.clear();
		txtPostal.sendKeys(postalCode);
	}
	
	/**
	 * @param stateProvince is the state or province of the user
	 */
	public void setStateProvince(String stateProvince) {
		txtState.clear();
		txtState.sendKeys(stateProvince);
	}
	
	/**
	 * @param city is the city of the user
	 */
	public void setCity(String city) {
		txtCity.clear();
		txtCity.sendKeys(city);
	}
	
	/**
	 * @param address is the current address of user
	 */
	public void setAddress(String address) {
		txtAddress.clear();
		txtAddress.sendKeys(address);
	}
	
	/**
	 * @param email is a valid email of the user
	 */
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	/**
	 * @param phone is the user phone number
	 */
	public void setPhoneNumber(String phone) {
		txtPhone.clear();
		txtPhone.sendKeys(phone);
	}
	
	/**
	 * 
	 * @param lastName is the user last name
	 */
	public void setLastName(String lastName) {
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}
	
	/**
	 * 
	 * @param firstName is the user first name
	 */
	public void setFirstName(String firstName) {
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}

}
