package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.TestBase;

public class TC002_LoginTest extends TestBase  {
	
	@Test(groups= {"Sanity","Master"})
	public void verifyLogin()
	{
		logger.info("Starting TC002LoginTest*************************");
		//Home page
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		
		  //Login Page
		LoginPage lp1=new LoginPage(driver);
		lp1.setEmail(p.getProperty("email"));
		lp1.setPassword(p.getProperty("password"));
		lp1.clickloginButtton();
		
		logger.info("Welcome to My account pAge********************");
		//My Account page
		MyAccountPage ac=new MyAccountPage(driver);
		boolean targetpage = ac.isMyAccountPageExists();
		//Assert.assertEquals(targetpage, true,"Login failed");
		Assert.assertTrue(targetpage);
	
		
		
	} catch(Exception e)
		{
		Assert.fail();
		}
	
	
		logger.info("Fineshed the Test case**************************");
}}
