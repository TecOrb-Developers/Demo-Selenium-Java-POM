package clientWeb.pageClass;

import java.util.List;

import clientWeb.base.TestCore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MRRPage extends TestCore{

	@FindBy(css = "h2[class='col-12']")
	public WebElement pageTitle;
	
	@FindBy(xpath = "//h2[contains(text(),'MRR')]")
	public WebElement mrrHeading;
	
	@FindBy(id = "mrr1")
	public WebElement completedTab;
	
	@FindBy(id = "mrr2")
	public WebElement pendingTab;
	
	@FindBy(id = "mrr3")
	public WebElement deniedTab;
	
	@FindBy(css = "p[class='col-12']")
	public WebElement mrrHeadingText;
	
	@FindBys(
			{
				@FindBy(css = "div[class='content-item ']")
			}
			)
	public List<WebElement> mrrListCards;
	
	@FindBy(css = "div[class='content-item  active '] a[href*='/web/clients/dashboard/mrrs/list']")
	public WebElement mrrActiveJobCard;
	
	@FindBy(xpath = "//div[@class='mrr-box']/h2")
	public WebElement mrrDetailsJobtitle;
	
	@FindBy(className = "add_post")
	public WebElement add_MRR;
	
	
//------------------------------------------------------------------------	
		
		public MRRPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	   }
		
//-------------------------------------------------------------------------	
	
		
		public boolean mrrPage()
		{
			return mrrHeading.isDisplayed();
			
		}
		
		public boolean defaultCompletedTabSelected()
		{
			return completedTab.isSelected();
		}
		
		public boolean clickOnMrrCompletedTab()
		{
			return completedTab.isSelected();
		}
		
		public boolean clickOnMrrPendingTab()
		{
			return pendingTab.isSelected();
		}
		
		public boolean clickOnMrrDeniedTab()
		{
			return deniedTab.isSelected();
		}
		
		public int getTotalMRR()
		{
			int totalMRR = mrrListCards.size();
			return totalMRR;		
		}
		
		//MRR Completed
		
		public void getTotalCountOfComplted_MRR()
		{
			
		}
		
		
}
