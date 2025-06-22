package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import base.BaseTest;

public class SuiteListener implements ITestListener, IAnnotationTransformer{

	@Override
	public void onStart(ITestContext context) {
		// Code to run before the suite starts
		System.out.println("Suite is starting: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// Code to run after the suite finishes
		System.out.println("Suite has finished: " + context.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		// Code to run before each test method starts
		System.out.println("Test is starting: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Code to run when a test method succeeds
		System.out.println("Test passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Code to run when a test method fails
		System.out.println("Test failed: " + result.getMethod().getMethodName());
		String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName() + ".png";
		File file1 = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File(filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Code to run when a test method is skipped
		System.out.println("Test skipped: " + result.getMethod().getMethodName());
	}
	
	//-----------------------------------------------------------------------------------------------
	public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
				// This method allows you to modify the test annotations at runtime
		annotation.setRetryAnalyzer(RetryAnalyzer.class);

		  }

}
