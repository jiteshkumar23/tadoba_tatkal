package booking;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassMethods {
	static ChromeDriver driver;
	static boolean closed = true;
	static String URLString = "https://www.google.com";
	
	protected static void waitForVisibilityAndClick(ChromeDriver driver, WebDriverWait wait, String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

	}

	protected static void waitForOnlyVisibility(ChromeDriver driver, WebDriverWait wait, String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	protected static void waitForClickabilityAndClick(ChromeDriver driver, WebDriverWait wait, String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();

	}

	protected static void clickOkonPopup(ChromeDriver driver, WebDriverWait wait) {
		String popupStatus = driver.findElement(By.id("toast-alert")).getAttribute("class");
		System.out.println(popupStatus);
		try {
			if (popupStatus.toLowerCase().contains("show")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Ok\"]")));
//        		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()=\"Ok\"]"))));
				driver.findElement(By.xpath("//button[text()=\"Ok\"]")).click();

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected static void clickOkonGeoLocationPopup(ChromeDriver driver) {

		String classOfgeolocationModalDisplayed = driver.findElement(By.id("geo-location-modal")).getAttribute("class");
		System.out.println(classOfgeolocationModalDisplayed);
		try {
			Thread.sleep(500);
			if (driver.findElement(By.id("geo-location-modal")).getAttribute("class").toLowerCase().contains("none")) {

				System.out.println("Geo location modal is not displayed");
			} else {
				driver.findElement(By.id("retry-location")).click();
			}
		} catch (Exception e) {
			clickOkonGeoLocationPopup(driver);
			System.out.println("Exception in trying to click on Geo location modal and it is : " + e);
		}
	}

	protected static void scrollDownUsingMouse(ChromeDriver driver , int numberOfTimesPressArrowDown) {
		try {
			Actions actions = new Actions(driver);
			WebElement focusElement = driver.findElement(By.tagName("body"));
			// Click the element to give it focus
			actions.moveToElement(focusElement).click().build().perform();

			// Send keyboard keys for scrolling (e.g., Arrow Down)
			for (int i = 0; i < numberOfTimesPressArrowDown; i++) {
				focusElement.sendKeys(Keys.ARROW_DOWN);

			}

		} catch (Exception e) {
			System.out.println("Error on scrolling down");
		}
	}

	protected static void scrollToElementUsingMouse(ChromeDriver driver, WebElement element) {
		try {
			Actions actions = new Actions(driver);

			actions.moveToElement(element).build().perform();

		}

		catch (Exception e) {
			System.out.println("Error on scrolling down");
		}
	}

	protected static void scrollToTop(ChromeDriver driver, int upArrowClickCount) {
		try {
			Actions actions = new Actions(driver);
			WebElement focusElement = driver.findElement(By.tagName("body"));
			// Click the element to give it focus
			actions.moveToElement(focusElement).click().build().perform();
			for (int i = 0; i < upArrowClickCount; i++) {
				focusElement.sendKeys(Keys.ARROW_UP);

			}

		} catch (Exception e) {
			System.out.println("Error on scrolling up");
		}
	}

	protected static void smallSleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	protected static boolean checkINDateBeforeClicking(ChromeDriver driver, JavascriptExecutor js, WebDriverWait wait,
			String dateFromExcel) {
		// Check In Date
		System.out.println(dateFromExcel);
		String[] parts = dateFromExcel.split("-");

		String year = parts[2];

		String month = parts[1];

		String date = parts[0];

		System.out.println(year);
		System.out.println(month);
		System.out.println(date);

		// getting to year
		driver.findElement(By.xpath("(//thead//th[@class='datepicker-switch'])[1]")).click();
		driver.findElement(By.xpath("(//thead//th[@class='datepicker-switch'])[2]")).click();

		// clicking year
		String checkYearStatus = driver.findElement(By.xpath("//tbody//span[text()='" + year + "']"))
				.getAttribute("class");
		if (checkYearStatus.contains("disabled")) {
			return true;
		} else {
			driver.findElement(By.xpath("//tbody//span[text()='" + year + "']")).click();
		}

		// clicking month
		String checkMonthStatus = driver
				.findElement(By.xpath("//div[@class='datepicker-months']//span[text()='" + month + "']"))
				.getAttribute("class");
		if (checkMonthStatus.contains("disabled")) {
			return true;
		} else {
			driver.findElement(By.xpath("//div[@class='datepicker-months']//span[text()='" + month + "']")).click();
		}

		// getting to date
		WebElement dateElement = driver.findElement(By.xpath(
				"(//tr/td[@class='today active day' or @class='day' or @class='highlighted day' or @class='new disabled day' or @class='disabled day' or @class='disabled highlighted day'][text()="
						+ date + "])[1]"));

		wait.until(ExpectedConditions.elementToBeClickable(dateElement));

		String status = dateElement.getAttribute("class");

		boolean disabledFlag = false;
		if (status.contains("disabled")) {
			disabledFlag = true;

			System.out.println("Previous Attribute Value: " + status);
//
//			js.executeScript("arguments[0].setAttribute('class', 'day');", dateElement);
//			smallSleep();
//			System.out.println("New Attribute Value: " + dateElement.getAttribute("class"));
//			dateElement.click();

		} else {

			dateElement.click();
		}
		return disabledFlag;
	}

	protected static boolean checkOUTDateBeforeClicking(ChromeDriver driver, JavascriptExecutor js, WebDriverWait wait,
			String dateFromExcel) {
		// Check In Date

		System.out.println(dateFromExcel);
		String[] parts = dateFromExcel.split("-");

		String year = parts[2];

		String month = parts[1];

		String date = parts[0];

		System.out.println(year);
		System.out.println(month);
		System.out.println(date);

		// getting to year
		driver.findElement(By.xpath("(//thead//th[@class='datepicker-switch'])[1]")).click();
		driver.findElement(By.xpath("(//thead//th[@class='datepicker-switch'])[2]")).click();

		// clicking year
		driver.findElement(By.xpath("//tbody//span[text()='" + year + "']")).click();

		// getting to month
		waitForClickabilityAndClick(driver, wait, "//div[@class='datepicker-months']//span[text()='" + month + "']");

		// getting to date
		WebElement dateElement = null;
		try {
			dateElement = driver.findElement(By.xpath(
					"(//tr/td[@class='highlighted day' or @class='active day' or @class='day' or @class='active highlighted day'][text()="
							+ date + "])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(dateElement));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clicking checkout date, it may not be active");
		}

		String status = dateElement.getAttribute("class");

		boolean disabledFlag = false;
		if (status.contains("disabled")) {
			disabledFlag = true;

		} else {
			disabledFlag = false;
			dateElement.click();
		}
		return disabledFlag;

	}

	protected static void switchToCorbetteSite(ChromeDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();

		for (String winHandle : windowHandles) {
			driver.switchTo().window(winHandle);
			System.out.println(driver.getCurrentUrl());
			if (driver.getCurrentUrl().toLowerCase().contains("corbett")) {
				break;
			} else {
				continue;
			}
		}

		System.out.println("Current window title is " + driver.getTitle());

	}

	public static String readOTP(ChromeDriver driver, JavascriptExecutor js) throws InterruptedException {
		switchToWhatsappSite(driver);
		int newmessagelistSize = 0;
		String pin = "Not Found ";

		for (int i = 1; i < 240; i++) {
			Thread.sleep(1000);

			// random mouse movement

			int mod = i % 2;
			if (mod == 0) {
				switchToCorbetteSite(driver);
				performRandomMouseMovementOnPage(driver, 20);
				switchToWhatsappSite(driver);
			}

			// Get the size of new message list
			List<WebElement> newmessagelist = driver.findElements(By.xpath("//div[@class='_1BOF7 _2AOIt']"));
			newmessagelistSize = newmessagelist.size();
			System.out.println("newmessagelistSize is " + newmessagelistSize);
			if (newmessagelistSize > 0) {
				String message = newmessagelist.get(newmessagelistSize - 1).getText();
				System.out.println(message);

				String[] parts = message.split(":|\\s+");

				// Iterate through the parts and find the one that contains digits
				for (String part : parts) {
					if (part.matches("\\d+")) {
						System.out.println("PIN: " + part);
						pin = part;
						System.out.println("And the pin is " + pin);
						break; // Exit the loop once the PIN is found

					}
				}
				break;
			} else {
				System.out.println("Pin in attempt number " + i + " is " + pin);
				continue;
			}
		}

		System.out.println("Final Pin is " + pin);
		return pin;
	}

	protected static String deleteWhatAppChat(ChromeDriver driver) {

		switchToWhatsappSite(driver);

		// Locate the chat you want to read
		WebElement searchForChatEnterSearch = null;
		try {
			searchForChatEnterSearch = driver.findElement(By.xpath("//div[@title=\"Search input textbox\"]"));
			searchForChatEnterSearch.sendKeys("check");
		} catch (Exception e) {
			System.out.println("Search Input box was not found");
			return "Search Input box was not found";
		}
		smallSleep();
		WebElement searchForChat = driver.findElement(By.xpath("//div[@title=\"Search input textbox\"]//span"));
		searchForChat.sendKeys(Keys.CONTROL + "a");
		searchForChat.sendKeys(Keys.DELETE);
		// searchForChat.clear();
		searchForChatEnterSearch.sendKeys("+91 75095 85643");
		smallSleep();
		WebElement chat = driver.findElement(By.xpath("//span[@title=\"+91 75095 85643\"]"));
		// Click on the chat to open it
		chat.click();

		deleteChat(driver);
		return "Delete Whatapp chat is complete";

	}

	protected static void switchToWhatsappSite(ChromeDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();

		for (String winHandle : windowHandles) {
			driver.switchTo().window(winHandle);
			System.out.println(driver.getCurrentUrl());
			if (driver.getCurrentUrl().toLowerCase().contains("whatsapp")) {
				break;
			} else {
				continue;
			}
		}

		System.out.println("Current window title is " + driver.getTitle());

	}

	protected static void deleteChat(ChromeDriver driver) {
		driver.findElement(By.xpath("(//div[@role='button' and @title='Menu'])[2]")).click();
		smallSleep();
		smallSleep();
		driver.findElement(By.xpath("//div[text()='Clear chat']")).click();
		smallSleep();
		smallSleep();
		driver.findElement(By.xpath("//button//div[text()='Clear chat']")).click();
		smallSleep();

		System.out.println("chat cleared");

	}

	public static void performRandomClicksOnPage(ChromeDriver driver) {

		Random random = new Random();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int numberOfClicks = 10; // Change this to the desired number of random clicks

		for (int i = 0; i < numberOfClicks; i++) {
			int randomX, randomY;
			do {
				randomX = random.nextInt(driver.manage().window().getSize().getWidth());
				randomY = random.nextInt(driver.manage().window().getSize().getHeight());
			} while (randomX <= 0 || randomY <= 0);

			// Scroll to the random coordinates to ensure they are within the viewport
			js.executeScript("window.scrollTo(" + randomX + "," + randomY + ")");

			// Perform a click at the random coordinates
			driver.findElement(By.tagName("body")).click();

			// Optional: Print the coordinates of the click
			System.out.println("Clicked at X: " + randomX + ", Y: " + randomY);
		}

	}

	public static void performRandomMouseMovementOnPage(ChromeDriver driver, int count) {

		Random random = new Random();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int numberOfMovements = count; // Change this to control the number of random movements

		for (int i = 0; i < numberOfMovements; i++) {
			int randomX, randomY;

			// Generate random coordinates that are within the visible area
			do {
				randomX = random.nextInt(driver.manage().window().getSize().getWidth());
				randomY = random.nextInt(driver.manage().window().getSize().getHeight());
			} while (randomX <= 0 || randomY <= 0);

			// Scroll to the random coordinates to ensure they are within the viewport
			js.executeScript("window.scrollTo(" + randomX + "," + randomY + ")");

			// Perform a click at the random coordinates
			driver.findElement(By.tagName("body")).click();
		}
	}

	protected static void printDateTime(String msg) {
		// Create a SimpleDateFormat instance with the desired date and time format
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Format and print the current date and time
		System.out.println(msg + dateFormat.format(new Date()));
	}

	protected static void sleepForSeconds() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void refreshbuttoninwhatsappfix() {
		// Fix for refresh displayed in whatsapp
		List<WebElement> refreshicon = driver.findElements(By.xpath("//span[@data-icon='refresh']"));
		System.out.println("refresh icon displayed in whatsapp ==>" + refreshicon.size());
		if (refreshicon.size() > 0) {
			try {
				refreshicon.get(0).click();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void sendTextHumanLike(WebElement element, String text) {
		String[] arrayMobile = text.split("");
		for (String a : arrayMobile) {
			element.sendKeys(a);
		}
		
	}

	protected static void specificWait(int a) throws InterruptedException {
		Thread.sleep(a);

	}

	protected static void checkForPortalClose(ChromeDriver driver) throws InterruptedException {
		while (closed) {
			if (driver.getCurrentUrl().contains("closed")) {
				driver.get(URLString);
				System.out.println("Current page URL is :" + driver.getCurrentUrl());
				Thread.sleep(1000);
			} else {
				closed = false;
				driver.get(URLString);
				break;
			}
		}

	}

	protected static void checkForTime(int hour1, int min1, int sec1) throws InterruptedException {

		LocalTime targetTime = LocalTime.of(hour1, min1, sec1);

		boolean refresh = true;

		while (refresh) {

			if (LocalTime.now().isAfter(targetTime)) {
				System.out.println("Current time " + LocalTime.now() + " is after target time" + targetTime + "");
				refresh = false;
			} else if (LocalTime.now().equals(targetTime)) {
				System.out.println("Current time is exactly 10:00:00 AM.");
				Thread.sleep(1000);
				refresh = false;
			} else {
				System.out.println("Current time " + LocalTime.now() + " is less than target time " + targetTime + "");
				Thread.sleep(1000);
			}

		}

	}

}
