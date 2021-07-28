package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\pratik13961\\eclipse-workspace\\ATOM2\\FreeCRMTest"
					+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}			
	}
	
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:/Users/pratik13961/eclipse-workspace/ATOM2/FreeCRMTest/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browsername.equals("FF")) {
			System.setProperty("webdriver.geckodriver.driver","C:/Users/pratik13961/eclipse-workspace/ATOM2/FreeCRMTest/Drivers/geckodriver.exe");	
			driver =new FirefoxDriver();			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
//		String pageLoadTimeOut = prop.getProperty("PAGE_LOAD_TIMEOUT");
//		int int_PageLoadTimeOut=Integer.parseInt(pageLoadTimeOut);
//		System.out.println("Page Load TimeOut - " +int_PageLoadTimeOut);
//		String implicitWait = prop.getProperty("IMPLICIT_WAIT");
//		long int_ImplicitWait=Integer.parseInt(prop.getProperty(implicitWait));
//		System.out.println("Implicit Wait - " + int_ImplicitWait);
		
		
	}
	
}


