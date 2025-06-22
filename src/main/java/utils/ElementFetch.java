package utils;

import base.BaseTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFetch {

	public WebElement getWebElement(String indentifierType, String identifierValue) {

		WebElement element = null;

		switch (indentifierType.toLowerCase()) {
		case "id":
			element = BaseTest.driver.findElement(By.id(identifierValue));
			break;

		case "name":
			element = BaseTest.driver.findElement(By.name(identifierValue));
			break;

		case "class":
			element = BaseTest.driver.findElement(By.className(identifierValue));
			break;

		case "tag":
			element = BaseTest.driver.findElement(By.tagName(identifierValue));
			break;

		case "css":
			element = BaseTest.driver.findElement(By.cssSelector(identifierValue));
			break;

		case "xpath":
			element = BaseTest.driver.findElement(By.xpath(identifierValue));
			break;

		default:
			throw new IllegalArgumentException("Invalid identifier type: " + indentifierType);
		}
		return element;
	}
	
	public List<WebElement> getWebElements(String indentifierType, String identifierValue) {

		List<WebElement> elements = null;
 
		switch (indentifierType.toLowerCase()) {
		case "id":
			elements = BaseTest.driver.findElements(By.id(identifierValue));
			break;

		case "name":
			elements = BaseTest.driver.findElements(By.name(identifierValue));
			break;

		case "class":
			elements = BaseTest.driver.findElements(By.className(identifierValue));
			break;

		case "tag":
			elements = BaseTest.driver.findElements(By.tagName(identifierValue));
			break;

		case "css":
			elements = BaseTest.driver.findElements(By.cssSelector(identifierValue));
			break;

		case "xpath":
			elements = BaseTest.driver.findElements(By.xpath(identifierValue));
			break;

		default:
			throw new IllegalArgumentException("Invalid identifier type: " + indentifierType);
		}
		return elements;
	}
}
