package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.MyHomePage;

@Listeners({ utils.ScreenshotOnFailure.class })
public class MarketingTest extends MyHomePage {

	@Test(priority = 0)
	public void testing() throws InterruptedException {
		safeClick("HomePage.link_Text_Marketing");
		click("Marketingpage.link_Text_Campaigns");
		Thread.sleep(2000L);
		click("Marketingpage.img_Campaigns_Create");
		Thread.sleep(2000L);
		sendKeys("Marketingpage.editBox_Campaign_Name", "testcampaign");
		SelectByIndex("Marketingpage.select_campaignType", 1);
		sendKeys("Marketingpage.textarea_Description", "description of campaign");
		click("Marketingpage.button_save");
	}

}
