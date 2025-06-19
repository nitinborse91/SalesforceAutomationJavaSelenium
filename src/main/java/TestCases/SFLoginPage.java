package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SFLoginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is a test case for Salesforce Login Page.");
		System.out.println("Start the Salesforce Automation Testing.");
		
		//Create WebDriver instance and initialize it
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open Salesforce Login Page
		driver.get("https://nitscopvtltd-dev-ed.my.salesforce.com/");
		
		
		
	}

}
