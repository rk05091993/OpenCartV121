package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_psw;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txt_psw.sendKeys(pwd);
	}
	
	public void clickloginButtton()
	{
		btn_login.click();
	}

}
