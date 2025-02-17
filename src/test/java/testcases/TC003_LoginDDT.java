package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.TestBase;
import utilites.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC003_LoginDDT extends TestBase
{

	@Test(dataProvider="TestLogin", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
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
				Thread.sleep(3000);
				
				logger.info("Welcome to My account pAge********************");
				//My Account page
				MyAccountPage ac=new MyAccountPage(driver);
				boolean targetpage = ac.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetpage==true)
				{
					ac.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetpage==true)
				{
					ac.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail();   //"An exception occurred: " + e.getMessage()
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}








