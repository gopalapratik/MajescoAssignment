package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();     // TestBase Consructor and properties initialization
	}

	@BeforeMethod
	
	public void setUp() {
		initialization();   //Driver and chrome initialized
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage() ;
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Home Page Title not matched");		
	}

	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.correctVerifyUserName());
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	
	public void TestDown() {
		//driver.quit();
	}
}
