package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class MajescoHomePage extends TestBase {
	
	//Page Factory - OR
	@FindBy(xpath="//td[@class='headertext' and @align='left']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealslink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement taskslink;
	
	//initializing the Page Objects
	
	public MajescoHomePage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyURL() {
		return driver.getCurrentUrl();
	}
}


