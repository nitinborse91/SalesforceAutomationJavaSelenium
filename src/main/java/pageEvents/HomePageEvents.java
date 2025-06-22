package pageEvents;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {

	ElementFetch element = new ElementFetch();
	public void loginButtonClick() {
		// Logic to click the login button
		element.getWebElement("xpath", HomePageElements.loginButtonText).click();
		System.out.println("Login button clicked");
	}
}
