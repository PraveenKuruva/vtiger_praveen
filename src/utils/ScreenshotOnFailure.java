package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;

import common.CommonBasePage;

public class ScreenshotOnFailure extends CommonBasePage {
	@Override
	public void onTestFailure(ITestResult tr) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
		// String destDir = "target/surefire-reports/screenshots";
		// String destDir = "screenshot";
		String destDir = "resources\\FailedScreenshots";

		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Reporter.setEscapeHtml(false);
		Reporter.log("Saved <a href=../screenshots/" + destFile
				+ ">Screenshot</a>");
	}
}