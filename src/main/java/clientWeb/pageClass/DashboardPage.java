package clientWeb.pageClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import clientWeb.base.TestCore;
import clientWeb.base.Commons.WebTableHandling;

public class DashboardPage extends TestCore{

	@FindBy(xpath = "//h2[text()=' Dashboard']")
	public WebElement pageTitle;
	
	@FindBy(css = "a[title='MRR']")
	public WebElement navigationLink_MRR;
	
	@FindBy(css = "img[src$='jobs_hola_logo.png']")
	public WebElement logo;
	
	@FindBys(
			{
				@FindBy(css = "table[class='table table-striped'] a[href*='/web/clients/job/profile/']")
			}
			)
	public List<WebElement> activeTabJobsList;
	
	@FindBy(xpath = "//a[@id='tab-A']/span")
	public WebElement activeTabCount;
	
	@FindBy(xpath = "//a[@id='tab-B']/span")
	public WebElement archiveTabCount;
	
	@FindBys(
			{	@FindBy(xpath = "//table[@class=\"table table-striped\"]/tbody/tr")	}
			)
	public List<WebElement> jobListTableRow;
	
	
	
//------------------------------------------------------------------------	
	
	public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
   }
	
//-------------------------------------------------------------------------	
	
	public WebElement getLogo() {
		return logo;
	}
	
	public String getPageTitle()
	{
		String title = driver.getTitle();
		System.out.println("Page title: "+ title);
		return title;
	}
	
	public MRRPage clickOnNavTab_MRR()
	{
		System.out.println("Dashboard displaying!");
		navigationLink_MRR.click();
		return new MRRPage(driver);
	}
	
	public int activeTabJobsListCount()
	{
		int allactivetabjobs = activeTabJobsList.size();
		System.out.println("Total number of Active tab jobs: "+ allactivetabjobs);
		return allactivetabjobs;
	}
	
	public int activeTabCount()
	{
		String count = activeTabCount.getText();
		System.out.println("Active tab count: "+count);
		int activeCount = Integer.parseInt(count);
		return activeCount;
	}
	
	public int archiveTabCount()
	{
		String count = archiveTabCount.getText();
		System.out.println("Archive tab count: "+count);
		int archiveCount = Integer.parseInt(count);
		return archiveCount;
	}
	
	public int archiveOnHoldJobsListCount()
	{
		int archiveOnHoldCount = WebTableHandling.tableRowCount(driver, jobListTableRow);
		System.out.println("Total Archive OnHold Jobs: "+archiveOnHoldCount);
		return archiveOnHoldCount;
	}
	
	public int archiveClosedJobsListCount()
	{
		int archiveClosedCount = WebTableHandling.tableRowCount(driver, jobListTableRow);
		System.out.println("Total Archive Closed Jobs: "+archiveClosedCount);
		return archiveClosedCount;
	}
	
	public int archiveSuccessJobsListCount()
	{
		int archiveSuccessCount = WebTableHandling.tableRowCount(driver, jobListTableRow);
		System.out.println("Total Archive Success Jobs: "+archiveSuccessCount);
		return archiveSuccessCount;
	}
	
	public void archiveOnHoldTableHeader()
	{
		
	}
	
}
