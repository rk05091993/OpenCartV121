package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.BasePage;
import pageobjects.HomePage;
import testbase.TestBase;

public class TC001_AccountRegistrationTest extends TestBase {
	

	@Test(groups= {"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("Test Case001_ Started************************");
		try 
		{
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clickMyAccount is happened");
		
		hp.clickRegister();
		
		logger.info("click register happened");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Credential is added..................................");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		
		String confmsg=regpage.getConfirmationMsg();
		if
		(confmsg.equals("Your Account Has Been Created!"))
		{ 
		
	          Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed:");
			logger.debug("Debug logs:");
			Assert.assertTrue(false);
		}}
		
		
		
		catch (Exception e) {
			
			Assert.fail();
		}
		
		
		  logger.info("Test case finished********************");
		
	
	

}}
