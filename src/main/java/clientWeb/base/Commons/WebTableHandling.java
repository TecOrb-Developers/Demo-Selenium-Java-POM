package clientWeb.base.Commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableHandling {

	static int rowCount;
	static int columnCount;
	
		//Finding number of Rows
	public static int tableRowCount(WebDriver driver, List<WebElement> ele)
	{		
	//		List<WebElement> rowsNumber = driver.findElements(by);
	//		rowCount = rowsNumber.size();
			rowCount=ele.size();
			System.out.println("No of rows in this table : "+rowCount);
			return rowCount;
	}
	
		//Finding number of Columns
	public static int tableColumnCount(WebDriver driver, List<WebElement> ele)
	{
		//	List<WebElement> columnsNumber = driver.findElements(by);
		//	columnCount = columnsNumber.size();
			columnCount=ele.size();
			System.out.println("No of columns in this table : "+columnCount);
			return columnCount;
	}
	
		//Get table header
	public void TableHeaderData(WebDriver driver, By by)
	{
		for (int i = 1; i <= columnCount; i++) {
			WebElement tableheader = driver.findElement(By.xpath("//table[@class='table table-striped']/thead/tr/th["+i+"]"));
			String tableheaderdata = tableheader.getText();
			System.out.print(tableheaderdata+"	");
		}
	}
	
		//Get table data
	public void TableData(WebDriver driver, By by)
	{			
		//	String allData="";
			for (int i = 1; i <= rowCount-10; i++) {
				
				System.out.println("Table data of Row ["+i+"] is:");
				
				for (int j = 1; j <= columnCount; j++) {
							
					WebElement alltabledata = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody["+i+"]/tr/td["+j+"]"));
					
					String cellData = alltabledata.getText();
					if(j==1)
						System.out.print(cellData+".	");
					else
					System.out.print(cellData+"	");
					
					if(j==columnCount)
						System.out.println("");
				}
			}
	}
			
	
}
