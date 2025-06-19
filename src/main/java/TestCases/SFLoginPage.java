package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SFLoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is a test case for Salesforce Login Page.");
		System.out.println("Start the Salesforce Automation Testing.");
		
		//Create WebDriver instance and initialize it
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open Salesforce Login Page
		driver.get("https://nitscopvtltd-dev-ed.my.salesforce.com/");
		
		//Log in to Salesforce using credentials
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("nitin.tester1991+01@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Nitin@1991");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		System.out.println("Logged in to Salesforce successfully.");
		Thread.sleep(2000);
		
		//Close the browser
		driver.quit();
		
	}

}
