package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;

public class TestBase 
{
   public static WebDriver driver;
   public static Properties prop;
   public static String currentDir;

public TestBase() throws IOException
{
	try {
		currentDir = System.getProperty("user.dir");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(currentDir +"//configuration//config.Properties");
		prop.load(fis);
	}
	catch(FileNotFoundException e)
	{
	  System.out.println("Exception occured :"+e.getMessage());
	}
	catch(IOException e)
	{
	  System.out.println("Exception occured :"+e.getMessage());
	}
	catch(Exception e) 
	{
	  e.printStackTrace();	
	}
}
public static void initialization() {
	
	String browser=prop.getProperty("browser");
//	System.out.println(browser);
	if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", currentDir + "//Drivers//chromedriver.exe");
//		System.out.println(browser);
		driver = new ChromeDriver();
	}else if(browser.equals("gecko")) {
		//System.setProperty("webdriver.gecko.driver", currentDir + "//Drivers//geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
}
}
