package factory;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataprovider.ConfigDataProvider;

public class TestBase {

	public WebDriver driver;
	ConfigDataProvider CDP = new ConfigDataProvider();

	public void init(){
		
		
		getBrowser(CDP.getBrowser());

	}

	public WebDriver getBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("firefox"))
		{	
			driver = new FirefoxDriver();
			return driver;
		}

		else if(browsername.equalsIgnoreCase("Chrome"))
		{

			System.setProperty("webdriver.chrome.driver",CDP.getchromePath()); 
			driver = new ChromeDriver();
			driver.get(CDP.getApplicationURL());
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			return driver;
		}

		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",CDP.getIEPath()); 
			driver = new InternetExplorerDriver();
			driver.get(CDP.getApplicationURL());
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			return driver;
		}
		return null;

	}

	public void closebrowser()
	{
		driver.close();
	}

	public void Waitfor(int secs) throws InterruptedException{
		Thread.sleep(secs*1000);
	}
}
