package Aditya.Rathi.ExtentReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void config() 
	{
	String path = System.getProperty("user.dir")+"\\reports\\index.html";	
   ExtentSparkReporter reporter = new ExtentSparkReporter(path);
   reporter.config().setReportName("Web Automation Results");
   reporter.config().setDocumentTitle("Test Results");
   
   extent = new ExtentReports();
   extent.attachReporter(reporter);
   extent.setSystemInfo("QA Engineer", "Aditya Rathi");
	
	}
	
	@Test
	public void intialDemo() {
	
	ExtentTest test = extent.createTest("Intial Demo");
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	System.out.println(driver.getTitle());
	driver.close();
	test.fail("Result do not match");
	
	extent.flush();
	}
}
