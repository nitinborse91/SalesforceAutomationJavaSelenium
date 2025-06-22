package qa.tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class TestCase01 extends BaseTest {

	ElementFetch elementFetch = new ElementFetch();
	HomePageEvents homePageEvents = new HomePageEvents();
	LoginPageEvents loginPageEvents = new LoginPageEvents();
	
	
	@Test
	public void sampleMethodForEnteringCredentials() {	
		homePageEvents.loginButtonClick();
		loginPageEvents.verifyIfLoginPageIsLoaded();
		loginPageEvents.enterCredentials();
	}
}
