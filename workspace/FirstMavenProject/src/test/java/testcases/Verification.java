package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utility.ScreenshotLibrary;

public class Verification extends TestBase{
    
	ExtentReports report;
	ExtentTest logger;
    
	
	@BeforeTest	
	public void verifyhomepage()
	{  
		
		report = new ExtentReports(".\\Reports\\FirstReport.html",true);
		logger= report.startTest("TestPageTitle");
		init();
		
	}

	@Test(priority=0)
	public void VerifyPageTitle() throws Exception
	{   
		
	
		HomePage HM = PageFactory.initElements(driver, HomePage.class);
		logger.log(LogStatus.INFO,  "Page Located");
		logger.log(LogStatus.PASS, "Titledisplayed", logger.addScreenCapture(ScreenshotLibrary.screenshotcapture(driver, "TitleFirstScreenshot")));
        String Title = HM.verifyAppTitle();
        Assert.assertTrue(Title.contains("E-commerce site - Home"));
        logger.log(LogStatus.PASS, "Title Verified");
        ScreenshotLibrary.screenshotcapture(driver, "Title");
        Waitfor(4);
	
	}
	
	@Test(priority=1)
	public void HomePage() throws Exception
	{
		HomePage HM = PageFactory.initElements(driver, HomePage.class);
        HM.clickonLogon();
        logger.log(LogStatus.INFO, "Clicked on Logon");
		LoginPage Logon = PageFactory.initElements(driver, LoginPage.class);
		Logon.Enterusername("vikash.chourasiya0631@gmail.com", "vikash.chourasiya0631@gmail.com");	
		ScreenshotLibrary.screenshotcapture(driver, "Login");
        Logon.LogoutVerification();
		ScreenshotLibrary.screenshotcapture(driver, "Logout");

	}
	
	@Test(priority=2)
	public void Buttonverification()
	{
		
	}
	    
	
	 
	@AfterMethod
	public void Faliure(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		  String Screenshot_Path= ScreenshotLibrary.screenshotcapture(driver, result.getName());
		  String Image = logger.addScreenCapture(Screenshot_Path);
		  logger.log(LogStatus.FAIL, "Title Verification failed", Image);
		}
			
		report.endTest(logger);
		report.flush();
		
	}
	
	
	@AfterTest
    public void Browserclose()
    {
    	closebrowser();
    }
}
