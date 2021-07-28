package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

 

public class ContactsPage extends TestBase {
	
	//Page Factory - OR
	
	
	@FindBy(id ="first_name")
    WebElement firstName;
	
	@FindBy(id ="surname")
    WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//select[@class='select' and @size='1' and @name='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save' and @class='button']//parent::td[@colspan='2']//input[@value='Save']")
	WebElement btnSave;
	
	
	
	//initializing the Page Objects
	
		public ContactsPage() {
			PageFactory.initElements(driver,this);
		}
		
	public void createNewContact(String ftName, String ltName, String comp) {

		
		Select select = new Select(driver.findElement(By.xpath("//select[@class='select' and @size='1' and @name='title']")));
		select.selectByVisibleText("Mr.");
		
		//select[@class='select' and @size='1' and @name='title']
		firstName.sendKeys(ftName);

		lastName.sendKeys(ltName);

		company.sendKeys(comp);
	
		btnSave.click();
		
		
	
		
	}
}
