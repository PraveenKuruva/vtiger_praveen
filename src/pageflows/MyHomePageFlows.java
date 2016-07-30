package pageflows;

import org.openqa.selenium.By;
import org.testng.Assert;

import utils.VtigerUiElementActions;

public class MyHomePageFlows extends VtigerUiElementActions {

	public boolean loginToPortal() throws InterruptedException {
		boolean isLoginSuccess = false;
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
		return isLoginSuccess = true;

	}

	public void selectDateOnCalendar(String monthAndYear, String dateIs) {
		driver.findElement(By.xpath("//td[contains(text(),'" + monthAndYear
				+ "')]/ancestor::thead/following-sibling::tbody/tr/td[text()='" + dateIs + "']")).click();
	}

}
