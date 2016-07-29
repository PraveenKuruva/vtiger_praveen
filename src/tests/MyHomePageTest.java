package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.ReadXMLConfigNodes_UIelement;
import utils.VtigerUiElementActions;

public class MyHomePageTest extends VtigerUiElementActions {

	@BeforeClass(alwaysRun = true)
	public void launchPortal() {
		new ReadXMLConfigNodes_UIelement("resources\\vtigerLocators.xml");
		launchVtiger();
		maximizeWindow();
	}

	@Test
	public void verifySuccesfullLogin() throws InterruptedException {
		click("HomePage.editBox_UserName");
		driver.findElement(By.name("user_name")).click();
		driver.findElement(By.name("user_name")).clear();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).click();
		driver.findElement(By.name("user_password")).clear();
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(5000);
		String expectedTextValue = "My Home Page > Home";
		String actualTextValue = driver
				.findElement(By.cssSelector(".moduleName")).getText().trim();
		System.out.println("actualTextValue-->" + actualTextValue);
		// boolean flag = false;
		// if (actualTextValue.equalsIgnoreCase(expectedTextValue)) {
		// flag = true;
		// }
		// Assert.assertTrue(flag, "Did login succesfully");
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
