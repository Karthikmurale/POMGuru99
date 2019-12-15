package Com.Guru99.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tableTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Workspace\\Concepts\\Driver1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		System.out.println("Web site is opened...");
//		tableCalc(driver);
//		selectOption(driver,"Handle Exceptions");
//		selectOption(driver,"Learn Locators");
//		selectOption(driver,"Learn to interact with Elements");
		checkRadio(driver,"EMAIL=karthikmurale@gmail.com#APPEND=123.com#TEXTENTERED=karthik#CLEARTEXT=cleared");
		
		System.out.println("Completed----------------------");
	}
	
	
	public static void tableCalc(WebDriver driver)
	{
		int rowcnt = driver.findElements(By.xpath("//div[@id='contentblock']//tbody/tr")).size();
		int colcnt = driver.findElements(By.xpath("//div[@id='contentblock']//tbody/tr/th")).size();
		if(rowcnt>0)
		{
			for(int i=2;i<=rowcnt;i++)
			{
				for(int j=1;j<colcnt;j++)
				{
					System.out.println(driver.findElement(By.xpath("//div[@id='contentblock']//tbody/tr["+i+"]/td["+j+"]")).getText());
				}
				
			}
		}
	}
	
	public static void selectOption(WebDriver driver, String cText)
	{
		int rowcnt = driver.findElements(By.xpath("//div[@id='contentblock']//tbody/tr")).size();
		int colcnt = driver.findElements(By.xpath("//div[@id='contentblock']//tbody/tr/th")).size();
		if(rowcnt>0)
		{
			for(int i=2;i<=rowcnt;i++)
			{
				for(int j=1;j<colcnt;j++)
				{
					String text = driver.findElement(By.xpath("//div[@id='contentblock']//tbody/tr["+i+"]/td[1]")).getText();
					if(text.equalsIgnoreCase(cText))
					{
						driver.findElement(By.xpath("//div[@id='contentblock']//tbody/tr["+i+"]/td[3]/input")).click();
					}
				}
				
			}
		}
	}
	
	public static void checkRadio(WebDriver driver,String data)
	{
		HashMap<String, String> map = textData(data);
		if(!map.isEmpty())
		{
			Set<String> keys = map.keySet();
			for(String value:keys)
			{
				switch(value)
				{
				case "EMAIL" :
					driver.findElement(By.xpath("//input[@id='email']")).clear();
					driver.findElement(By.xpath("//input[@id='email']")).sendKeys(map.get(value).trim());
					break;
				
				case "APPEND" :
					driver.findElement(By.xpath("//input[@value='Append ']")).clear();
					driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(map.get(value).trim());
					break;
					
				case "TEXTENTERED" :
					driver.findElement(By.xpath("//input[@value='TestLeaf']")).clear();
					driver.findElement(By.xpath("//input[@value='TestLeaf']")).sendKeys(map.get(value).trim());
					break;
					
				case "CLEARTEXT" :
					driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
					driver.findElement(By.xpath("//input[@value='Clear me!!']")).sendKeys(map.get(value).trim());
					break;
					
				}
			}
		}
		else
		{
			System.out.println("Map is Empty");
		}
	}
	
	public static HashMap<String, String> textData(String data)
	{
		String[] mData = data.split("#");
		HashMap<String,String> hmap = new HashMap<String,String>();
		for(int i=0; i<mData.length; i++)
		{
			String[] cData = mData[i].split("=");
			hmap.put(cData[0], cData[1]);
		}
		
		return hmap;
	}

}
