package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
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
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return  new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() {
		taskslink.click();
		return new DealsPage();
	}

	public boolean correctVerifyUserName() {
		return userNameLabel.isDisplayed();
	}
    
	public void clickONNewContactLink() {
		Actions builder = new Actions(driver);
		Action action = builder.moveToElement(contactsLink).build();
		action.perform();
		newContactLink.click();
	}
}


