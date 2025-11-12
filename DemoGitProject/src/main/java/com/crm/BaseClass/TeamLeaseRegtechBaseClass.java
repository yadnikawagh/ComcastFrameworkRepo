package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.ReadFromProperties;
import com.crm.Pom.HomePagePom;
import com.crm.Pom.LoginPagePom;


public class TeamLeaseRegtechBaseClass {
	public static WebDriver driver=null;
	@BeforeClass
	public void openBrowser() throws IOException, InterruptedException {
		String browser = ReadFromProperties.readProperty("browser");
		String url = ReadFromProperties.readProperty("url");
		if(browser.equalsIgnoreCase("chrome")) {
	        driver=new ChromeDriver();
	  }
		else if (browser.equalsIgnoreCase("firefox")) {
			  driver=new FirefoxDriver();	
		}
		else if (browser.equalsIgnoreCase("edge")) {
			 driver=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("internetExplorer")) {
		     driver=new InternetExplorerDriver();	
		}
		else if (browser.equalsIgnoreCase("safari")) {
			 driver=new SafariDriver();
		}
		else {
		    driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		Thread.sleep(2000);
	}
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		String username = ReadFromProperties.readProperty("username");
		String password = ReadFromProperties.readProperty("password");
		String ans1 = ReadFromProperties.readProperty("answer1");
		String ans2 = ReadFromProperties.readProperty("answer2");
		
		LoginPagePom login=new LoginPagePom(driver);
		login.username(username);
		login.password(password);
		login.signIn();
		login.skipOtp();
		login.answer1(ans1);
		login.answer2(ans2);
		login.validate_Button();
		login.contract_Button();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		HomePagePom home = new HomePagePom(driver);
		home.profile_icon();
		home.logout();
		Thread.sleep(2000);
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
