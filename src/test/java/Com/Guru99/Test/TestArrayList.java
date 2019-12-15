package Com.Guru99.Test;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Workspace\\Driver\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		compareList(driver);
		
	}
	
	public static void compareList(WebDriver driver)
	{
		try {
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> alist = new ArrayList<String>();
			ArrayList<String> elist = new ArrayList<String>();
			
			SoftAssert softAssert = new SoftAssert();
			
			int cnt = driver.findElements(By.xpath("//div[@id='content']//tr")).size();
			
			if(cnt>0)
			{
				for(int i = 2;i<=4;i++)
				{
					
					String txt = driver.findElement(By.xpath("//div[@id='content']//tr["+i+"]//th")).getText();
					list.add(txt);
					System.out.println("The Element added to the list1 is "+txt);
					
				}
				System.out.println("Total lsit content is "+list);
				
				for(int j = 2;j<=4;j++)
				{
					
					String txt = driver.findElement(By.xpath("//div[@id='content']//tr["+j+"]//th")).getText();
					alist.add(txt);
					System.out.println("The Element added to the list2 is "+txt);
					
				}
				System.out.println("Total lsit content is "+alist);
				
				for(int k = 0;k<=2;k++)
				{
					System.out.println(list.get(k));
					System.out.println(alist.get(k));
					if(list.get(k).equalsIgnoreCase(alist.get(k).toString())) {
						elist.add("The Expected and actual list are equal and the name is "+list.get(k));
					}
				}
				System.out.println("Matched list are "+elist);
			}
			
			
			
			
		}
		catch(Exception e)
		{
			
		}
	}

}
