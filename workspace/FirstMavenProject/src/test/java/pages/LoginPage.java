package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {


	WebDriver driver;
	
	@Test
	public LoginPage(WebDriver ldriver)
	
	{
		this.driver= ldriver;
	}
    
	@FindBy(xpath= "//input[@maxlength='100']") WebElement Username;
	@FindBy(xpath= "//input[@maxlength='110']") WebElement Password;
	@FindBy(xpath= "//input[@value='Log on']") WebElement Logon;
	@FindBy(xpath= "//a[@class='signoutLink']") WebElement Logoutlink;
	By Logout = By.xpath("//a[@class='signoutLink']");
    
    public void Enterusername(String user, String pass) 
    {
  	Username.sendKeys(user);
  	Password.sendKeys(pass);
  	Logon.click();
  	
    }
    
    public void LogoutVerification()
    {
      WebDriverWait wait = new WebDriverWait(driver, 20);
      WebElement copy=  wait.until(ExpectedConditions.presenceOfElementLocated(Logout));
      String Text =copy.getText();
      Assert.assertEquals(Text, "Log out", "Log out link is not verified");
      Logoutlink.click();
      wait = new WebDriverWait(driver, 5);
    }

}
