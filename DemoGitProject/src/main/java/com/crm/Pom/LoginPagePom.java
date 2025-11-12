package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePom {
	public LoginPagePom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}
		
	@FindBy(xpath = "//input[@id='txtemail']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='txtpass']")
	private WebElement password;
	
	@FindBy(xpath ="//input[@id='Submit']")
	private WebElement signIn_Button;
	
	@FindBy(linkText = "Do not have access to OTP?")
	private WebElement skipOtp_Button;
	
	@FindBy(xpath = "//input[@id='txtAnswer1']")
	private WebElement ans1; 
	
	@FindBy(xpath = "//input[@id='txtAnswar2']")
	private WebElement ans2; 
	
	@FindBy(xpath = "//input[@id='btnValidateQuestions']")
	private WebElement validate;
	
	@FindBy(xpath = "//span[text()='Contract']")
	private WebElement contract;
	
	public void username(String data) {
		username.sendKeys(data);
	}
	public void password(String data)
	{
		password.sendKeys(data);
	}
	public void signIn()
	{
		signIn_Button.click();
	}
	public void skipOtp()
	{
		skipOtp_Button.click();
	}
	public void answer1(String data)
	{
		ans1.sendKeys(data);;
	}
	public void answer2(String data)
	{
		ans2.sendKeys(data);;
	}
	public void validate_Button()
	{
		validate.click();
	}
	public void contract_Button()
	{
		contract.click();
	}
}
