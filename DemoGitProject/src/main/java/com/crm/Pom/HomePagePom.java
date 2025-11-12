package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePagePom {
	public HomePagePom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}

	@FindBy(xpath = "//span[text()='Sandeep Agrawal']")
	private WebElement profile_icon;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOut;
	
	@FindBy(xpath = "//span[text()='Status']")
	private WebElement status;
	
	@FindBy(xpath = "//input[@value='Apply']")
	private WebElement apply;
	
	@FindBy(xpath = "(//div[@class='highcharts-container '])[4]")
	private WebElement draftChart;

	@FindBy(xpath = "//span[text()='My Reports']")
	private WebElement myReports;

	@FindBy(xpath = "//span[text()='Status']")
	private WebElement myReportsStatus;
	
	@FindBy(xpath = "//span[text()='1 - 10 of 808 items']")
	private WebElement myReportsItems;
	
			
	public void profile_icon() {
		profile_icon.click();
	}
	public void logout() {
		logOut.click();
	}
	public void status_Button() {
		status.click();
	}
	public void apply_Button() {
		apply.click();
	}
	public String chartCount()
	{
		return draftChart.getText();
	}
	public void myReports_Button()
	{
		myReports.click();;
	}
	public void myReportsStatus_Button()
	{
		myReportsStatus.click();
		Select sel = new Select(myReportsStatus);
		sel.selectByVisibleText("Draft");
	}
	public String items()
	{
		return myReportsItems.getText();
	}
}
