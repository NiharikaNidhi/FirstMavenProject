package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException  {
		initialization();
		loginPage = new LoginPage();		
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Pag00e","Title does not match");
	}
	
	@Test
	public void loginTest() {
		
		homePage = loginPage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
