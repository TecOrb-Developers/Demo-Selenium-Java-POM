package clientWeb.testScript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import clientWeb.base.TestCore;
import clientWeb.pageClass.DashboardPage;
import clientWeb.pageClass.LoginPage;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPageTest extends TestCore {
	
	LoginPage loginpage;
	
//	@Test
	@Test(dependsOnMethods = "verifyLoginpageLaunching")
	public void validLogin() throws IOException
	{
		System.out.println("Verifing valid login test");
		loginpage = new LoginPage(driver);
		loginpage.validLogin();
		
		System.out.println("Verifing Dashboard displaying...");
		DashboardPage dashboardpage = new DashboardPage(driver);
		String exp_title = "Jobshola | Web Client";
		String act_title = dashboardpage.getPageTitle();
		
		Assert.assertTrue( dashboardpage.logo.isDisplayed(),"Logo is not displayed");	
		AssertJUnit.assertEquals(act_title, exp_title, "Page title not correct");
		
		Reporter.log("Login success and Homepage displayed! :)",true);		
		
	}
	
	@Test(priority = 1)
	public void verifyLoginpageLaunching()
	{
		loginpage = new LoginPage(driver);
		System.out.println("Getting URL and verifying loginpage!");
		String exp_title = "Jobshola | Web Client";
		String act_title = loginpage.getPageTitle();
		
		Assert.assertTrue( loginpage.logo.isDisplayed(),"Logo is not displayed");	
		Assert.assertEquals(act_title, exp_title, "Page title not correct");
		
		Reporter.log("URL launch success and Loginpage displayed! :)",true);		
		
	}
	
	
	
	
	
	
	
//*************************************************************************************	
	
//	@Test
	public void demoTest()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.testDemo();		
		System.out.println("demo test pass !!!");
		
	}
	
	
}
