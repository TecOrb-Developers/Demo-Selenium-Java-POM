package clientWeb.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {

WebDriver driver;
	
	public GetScreenshot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void getScreenshot(String scriptname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destFile= new File("./screenshots/"+scriptname+".png");
		
		try
		{
			FileUtils.copyFile(srcfile, destFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
