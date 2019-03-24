package Com.ReusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReusableMethods {

	public static Properties prop;
	
	public static String getPropertyValue(String value) throws IOException
	{
		try{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+File.separator+"Config"+File.separator+"Config.Properties");
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("The Exception occured in Property file is "+e);
		}
		return prop.getProperty(value);
	}
}
