package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory  OR

		
		
		@FindBy (xpath="//input[@name='q']")
		WebElement inputSearchBox;
		
		@FindBy (xpath="//input[@value='Google Search']")
		WebElement btnSearchBox;
		
	
		
		//Initializing the Page-Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
			
		}

		//Actions
		public String validateHomePageTitle() {
			return driver.getTitle();	
		}
		
		public SearchedWebPage searchBox(String text) {
			inputSearchBox.sendKeys(text);
			btnSearchBox.click();
			return new SearchedWebPage();
		}
		
	
}
