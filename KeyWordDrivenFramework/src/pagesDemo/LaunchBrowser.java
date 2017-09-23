package pagesDemo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import basicClass.Constants;

public class LaunchBrowser {
	public static WebDriver driver;
	public WebDriver launch_Browser(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(Constants.URL);
		}
		else if(BrowserName.equalsIgnoreCase("IE"))
		{
			File file = new File( System.getProperty("user.dir")+"\\Driver\\IEDriverServer1.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			driver.get(Constants.URL);
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(Constants.URL);
		}
		return driver;
		
	}
	

}
