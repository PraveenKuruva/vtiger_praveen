package utils;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.CommonBasePage;

public class UIelementsXml_config extends CommonBasePage {

	public WebElement getObjectFromXml(String locatorKeyValue) throws InterruptedException {
		final String SPLITTER = "@#@";
		final String SPLITTER_MULTIPLE_Values = "||";
		WebElement element = null;
		String locator = ReadXMLConfigNodes_UIelement.GetLocatorFromUIelementsXml(locatorKeyValue);
		// System.out.println("locator is :" + locator);

		// implement fall back
		String[] multiplelocatorElement = locator.split(Pattern.quote(SPLITTER_MULTIPLE_Values));
		for (int i = 0; i < multiplelocatorElement.length; i++) {
			if (element == null) {

				String[] locatorElement = multiplelocatorElement[i].split(SPLITTER);
				System.out.println("----->>" + locatorElement[1]);
				System.out.println("#***************@ Locating elements @*********************#");
				System.out.println("locator Name is:" + locatorKeyValue);

				try {
					System.out.println("Searching for locator -->> " + locatorElement[1]);
					Thread.sleep(1000);
					switch (locatorElement[0]) {
					case "xpath":
						waitForPageLoad(10, By.xpath(locatorElement[1]), driver);
						element = driver.findElement(By.xpath(locatorElement[1]));
						break;
					case "id":
						waitForPageLoad(10, By.id(locatorElement[1]), driver);
						element = driver.findElement(By.id(locatorElement[1]));
						break;
					case "className":
						waitForPageLoad(10, By.className(locatorElement[1]), driver);
						element = driver.findElement(By.className(locatorElement[1]));
						break;
					case "name":
						waitForPageLoad(10, By.name(locatorElement[1]), driver);
						element = driver.findElement(By.name(locatorElement[1]));
						break;
					case "linkText":
						waitForPageLoad(10, By.linkText(locatorElement[1]), driver);
						element = driver.findElement(By.linkText(locatorElement[1]));
						break;
					case "cssSelector":
						waitForPageLoad(10, By.cssSelector(locatorElement[1]), driver);
						element = driver.findElement(By.cssSelector(locatorElement[1]));
						break;

					default:
						System.out.println("**$$$$** not a valid locator ***$$$***");
					}
				} catch (Exception e) {
					System.out.println(locator + "in not available");
				}
			}
		}
		return element;

	}

	public List<WebElement> getObjectFromXml1(String locatorKeyValue) throws InterruptedException {
		final String SPLITTER = "@#@";
		List<WebElement> element = null;
		String locator = ReadXMLConfigNodes_UIelement.GetLocatorFromUIelementsXml(locatorKeyValue);
		System.out.println("locator is :" + locator);
		String[] locatorElement = locator.split(SPLITTER);
		System.out.println("----->>" + locatorElement[1]);
		System.out.println("#***************@ Locating elements @*********************#");
		System.out.println("locator Name is:" + locatorKeyValue);
		try {
			for (int i = 0; i <= 10; i++) {
				System.out.println("Searching for locator -->> " + locatorElement[1]);
				Thread.sleep(1000);
				switch (locator.split(SPLITTER)[0]) {
				case "xpath":
					element = driver.findElements(By.xpath(locator.split(SPLITTER)[1]));
					break;
				case "id":
					element = driver.findElements(By.id(locator.split(SPLITTER)[1]));
					break;
				case "className":
					element = driver.findElements(By.className(locator.split(SPLITTER)[1]));
					break;
				case "name":
					element = driver.findElements(By.name(locator.split(SPLITTER)[1]));
					break;
				case "linkText":
					waitForPageLoad(10, By.xpath(locator.split(SPLITTER)[1]), driver);
					element = driver.findElements(By.linkText(locator.split(SPLITTER)[1]));
					break;
				case "cssSelector":
					element = driver.findElements(By.cssSelector(locator.split(SPLITTER)[1]));
					break;
				default:
					System.out.println("**$$$$** not a valid locator ***$$$***");
				}
			}
		} catch (TimeoutException e) {
			System.out.println(locator + "in not available");
		}
		return element;
	}

	public void zoomoUiElementActions() {
		Actions actions = new Actions(driver);
	}

	private void waitForPageLoad(long seconds, final By locator, WebDriver driver) {
		System.out.println("waiting for page to load ........");
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Page loaded succesfully................");
	}

	public static ExpectedCondition<Boolean> visibilityOfElementLocated(final By locator) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				boolean toReturn = driver.findElement(locator).isDisplayed();
				if (toReturn) {
					return toReturn;
				}
				return false;
			}
		};
	}
}
