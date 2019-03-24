package Com.Guru99.Test;


import java.io.IOException;
 import org.testng.Assert;
import org.testng.annotations.Test;
import com.PageObjects.loginScreen;
import Com.ReusableMethods.ReusableMethods;


public class TC1_LoginTest extends BaseClass {
	
	@Test
	public void loginCheck() throws IOException
	{
		test = Extent.createTest("TC1_LoginTest");
		logger.info("Web Page Launched Successfully !!!!!!!!!");
		loginScreen ls = new loginScreen(driver);
		ls.uidEnterText(ReusableMethods.getPropertyValue("UserID"));
		eReport("Pass", "Username Entered Successfully...");
		logger.info("Username Entered Successfully...");
		ls.passEnterText(ReusableMethods.getPropertyValue("Password"));
		eReport("Pass", "Password Entered Successfully...");
		logger.info("Password Entered Successfully...");
		ls.loginClick();
		eReport("Pass", "Login clicked Successfully...");
		logger.info("Login clicked Successfully...");
		
		if(driver.getTitle().contains("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			eReport("Pass", "Title has been validated Successfully!!!");
			logger.info("Title has been validated Successfully!!!");
		}
		else
		{
			Assert.assertTrue(false);
			eReport("FAIL", "Title is not displayed as Expected");
			logger.info("Title is not displayed as Expected");
		}
	}

}
