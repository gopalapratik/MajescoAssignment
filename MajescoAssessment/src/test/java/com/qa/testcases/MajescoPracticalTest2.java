package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.MajescoHomePage;
import com.qa.pages.SearchedWebPage;
import com.qa.pages.HomePage;

public class MajescoPracticalTest2 extends TestBase {

	HomePage homePage;
	SearchedWebPage searchedWebPage;
	MajescoHomePage majescoHomePage;
	String title;

	public MajescoPracticalTest2() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		searchedWebPage = new SearchedWebPage();
		majescoHomePage = new MajescoHomePage();
	}

	@Test(priority = 1)
	public void validateAboutMajescoLinkText() {
		Assert.assertEquals(homePage.validateHomePageTitle(), "Google");
		homePage.searchBox("Majesco");
		Assert.assertEquals(searchedWebPage.validateHomePageTitle(), "Majesco - Google Search");
		Assert.assertEquals(searchedWebPage.validateAboutMajescoLink(),true);
		searchedWebPage.clickOnAboutMajesco();
		Assert.assertEquals(majescoHomePage.verifyHomePageTitle(), "Insurance Software Companies | Next-Gen Insurance Software");
		Assert.assertEquals(majescoHomePage.verifyURL(),"https://www.majesco.com/about-us/");
	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

}
