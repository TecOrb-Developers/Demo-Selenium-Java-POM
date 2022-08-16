package clientWeb.pageClass;

import java.io.IOException;
import java.util.List;

import clientWeb.base.TestCore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestCore{
	
	@FindBy(name = "email")
	public WebElement userName;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(css = "button[type='submit']")
	public WebElement loginBtn;
	
	@FindBys(
			{
				@FindBy(css = "div[class='widget-title']")
			}
			)
	public List<WebElement> list;
	
	@FindBy(css = "img[src$='jobs_hola_logo.png']")
	public WebElement logo;
	
//------------------------------------------------------------------------	
	
	public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
   }
	
//-------------------------------------------------------------------------	
	
//	public WebElement getUserName() {
//		return userName;
//	}
//
//	public WebElement getPassword() {
//		return password;
//	}
//
//	public WebElement getLoginBtn() {
//		return loginBtn;
//	}
//
//	public WebElement getLogo() {
//		return logo;
//	}
	
	public String getPageTitle()
	{
		String title = driver.getTitle();
		System.out.println("Page title: "+ title);
		return title;
	}
	
	public DashboardPage validLogin() throws IOException
	{
		System.out.println("Login page displaying. Procceding to login....");
		
		System.out.println("enter username");
		userName.click();
		userName.sendKeys("ankesh@tecorb.co");
		
		System.out.println("enter password");
		password.sendKeys("123456");
		
		System.out.println("Click on Login");
		loginBtn.click();
	
		return new DashboardPage(driver);		
		
	}
	
	public void testDemo()
	{
	//	List<WebElement> list = driver.findElements(By.cssSelector("div[class='widget-title']"));
		
		int a = list.size();
		System.out.println(a);
		for (int i = 0; i < a; i++) {
			String text = list.get(i).getText();
			System.out.println(text);
			
		}
	}
}
