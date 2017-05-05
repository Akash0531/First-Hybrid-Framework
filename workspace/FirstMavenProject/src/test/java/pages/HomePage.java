package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage {

	
	
	WebDriver driver;
	
	@Test
	public HomePage(WebDriver ldriver)
	
	{
		this.driver= ldriver;
	}
    
	@FindBy(xpath= "//a[text()='Log on']") WebElement logonlink;
	@FindBy(xpath= "//a[text()='Register']") WebElement registerlink;
	@FindBy(xpath= "//a[text()='Wishlist]") WebElement wishlistlink;
	@FindBy(xpath= "//a[text()='Shopping cart']") WebElement shoppingcartlink;
	
	public void clickonLogon()
	{
		logonlink.click();
	}

	public void clickonRegister()
	{
		registerlink.click();
	}
	
	public void clickonWishlist()
	{
		wishlistlink.click();
	}
	
	public void clickonShoppingcart()
	{
		shoppingcartlink.click();
	}
	
	public String verifyAppTitle()
	{
		return driver.getTitle();
	}
	
	public void closeBrowser()
	{
	  driver.close();	
	}
}
