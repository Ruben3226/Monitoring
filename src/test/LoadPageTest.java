package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.home.HomePage;

/**
 * Title: Verify that page is loaded
 * @author Ruben Blanco
 *
 */
public class LoadPageTest {
	@Test
	public void VerifyTitle() {		
		String expectedTitle="Welcome: Mercury Tours";
		HomePage hp = new HomePage();
		String actualTitle=hp.getHomeTitle();
		Assert.assertEquals(expectedTitle, actualTitle);		
	}	
}
