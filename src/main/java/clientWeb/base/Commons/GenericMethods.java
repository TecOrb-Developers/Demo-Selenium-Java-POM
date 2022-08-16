package clientWeb.base.Commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {
	
	public static void selectValueFromSearchableDropdown(WebDriver driver , String searchableItem, By by)
	{
		List<WebElement> dropdown = driver.findElements(by);

		int drpdwnItemSize = dropdown.size();
		
		for (int i = 0; i <= drpdwnItemSize-1; i++) {
			
			String populatingText = dropdown.get(i).getText();
			
			if(populatingText.toLowerCase().contains(searchableItem.toLowerCase()))
			{				
				dropdown.get(i).click();
		
				break;
			}
			else if(i==drpdwnItemSize-1)
				
				System.out.println("Item Not Found in list");
			
		}
	}

}
