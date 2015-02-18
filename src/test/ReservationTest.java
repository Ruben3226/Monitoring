package test;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import framework.page.home.HomePage;
import framework.page.login.LoginPage;
import framework.page.reserve.AirlinePage;
import framework.page.reserve.FlightConfirmationPage;
import framework.page.reserve.FlightFinderPage;
import framework.page.reserve.PurchasePage;
import util.Authentication;
import util.provider.ProviderClass;

/**
 * Title: Verify that a user can book a flight
 * @author Ruben Blanco
 *
 */
public class ReservationTest {	

	@Test(dataProvider = "Reserv1", dataProviderClass = ProviderClass.class)	
	public void reservTest(String passengerCount, String month, String day, String arriveCity, String returnMonth, String returnDay,
			String air,String City,	String BillAddress, String LastNameCard, String MidleNameCard,	String FirstNameCard,
			String ExpirationYear, String ExpirationMonth, String CardNumber, String CardType,	String MealType, String LastName, String FirstPassenger) {			
		HomePage hp = new HomePage();
		LoginPage login = hp.clickSignonLink();
		FlightFinderPage fly = login.doLogin("Rub", "123");
		AirlinePage airLine = fly.selectFlight(passengerCount,month,day,arriveCity,returnMonth, returnDay, air);
		PurchasePage purchasePage = airLine.SelectAirline();
		FlightConfirmationPage purchase = purchasePage.makePurchase(City,BillAddress,LastNameCard,MidleNameCard,FirstNameCard,ExpirationYear,
				ExpirationMonth,CardNumber,CardType,MealType,LastName,FirstPassenger);
		boolean isReserved = purchase.verifyConfirmMessage();
		Assert.assertTrue(isReserved);		
	}
	
	@AfterTest
	public void postCondition(){
		Authentication authentication = new Authentication();
		authentication.logOut();
	}
	
}
