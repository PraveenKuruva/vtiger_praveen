package utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.CommonBasePage;

public class VtigerUiElementActions extends CommonBasePage {
	WebElement element;
	UIelementsXml_config uiele = new UIelementsXml_config();

	/**
	 * Clicks on the element based on the locator provided
	 * 
	 * @param String
	 */
	public void click(String locator) {
		try {
			element = uiele.getObjectFromXml(locator);
			if (element.isDisplayed()) {
				element.click();
				System.out.println("clicked on :" + locator);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Did not clicked on :" + locator);
			Assert.fail("OOPs !!!  did not perform click operation");

		}
	}

	/**
	 * Clears text on the element based on the locator provided
	 * 
	 * @param String
	 */

	// public void clear(String locator) {
	// try {
	// element = uiele.getObjectFromXml(locator);
	// element.clear();
	// System.out.println("cleared on :" + locator);
	// logger.info("cleared on :" + locator);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * This method enters the text provided based on the locator supplied
	 * 
	 * @param String
	 * @param String
	 */
	public void sendKeys_afterClear(String locator, String keyData) {
		try {
			element = uiele.getObjectFromXml(locator);
			element.clear();
			element.sendKeys(keyData);
			// navigateBack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to verify whether the element is displayed or not
	 * 
	 * @param String
	 * @param String
	 * @param String
	 * @return Boolean
	 */
	public boolean isElementDisplayed(String locator, String positiveMessage, String negativeMessage) {
		boolean flag = false;
		try {
			element = uiele.getObjectFromXml(locator);
			if (element.isDisplayed()) {
				flag = true;
				System.out.println(positiveMessage);
			} else {
				flag = false;
				System.out.println(negativeMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * This method is used to check whether the text is displayed in the webpage
	 * or not
	 * 
	 * @param String
	 * @param String
	 * @param String
	 * @return Boolean
	 */
	public boolean isTextPresent(String locator, String positiveMessage, String negativeMessage) {
		boolean flag = false;
		try {
			element = uiele.getObjectFromXml(locator);
			if (element.isDisplayed()) {
				flag = true;
				System.out.println(positiveMessage);
			} else {
				flag = false;
				System.out.println(negativeMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * This method is used to get the text from the webpage based on the locator
	 * supplied at particular location
	 * 
	 * @param String
	 * @return String
	 * 
	 */
	public String getText(String locator) {
		String testTriveBookedSucesfullymessage = null;
		try {
			element = uiele.getObjectFromXml(locator);
			testTriveBookedSucesfullymessage = element.getText();
			System.out.println("test drive booked message--:" + testTriveBookedSucesfullymessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testTriveBookedSucesfullymessage.toLowerCase().trim();
	}

	/**
	 * @author This method waits for the page to be loaded
	 * @param: long
	 * @Param: final By
	 * @param: WebDriver
	 */
	public void waitForPageLoad(long seconds, String locator, WebDriver driver) {
		System.out.println("waiting for page to load ........");
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		try {
			element = uiele.getObjectFromXml(locator);
			wait.until(visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Page loaded succesfully................");
	}

	/**
	 * @author Saorabh: this method checks for the visibility of the element
	 *         specified.
	 * @param :
	 *            final By
	 * @return : boolean
	 * 
	 */
	public static ExpectedCondition<Boolean> visibilityOfElementLocated(final WebElement element2) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				boolean toReturn = element2.isDisplayed();
				System.out.println("Element" + element2 + " is Displayed  :: " + toReturn);
				if (toReturn) {
					return toReturn;
				}
				return false;
			}
		};
	}

	/**
	 * @author vinodkn: --Clicks on the random item in the list
	 * @param int
	 *            index
	 * @param String
	 * 
	 */
	public void clickOnListItem(String locator, int index) {
		try {
			List<WebElement> element = uiele.getObjectFromXml1(locator);
			System.out.println("Total cities in popup:" + element.size());
			System.out.println("clicking on item indexed:" + index);
			// if (element.get(index).isDisplayed()) {
			element.get(index).click();
			System.out.println("clicked on :" + locator);
			// }

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Did not clicked on :" + locator);
			Assert.fail("OOPs !!!  did not perform click operation");
		}
	}

	/**
	 * This method enters the text provided based on the locator supplied
	 * 
	 * @param String
	 * @param String
	 */
	public void sendKeys(String locator, String keyData) {
		try {
			element = uiele.getObjectFromXml(locator);
			element.sendKeys(keyData);
			// navigateBack();
			System.out.println("Enter text   " + keyData + "  at locator   " + locator);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("did not do the type operation.." + "Key data is:" + keyData);
		}
	}

	public boolean verifyTextPresent(String ExpectedText, String actualText) {
		boolean flag = false;
		try {
			Assert.assertEquals(ExpectedText, actualText);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Clears text on the element based on the locator provided
	 * 
	 * @param String
	 */

	public void clear(String locator) {
		try {
			element = uiele.getObjectFromXml(locator);
			element.clear();
			System.out.println("cleared on :" + locator);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void safeClick(String locator) {
		try {
			element = uiele.getObjectFromXml(locator);

			// element.clear();
			// JavascriptExecutor executor = (JavascriptExecutor) driver;
			// executor.executeScript("arguments[0].click();", element);
			Actions builder = new Actions(driver);
			builder.moveToElement(element).click(element);
			builder.perform();
			System.out.println("safe Clicked on :" + locator);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//
	}

	public void SelectByVisibleText(String locator, String visibleText) throws InterruptedException {
		try {
			element = uiele.getObjectFromXml(locator);
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
			System.out.println("Selected :" + visibleText + " From select box");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Did not Selected :" + visibleText + " From select box");
		}
	}

	public void SelectByIndex(String locator, int index) throws InterruptedException {
		try {
			element = uiele.getObjectFromXml(locator);
			Select select = new Select(element);
			select.selectByIndex(index);
			System.out.println("Selected :" + index + " From select box");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Did not Selected :" + index + " From select box");
		}

	}

}
