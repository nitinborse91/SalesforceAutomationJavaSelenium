package base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.utility.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConstantUrl;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeTest
	public void beforeTestMethod() {
		// Code to run before any test method
		System.out.println("Running before all tests");

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "index_ExtendReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("UserName", "TestUser");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation Test Results");
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String browser, Method testMethod) {
		// Code to run before each test method
		System.out.println("Running before each test method");
		logger = extent.createTest(testMethod.getName());

		setupWebDriver(browser);
		driver.manage().window().maximize();
		driver.get(ConstantUrl.testurl);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
  
	@AfterMethod
	public void afterMethodMethod(ITestResult result) {
		// Code to run after each test method
		System.out.println("Running after each test method");

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - TestCase Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - TestCase Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - TestCase PASS", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - TestCase Skipped", ExtentColor.ORANGE));
		}
		// Quit the WebDriver instance after each test method
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterTest
	public void afterTestMethod() {
		// Code to run after all test methods
		System.out.println("Running after all tests");

		// Flush the extent reports
		if (extent != null) {
			extent.flush();
		}

	}

	// Methods to setup WebDriver.
	public void setupWebDriver(String browser) {
		// Code to initialize WebDriver
		// This can include setting up browser options, capabilities, etc.
		System.out.println("Setting up WebDriver");
		if (browser.equalsIgnoreCase("chrome")) {
			// Initialize ChromeDriver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			// Initialize FirefoxDriver
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			// Initialize EdgeDriver
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser not supported: " + browser);
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}

	}

}
