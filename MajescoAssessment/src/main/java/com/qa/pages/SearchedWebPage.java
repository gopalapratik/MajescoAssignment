package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.TestBase;

 

public class SearchedWebPage extends TestBase {
	
	//Page Factory - OR
	
	@FindBy(xpath="//a[text()='About Majesco']")
	WebElement linkAboutMajesco;
	
	
	
	//initializing the Page Objects
	
		public SearchedWebPage() {
			PageFactory.initElements(driver,this);
		}
		
		
		public String validateHomePageTitle() {
			return driver.getTitle();
		}
		
		
	public boolean validateAboutMajescoLink() {
		return linkAboutMajesco.isDisplayed();
	}
	
	public MajescoHomePage clickOnAboutMajesco() {
		linkAboutMajesco.click();
		return new MajescoHomePage();
	}


	
	
	
}
