package clientWeb.testScript;

import org.testng.annotations.Test;
import java.io.IOException;

import clientWeb.base.TestCore;
import clientWeb.pageClass.DashboardPage;
import clientWeb.pageClass.LoginPage;

public class DashboardTest extends TestCore{
	
	private LoginPage loginpage;
	private DashboardPage dashboard;

	@Test(priority = 1)
	public void verifyDashboardPageTitle() throws IOException
	{
		loginpage = new LoginPage(driver);
		dashboard=loginpage.validLogin();
		
		System.out.println("Verifying page title!");
		dashboard.getPageTitle();
		System.out.println("Dashboard page verified!");
	}
	
	@Test(dependsOnMethods = "verifyDashboardPageTitle")
	public void verifyActiveJobsList() throws IOException
	{
		loginpage = new LoginPage(driver);
		dashboard=loginpage.validLogin();
		
		System.out.println("Verifying Active jobs count...");
		dashboard.activeTabJobsListCount();
		
	}
	
}

