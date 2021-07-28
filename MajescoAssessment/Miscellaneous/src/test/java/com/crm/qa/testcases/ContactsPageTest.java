package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@DataProvider
	
	public  Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName); 
		return data;
			 
	}
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String FirstName, String LastName, String Company) {

		homePage.clickONNewContactLink();
		//contactsPage.createNewContact("Tom", "Peter", "Google");
		contactsPage.createNewContact(FirstName, LastName, Company);
		homePage.clickOnContactsLink();
		
	}

}
