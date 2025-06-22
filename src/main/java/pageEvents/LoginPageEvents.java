package pageEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {

	ElementFetch element = new ElementFetch();
	
	public void verifyIfLoginPageIsLoaded() {
		// Logic to verify if the login page is loaded
		Assert.assertTrue(element.getWebElements("xpath", LoginPageElements.loginText).size() > 0, "Login page is not loaded, Element not found");
	}
	
	
	public void enterCredentials() {
		// Logic to enter credentials
		element.getWebElement("xpath", LoginPageElements.emailAddressField).sendKeys("nitin.allsubscriptions@gmail.com");
		element.getWebElement("xpath", LoginPageElements.passwordField).sendKeys("Nitin@123");
		System.out.println("Credentials entered");
	}
	
}
