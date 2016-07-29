package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.VtigerUiElementActions;

@Listeners({ utils.ScreenshotOnFailure.class })
public class MyHomePageTest extends VtigerUiElementActions {

	@BeforeClass(alwaysRun = true)
	public void launchPortal() {
		// new ReadXMLConfigNodes_UIelement("resources\\vtigerLocators.xml");
		launchVtiger();
		maximizeWindow();
	}

	@Test
	public void verifySuccesfullLogin() throws InterruptedException {
		click("LoginPage.editBox_UserName");
		clear("LoginPage.editBox_UserName");
		sendKeys("LoginPage.editBox_UserName", "admin");
		click("LoginPage.editBox_Password");
		clear("LoginPage.editBox_Password");
		sendKeys("LoginPage.editBox_Password", "admin");
		click("LoginPage.button_submit");
		Thread.sleep(5000);
		String expectedTextValue = "my home page > home";
		String actualTextValue = getText("HomePage.txt_LandingText");
		System.out.println("actualTextValue-->" + actualTextValue);
		Assert.assertEquals(actualTextValue, expectedTextValue);
		System.out.println("Logged in succesfully..");
	}

	@Test
	public void testing() {
		System.out.println("Testing..");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		closeVtiger();
	}

}
