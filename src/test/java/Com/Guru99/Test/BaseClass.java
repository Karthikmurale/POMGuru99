package Com.Guru99.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Com.ReusableMethods.ReusableMethods;


public class BaseClass {
	
	public static WebDriver driver;
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports Extent;
	public static ExtentTest test;
	public static Logger logger;
	
	public static void eReport(String Status,String Details)
	{
		try
		{
			if(Status.equalsIgnoreCase("PASS"))
			{
				test.log(com.aventstack.extentreports.Status.PASS, Details +test.addScreenCaptureFromPath(takeSnap()));
			}
			else if(Status.equalsIgnoreCase("FAIL"))
			{
				test.log(com.aventstack.extentreports.Status.FAIL, Details +test.addScreenCaptureFromPath(takeSnap()));
			}
			else if(Status.equalsIgnoreCase("INFO"))
			{
				test.log(com.aventstack.extentreports.Status.INFO, Details +test.addScreenCaptureFromPath(takeSnap()));
			}
	}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
		}
	}
	
	public static String takeSnap() throws IOException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");  
	    Date date = new Date(); 
	    String datevar = formatter.format(date);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"TC"+datevar+".png"));
		String dest = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"TC"+datevar+".png";
		return dest; 
	}
	
	@BeforeTest
	public void initBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Workspace\\Concepts\\Driver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ReusableMethods.getPropertyValue("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public static void setup() throws Exception
	{
		try
		{
		String path = System.getProperty("user.dir")+File.separator+"ExtentReport"+File.separator+"ExtentRep.html";
		reporter = new ExtentHtmlReporter(path);
		Extent = new ExtentReports();
		Extent.attachReporter(reporter);
		logger = Logger.getLogger("Guru99 Logs");
		PropertyConfigurator.configure("E:\\Selenium Workspace\\Concepts\\log4j.properties");
		}
		
		catch(Exception e)
		{
			System.out.println("The Exception occured is "+e);
		}
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		Extent.flush();
	}
	
	@AfterTest
	public void wrapit()
	{
		driver.quit();
	}

}
