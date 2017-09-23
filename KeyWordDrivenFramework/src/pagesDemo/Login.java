package pagesDemo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import basicClass.Constants;

public class Login extends LaunchBrowser {
	
	//Initialization of WebElements
	@FindBy(linkText = "SIGN-ON")
	WebElement SignON;
	@FindBy(name = "userName")
	WebElement UserName;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(name = "login")
	WebElement Submit;
	@FindBy(name = "tripType")
	WebElement Type;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public   WebElement WaitExplicit(WebDriver driver,long Time,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Time);
		
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public  void Click_SignON()
	{
		WaitExplicit(driver, 25, SignON);
		SignON.click();
	}
	public void Set_LoginUserName(String USerNameValue)
	{
		WaitExplicit(driver, 25, UserName);
		UserName.sendKeys(USerNameValue);
	}
	public void Set_LoginPassword(String PasswordValue)
	{
		WaitExplicit(driver, 25, Password);
		Password.sendKeys(PasswordValue);
	}
	public void Click_Submit()
	{
		WaitExplicit(driver, 25, Submit);
		Submit.click();
	}
	public boolean Val_login()
	{
		WaitExplicit(driver, 25, Type);
		boolean B = Type.isDisplayed();
		return B;
	}
	public void Close_browser()
	{
		driver.quit();
	
	}
	
	
	
}
