package clientWeb.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCore 
{
	public static WebDriver driver; 
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("targetBrowser")
	
	public void setup(String targetBrowser) {
		if(targetBrowser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(targetBrowser.toLowerCase().contains("chrome")){
			WebDriverManager.chromedriver().setup();		
			driver = new ChromeDriver();
			driver.manage().window().maximize();		
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();	
		}
			
	//	Launch URL

		driver.get("https://www.devjobshola.com/web/clients/login");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		String scriptName = result.getMethod().getMethodName();
		if(result.isSuccess())
		{
			Reporter.log(scriptName+" is passed :)",true);
		}
		else
		{
			GetScreenshot screenshot = new GetScreenshot(driver);
			screenshot.getScreenshot(scriptName);
			Reporter.log("Failed script: "+scriptName+"\n"+"Screenshot has been taken", true);
		}
		
		driver.close();
	}
	
	public WebElement getElement(By by)
	{
		 return driver.findElement(by);		
	}
				
}
