package TLRegtechTestScript;


import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.BaseClass.TeamLeaseRegtechBaseClass;
import com.crm.Pom.HomePagePom;
import com.crm.SeleniumUtility.MouseAndKeyboard;
@Listeners(com.crm.Listeners.ListenerWithScreenshot.class)
public class TestScript extends TeamLeaseRegtechBaseClass{

	int num=10;
	@Test(priority = 1)
	public void profileCheck() {
		try {
			driver.findElement(By.xpath("//span[text()='Sandeep Agrawal']"));
			Reporter.log("I am in Sandeep Agrawal's profile",true);
			
		} catch (Exception e) {
			Reporter.log("i am not present in Sandeep Agrawal's profile",true);
			fail();
		}
		
	}
	@Test(priority = 2)
	public void verifyDraftCount() throws InterruptedException
	{
		Thread.sleep(2000);
		HomePagePom home = new HomePagePom(driver);
		home.status_Button();
		home.apply_Button();
		Thread.sleep(1000);		
		Actions act = new Actions(driver);
		act.keyDown(Keys.ARROW_DOWN).perform();
		act.keyDown(Keys.ARROW_DOWN).perform();
		act.keyDown(Keys.ARROW_DOWN).perform();
		act.keyDown(Keys.ARROW_DOWN).perform();
		String expectedResult = home.chartCount();
		Reporter.log("Draft Count from Chart:"+expectedResult, true);
		Thread.sleep(2000);
		
		String actualResult = home.items();
		Reporter.log("Draft Count from MyReports:"+actualResult, true);
		// Result
	    try {
	        assertTrue(expectedResult.equalsIgnoreCase(actualResult),"chart count and report count are not Matching");
	        Reporter.log("The chart count matching with the report count.", true);
	    } catch (AssertionError e) {
	        Reporter.log("Chart Count Result" + expectedResult + ", Report="+actualResult, true);
	        throw e; 
	    }
}
		    

}
