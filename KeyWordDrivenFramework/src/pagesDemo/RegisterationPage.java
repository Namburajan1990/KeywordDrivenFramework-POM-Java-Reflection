package pagesDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RegisterationPage extends LaunchBrowser{
	
	
	//Initialization of WebElements
	@FindBy(linkText = "REGISTER")
	WebElement RegisterationLink;
	@FindBy(name = "firstName")
	WebElement FirstName;
	@FindBy(name = "lastName")
	WebElement LastName;
	@FindBy(name = "phone")
	WebElement PhoneNumber;
	@FindBy(id = "userName")
	WebElement Email;
	@FindBy(name = "address1")
	WebElement AddressLine1;
	@FindBy(name = "address2")
	WebElement AddressLine2;
	@FindBy(name = "city")
	WebElement City;
	@FindBy(name = "state")
	WebElement State;
	@FindBy(name = "postalCode")
	WebElement PostalCode;
	@FindBy(name = "country")
	WebElement Country;
	@FindBy(name = "email")
	WebElement UserName;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(name = "confirmPassword")
	WebElement ConfirmPassword;
	@FindBy(name = "register")
	WebElement Submit;
	
//PageFactory initialization is Mandate
	public RegisterationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public   WebElement WaitExplicit(WebDriver driver,long Time,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Time);
		
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void ClickRegisteration()
	{
		WaitExplicit(driver, 25, RegisterationLink);
		RegisterationLink.click();
	}
	public void ClickSubmit()
	{
		WaitExplicit(driver, 25, Submit);
		Submit.click();
	}
	public void Set_UserName(String UserNameValue)
	{
		WaitExplicit(driver, 25, UserName);
		UserName.sendKeys(UserNameValue);
	}
	public void ImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	public void Set_Password(String PasswordValue)
	{
		WaitExplicit(driver, 25, Password);
		Password.sendKeys(PasswordValue);
	}
	public void Set_ConfirmPassword(String ConfirmPasswordValue)
	{
		WaitExplicit(driver, 25, ConfirmPassword);
		ConfirmPassword.sendKeys(ConfirmPasswordValue);
	}
	public void Set_FirstName(String FirstNameval)
	{
		WaitExplicit(driver, 25, FirstName);
		FirstName.sendKeys(FirstNameval);
	}
	public void Set_LastName(String LastNameval)
	{
		WaitExplicit(driver, 25, LastName);
		LastName.sendKeys(LastNameval);
	}
	public void Set_Phone(String Phoneval)
	{
		WaitExplicit(driver, 25, PhoneNumber);
		PhoneNumber.sendKeys(Phoneval);
	}
	public void Set_Email(String Emailval)
	{
		WaitExplicit(driver, 25, Email);
		Email.sendKeys(Emailval);
	}
	public void Set_Address1(String Address1val)
	{
		WaitExplicit(driver, 25, AddressLine1);
		AddressLine1.sendKeys(Address1val);
	}
	public void Set_Address2(String Address2val)
	{
		WaitExplicit(driver, 25, AddressLine2);
		AddressLine2.sendKeys(Address2val);
	}
	public void Set_City(String Cityvalue)
	{
		WaitExplicit(driver, 25, City);
		City.sendKeys(Cityvalue);
	}
	public void Set_State(String Statevalue)
	{
		WaitExplicit(driver, 25, State);
		State.sendKeys(Statevalue);
	}
	public void Set_PostalCode(String PostalCodeValue)
	{
		WaitExplicit(driver, 25, PostalCode);
		PostalCode.sendKeys(PostalCodeValue);
	}
	public void Set_Country(String Countryvalues)
	{
		WaitExplicit(driver, 25, Country);
		Select CountrySel = new Select(Country);
		CountrySel.selectByVisibleText(Countryvalues);
	}


}
