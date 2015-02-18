package framework.page.reserve;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.SeleniumDriverManager;

/**
 * Title:
 * @author Ruben Blanco
 *
 */
public class PurchasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	private boolean acceptNextAlert = true;
	@FindBy(name="buyFlights") WebElement btnPurchase;
	@FindBy(name="billCity") WebElement txtCity;
	@FindBy(name="billAddress1") WebElement txtAddress;
	@FindBy(name="cc_last_name") WebElement txtLastNameCard;
	@FindBy(name="cc_mid_name") WebElement txtMidNameCard;
	@FindBy(name="cc_frst_name") WebElement txtFirstNameCard;
	@FindBy(name="creditnumber") WebElement txtCardNumber;
	@FindBy(name="passLast0") WebElement txtLastName;
	@FindBy(name="passFirst0") WebElement txtFirstName;
		
	public PurchasePage() {
		driver = SeleniumDriverManager.getManager().getDriver();		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method fill the reservation form
	 * @return FlightConfirmationPage object
	 */
	public FlightConfirmationPage makePurchase(String city, String address,
			String lastNameCC,String midleNameCC,String firstNameCC,String year,
			String month,String cardNumber,String mealType,String CardType,String lastName,String firstName){		
		setFirstPassengerName(firstName);
		setLastName(lastName);
		selectMealType(mealType);
		selectCardType(CardType);
		setCardNumber(cardNumber);
		selectExpirationMonth(month);
		selectExpirationYear(year);
		setFirstNameCard(firstNameCC);
		setMidleNameCard(midleNameCC);
		setLastNameCard(lastNameCC);
		setBillAddress(address);
		setCity(city);
		clickPurchaseButton();			
		return new FlightConfirmationPage();
	}
	
	/**
	 * click on purchase button
	 */
	public void clickPurchaseButton() {
		btnPurchase.click();
	}
	
	/**
	 * set city
	 */
	public void setCity(String city) {
		txtCity.clear();
		txtCity.sendKeys(city);
	}
	
	/**
	 * set address
	 */
	public void setBillAddress(String address) {
		txtAddress.clear();
		txtAddress.sendKeys(address);
	}
	
	/**
	 * set last name
	 */
	public void setLastNameCard(String lastNameCC) {
		txtLastNameCard.clear();
		txtLastNameCard.sendKeys(lastNameCC);
	}
	
	/**
	 * set midle name
	 */
	public void setMidleNameCard(String midleNameCC) {
		txtMidNameCard.clear();
		txtMidNameCard.sendKeys(midleNameCC);
	}
	
	/**
	 * set first name
	 */
	public void setFirstNameCard(String firstNameCC) {
		txtFirstNameCard.clear();
		txtFirstNameCard.sendKeys(firstNameCC);
	}
	
	/**
	 * select expiration year
	 */
	public void selectExpirationYear(String year) {
		new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText(year);
	}
	
	/**
	 * select the expiration month
	 */
	public void selectExpirationMonth(String month) {
		new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText(month);
	}
	/**
	 * set the card number
	 */
	public void setCardNumber(String cardNumber) {
		txtCardNumber.clear();
		txtCardNumber.sendKeys(cardNumber);
	}
	
	/**
	 * select the card type
	 */
	public void selectCardType(String cardType) {
		new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText("Visa");
	}
	
	/**
	 * select the meal type
	 */
	public void selectMealType(String mealType) {
		new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Diabetic");
	}
	
	/**
	 * set last name fill
	 */
	public void setLastName(String lastName) {
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}
	
	/**
	 * Set name of first passenger
	 */
	public void setFirstPassengerName(String firstName) {
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}	
	
}
