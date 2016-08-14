package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;

public class CommonBasePage extends TestListenerAdapter {

	public static WebDriver driver;
	private final String URL = "http://localhost:8888/";

	public void launchVtiger() {
		driver = new FirefoxDriver();
		driver.get(URL);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void closeVtiger() {
		driver.close();
	}

	// -Ve Y values will scroll th epage upwards
	public void scrollPageBy(int X, int Y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + X + "," + Y + ")", "");
	}
	
	
	

}
