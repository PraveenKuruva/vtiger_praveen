package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.MyHomePage;

@Listeners({ utils.ScreenshotOnFailure.class })
public class MyHomePageTest extends MyHomePage {

	@BeforeClass(alwaysRun = true)
	public void launchPortal() throws InterruptedException {
		// new ReadXMLConfigNodes_UIelement("resources\\vtigerLocators.xml");
		launchVtiger();
		maximizeWindow();
		loginToPortal();
	}

	@Test(priority = 0)
	public void verifySuccesfullLogin() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Assert.assertTrue(loginToPortal(), "Login is unsuccessfull");
		System.out.println("Login is successfull.");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		closeVtiger();
	}

}
