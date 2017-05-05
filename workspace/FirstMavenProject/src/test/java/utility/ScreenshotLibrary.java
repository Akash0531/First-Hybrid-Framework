package utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotLibrary {
	
	
	public static String screenshotcapture(WebDriver driver, String screenshot)
	{

		try {
			TakesScreenshot TS = (TakesScreenshot)driver;
			File Source = TS.getScreenshotAs(OutputType.FILE);
			String Dest="C:\\Users\\Akash\\workspace\\FirstMavenProject\\Screenshot"+screenshot+".png";
			File Destination= new File(Dest);
			FileUtils.copyFile(Source, Destination );
			System.out.println("Screenshot has been captured");
			return Dest;
		    } 
		catch (Exception e)   
		{
		    System.out.println("Exception while taking screenshot"+e.getMessage());
		    return e.getMessage();
		}
	    	
}}
