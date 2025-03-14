package booking;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TatkalBooking extends TatkalBooking_DataProfile1 {
	static WebDriver driver;
	static JavascriptExecutor js;
	static WebDriverWait waitnew;
	static WebDriverWait wait2;
	static WebDriverWait wait5;
	static WebDriverWait wait10;
	static WebDriverWait wait15;
	static WebDriverWait wait30;
	static WebDriverWait wait200;
	static WebDriverWait wait600;
	static WebDriverWait wait900;
	static String availableTickets;
	static ArrayList<String> listOfName;
	static ArrayList<String> listOfGender;
	static ArrayList<String> listOfAge;
	static ArrayList<String> listOfCountry;
	static ArrayList<String> listOfId;
	static ArrayList<String> listOfIdNumber;
	static ArrayList<String> listOfChildName;
	static ArrayList<String> listOfChildAge;
	static ArrayList<String> listOfCameraSelection;
	static String numberOfMembers;
	static int intNumberOfMembers;
	static String dateToBeClickedOnCalendar;
	static Actions actions;
	static String xpathForLink;
	static boolean linkDisplayed = false;

	@BeforeTest()
	public static void prerequisite() throws InterruptedException, IOException {

		// Create ChromeOptions instance
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		// Set the remote debugging address
		options.setExperimentalOption("debuggerAddress", "localhost:7777");

		// Create a WebDriver instance using the updated W3C syntax
		driver = new ChromeDriver(options);

		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait15 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait30 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait200 = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait600 = new WebDriverWait(driver, Duration.ofSeconds(600));
		wait900 = new WebDriverWait(driver, Duration.ofSeconds(900));
		actions = new Actions(driver);

		numberOfMembers = TatkalBooking_DataProfile1.numberOfMembers;
		intNumberOfMembers = Integer.parseInt(numberOfMembers);

	}

	@Test
	private static void doBooking() throws Exception {

		System.out.println("###################   Starting   ###################");
		System.out.println("");
		//printDateTime("Starting Time -->");

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);

		// Select Eco Tourist Place
		//selectEcoTouristPlace();
		waitUntilDropdownIsDisplayed();

		// Select Zone
		waitUntilZoneDropdownIsDisplayed();
		//selectZone();
		
		// Set implicit timeout later
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		if (typeOfBooking.toLowerCase().equalsIgnoreCase("regular")) {
		    // select vehicle for Regular : Regular change 1
		    selectVehicleForRegularFlow();
		}

		if (typeOfBooking.toLowerCase().equalsIgnoreCase("tatkal")) {
		    selectDateForTatkalFlow(); // for Tatkal flow
		}

		if (typeOfBooking.toLowerCase().equalsIgnoreCase("regular")) {
		    // select Date for Regular flow from test data : Regular change 2
		    selectRegularBookingDateInCalendar("09/06/2025"); // for Regular flow
		}

		// click on search button
		clickOnSearchButton();

		// wait for display of table
		//waitForDisplayOfTable();

		if (typeOfBooking.toLowerCase().equalsIgnoreCase("regular")) {
		    // Click on link for Regular flow : : Regular change 3
		    clickOnLinkForRegularFlow();
		}

		if (typeOfBooking.toLowerCase().equalsIgnoreCase("tatkal")) {
		    clickOnLinkForTatkalFlow();
		}

		setMaxCount();

		// select number of people in dropdown
		selectNumberOfPeopleInDropdown();

		// enter Member details from Autofill plugin
		fillMemberDetailsfromAutoFillPlugin();

		Thread.sleep(200);		
		selectAgreement();

		clickOnPayButton();

//		if (paymentMode.toLowerCase().equalsIgnoreCase("upi")) {
//		    doUPIPayment();
//		} else if (paymentMode.toLowerCase().equalsIgnoreCase("credit card")) {
//		    doCreditCardPayment();
//		}

		System.out.println("");
		System.out.println("Flow successfully completed");
		System.out.println("###################   Completed   ###################");
		printDateTime("Ending Time -->");


	}
	
	@Test
	private static void fillOnlyForm() throws Exception {
		setMaxCount();

		// select number of people in dropdown
		selectNumberOfPeopleInDropdown();

		// enter Member details from Autofill plugin
		fillMemberDetailsfromAutoFillPlugin();

		Thread.sleep(200);		
		selectAgreement();

		clickOnPayButton();

		System.out.println("");
		System.out.println("Flow successfully completed");
		System.out.println("###################   Completed   ###################");
		printDateTime("Ending Time -->");


	}

	private static void fillMemberDetailsfromAutoFillPlugin() {
		// WebElement element =
		// driver.findElement(By.xpath("//h1[normalize-space()='Vehicle Booking']"));
		WebElement bodyElement = driver.findElement(By.tagName("body"));
		actions.keyDown(Keys.ALT).sendKeys("q").keyUp(Keys.ALT).build().perform();
		actions.moveToElement(bodyElement).perform();

	}

	private static void clickOnLinkForRegularFlow() throws InterruptedException {
//		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody/tr[4]/td[9]//a)[1]")));
//		WebElement availableOption = driver.findElement(By.xpath("(//tbody/tr[4]/td[9]//a)[1]"));
//		//Thread.sleep(250);
//		wait15.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//tbody/tr[4]/td[9]//a)[1]"))));
//		driver.findElement(By.xpath("(//tbody/tr[4]/td[9]//a)[1]")).click();
//		System.out.println("###################   Link Clicked   ###################");
//		System.out.println("");
//		printDateTime("Link Clicked Time -->");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		xpathForLink = "//tbody/tr[3]/td[10]";
		try {
            // Loop until the link is displayed and clickable
            while (true) {
                try {
                	
                	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(250));
                	WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathForLink)));
                    System.out.println("Text displayed is "+linkElement.getText());
                	if (linkElement.getText().contains("1") || 
                			linkElement.getText().contains("2")|| 
                			linkElement.getText().contains("3")|| 
                			linkElement.getText().contains("4")|| 
                			linkElement.getText().contains("5")|| 
                			linkElement.getText().contains("6")||
                			linkElement.getText().contains("7")||
							linkElement.getText().contains("8")||
							linkElement.getText().contains("9")){
                        // Click the link using JavaScript
                		xpathForLink = xpathForLink+"//a";
                		printDateTime("Link displayed time and clicked  -->");
                		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathForLink)));
                        System.out.println("Link with specific text clicked successfully!");
             
                        break; // Exit the loop if the link is clicked

                	}else {
                		System.out.println("Link not found, clicking search button...");
                        driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();;
                	}
                	} catch (Exception e) {
                		System.out.println("Some exception is there, but i will continue to try --> ");
                        e.printStackTrace();
                }
            }
            
        } catch (Exception e) {
        	System.out.println("Some exception is there, but i will continue to try --> ");
            e.printStackTrace();
        }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	
	private static void clickOnLinkForTatkalFlow() throws InterruptedException {

		if (shiftFromData.toLowerCase().equalsIgnoreCase("morning")) {

			if (gateFromData.toLowerCase().equalsIgnoreCase("Zari")) {

				xpathForLink = "//tbody/tr[4]/td[6]";

			} else {
				xpathForLink = "//tbody/tr[3]/td[6]";
			}

		} else if (shiftFromData.toLowerCase().equalsIgnoreCase("afternoon")) {

			if (gateFromData.toLowerCase().equalsIgnoreCase("Zari")) {

				xpathForLink = "//tbody/tr[4]/td[7]";
			} else {
				xpathForLink = "//tbody/tr[3]/td[7]";
			}

		}
		
		System.out.println("Final Xpath is --> " + xpathForLink);
		System.out.println("Shift selected -->" + shiftFromData);
		System.out.println("Gate selected -->" + gateFromData);
		System.out.println("Now attempting to check if link is displayed or not ");
	
		try {
            // Loop until the link is displayed and clickable
            while (true) {
                try {
                	
                	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
                	WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathForLink)));
                    System.out.println("Text displayed is "+linkElement.getText());
                	if (linkElement.getText().contains("1") || 
                			linkElement.getText().contains("2")) {
                        // Click the link using JavaScript
                		xpathForLink = xpathForLink+"//a";
                		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathForLink)));
                        System.out.println("Link with specific text clicked successfully!");
                        printDateTime("Starting Time -->");
                        break; // Exit the loop if the link is clicked

                	}else {
                		System.out.println("Link not found, clicking search button...");
                		performSearchAgain();
                	}
                	} catch (Exception e) {
                		System.out.println("Some exception is there, but i will continue to try catch block1--> ");
                        e.printStackTrace();
                        performSearchAgain();
                }
            }
            
        } catch (Exception e) {
        	System.out.println("Some exception is there, but i will continue to try catch block2--> ");
           
        }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Thread.sleep(250);
//		try {
//		//	Thread.sleep(250);
//			System.out.println("Link count is -->" + driver.findElements(By.xpath(xpathForLink)).size());
//			wait10.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpathForLink), 0));
//			System.out.println("Wait for size to be more than 0 is OVER");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//			System.out.println("About to click the link with xpath " + xpathForLink);
//			driver.findElement(By.xpath(xpathForLink)).click();
//			System.out.println("###################   Link Clicked   ###################");
//			System.out.println("");
//			printDateTime("Link Clicked Time -->");
//		} catch (Exception e) {
//			System.out.println("I am in Exception block , retrying -->" + e);
//			e.printStackTrace();
//			waitForDisplayOfTable();
//			System.out.println("In exception block - Link count is -->" + driver.findElements(By.xpath(xpathForLink)).size());
//			wait10.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpathForLink), 0));
//			System.out.println("In exception block - Wait for size to be more than 0 is OVER");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//			System.out.println("In exception block - About to click the link with xpath " + xpathForLink);
//			driver.findElement(By.xpath(xpathForLink)).click();
//			System.out.println("###################  In exception block -  Link Clicked   ###################");
//			System.out.println("");
//			printDateTime("In exception block -->Link Clicked Time -->");
//		}

	}

	private static void waitForDisplayOfTable() {
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bookingHtml']")));
		System.out.println("Executed after wait for Table: probably table was displayed");
	}

	private static void doUPIPayment() {
		//wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Other Payment Modes']")));
		WebElement upiLink = driver
				.findElement(By.xpath("//*[text()='Other Payment Modes']/../../following-sibling::div/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", upiLink);

		wait15.until(ExpectedConditions.urlContains("merchantotherupidisplay"));
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='QRcode']")));
		WebElement qrCode = driver.findElement(By.cssSelector("label[for='QRcode']"));
		executor.executeScript("arguments[0].click();", qrCode);
		//wait15.until(ExpectedConditions.urlContains("merchantinterotherconfirm"));
		//scrollDownUsingMouse(driver, 5);

	}

	private static void doCreditCardPayment() throws InterruptedException {
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Card Payments']")));
		WebElement creditCardLink = driver
				.findElement(By.xpath("(//a[@id='cardbutton'])[contains(@onclick,'CreditCard')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", creditCardLink);

		wait15.until(ExpectedConditions.urlContains("merchantotherdisplay"));
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Go']")));
		WebElement confirmButton = driver.findElement(By.xpath("//input[@id='Go']"));
		wait15.until(ExpectedConditions.elementToBeClickable(confirmButton));
		confirmButton.click();
		wait15.until(ExpectedConditions.urlContains("merchantinterother"));

		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Go']")));
		WebElement confirmButton2 = driver.findElement(By.xpath("//input[@id='Go']"));
		wait15.until(ExpectedConditions.elementToBeClickable(confirmButton2));
		confirmButton2.click();

		wait15.until(ExpectedConditions.urlContains("paymentpage"));

		// enter card number
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cardNumber']")));
		WebElement cardNumber = driver.findElement(By.xpath("//input[@id='cardNumber']"));
		wait15.until(ExpectedConditions.elementToBeClickable(cardNumber));
		cardNumber.click();
		Thread.sleep(200);
		cardNumber.sendKeys(TatkalBooking_CreditCardInformation.Credit_Card_Number);

		// enter card holder name
		WebElement cardHolderName = driver.findElement(By.xpath("//input[@id='cardholderName']"));
		wait15.until(ExpectedConditions.elementToBeClickable(cardHolderName));
		cardHolderName.click();
		Thread.sleep(200);
		cardHolderName.sendKeys(TatkalBooking_CreditCardInformation.Credit_Card_Holder_Name);

		// enter card cvv
		WebElement cardCVV = driver.findElement(By.xpath("//input[@id='cardCvv']"));
		wait15.until(ExpectedConditions.elementToBeClickable(cardCVV));
		cardCVV.click();
		Thread.sleep(200);
		cardCVV.sendKeys(TatkalBooking_CreditCardInformation.Credit_Card_CVV);

		// enter card expiry month
		Thread.sleep(200);
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='expMnthSelect']")));
		WebElement expiryMonth = driver.findElement(By.xpath("//select[@id='expMnthSelect']"));
		wait15.until(ExpectedConditions.elementToBeClickable(expiryMonth));
		Select select = new Select(expiryMonth);
		select.selectByVisibleText(TatkalBooking_CreditCardInformation.Credit_Expiry_Month);

		// enter card expiry year
		Thread.sleep(200);
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='expYearSelect']")));
		WebElement expiryYear = driver.findElement(By.xpath("//select[@id='expYearSelect']"));
		wait15.until(ExpectedConditions.elementToBeClickable(expiryYear));
		Select select2 = new Select(expiryYear);
		select2.selectByVisibleText(TatkalBooking_CreditCardInformation.Credit_Expiry_Year);

	}

	private static void clickOnPayButton() {
	try {
        WebElement payButton = driver.findElement(By.xpath("//button[@id='btnSubmit']"));
        wait15.until(ExpectedConditions.elementToBeClickable(payButton));

        // Continuously click Pay button until URL contains "merchant"
        while (!driver.getCurrentUrl().contains("merchant")) {
            try {
            	System.out.println(driver.getCurrentUrl());
                js.executeScript("arguments[0].click();", payButton);
                System.out.println("waited 500 ms");
                Thread.sleep(500);
                
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        		try {
        		WebElement errorMsg = driver.findElement(By.xpath("//input[@id='agree_term']/following-sibling::span"));
        		System.out.println(errorMsg.getText());
        		if(errorMsg.getText().contains("required")) {
        			WebElement agreementCheckBox = driver.findElement(By.xpath("//input[@id='agree_term']"));
        			js.executeScript("arguments[0].click();", agreementCheckBox);
        			wait15.until(ExpectedConditions.alertIsPresent());
        			driver.switchTo().alert().accept();
        		}
        		}catch(Exception e) {
        			System.out.println("Ran into exception while clicking on terms and conditions check box");
        		}
        		
                System.out.println("Pay button clicked in while loop");
            } catch (Exception e) {
                System.out.println("Pay button click attempt failed. Retrying...");
            }
        }
        System.out.println("URL after while loop is done -->"+driver.getCurrentUrl());
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
	}
	
	private static void selectAgreement() throws InterruptedException {
		wait15.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='agree_term']")));
		wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='agree_term']")));
		WebElement agreementCheckBox = driver.findElement(By.xpath("//input[@id='agree_term']"));
		js.executeScript("arguments[0].click();", agreementCheckBox);
		
		
		//scrollToElementUsingMouse(driver, agreementCheckBox);
		//Thread.sleep(200);
		//agreementCheckBox.click();
		wait15.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		
		//		try {
//			wait10.until(ExpectedConditions
//					.textToBePresentInElementLocated(By.xpath("//th[normalize-space()='Grand Total']"), "Grand Total"));
//		} catch (Exception e) {
//			System.out.println("Grand total was not found");
//		}
//		scrollToElementUsingMouse(driver, driver.findElement(By.xpath("//button[@id='btnSubmit']")));
//		Thread.sleep(100);
//		scrollDownUsingMouse(driver, 5);
//		Thread.sleep(200);
	}

	private static void selectNumberOfPeopleInDropdown() {
		
		System.out.println("Waiting for number of people dropdown");
		wait600.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='no_people']")));
		WebElement numberOfPeopleDropdown = driver.findElement(By.xpath("//select[@id='no_people']"));
		System.out.println("Found the number of people dropdown");
		wait15.until(ExpectedConditions.elementToBeClickable(numberOfPeopleDropdown));
		Select select4 = new Select(driver.findElement(By.xpath("//select[@id='no_people']")));

		try {
			select4.selectByVisibleText(String.valueOf(intNumberOfMembers));
		} catch (Exception e) {

			e.printStackTrace();
			select4.selectByVisibleText(numberOfMembers);
		}
		System.out.println("Selected the number of people in dropdown");
		wait15.until(
				ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@id='touristName0']"))));
	}

	private static void clickOnSearchButton() {
		WebElement searchButton = driver.findElement(By.xpath("//button[@id='btnSubmit']"));
		wait15.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();

	}

	private static void selectDateForTatkalFlow() {
		WebElement dateDropdown = driver.findElement(By.xpath("//select[@id='cmbDate']"));
		wait15.until(ExpectedConditions.elementToBeClickable(dateDropdown));
		Select select4 = new Select(dateDropdown);
		// select4.selectByVisibleText(TatkalBooking_DataProfile1.dateFromData);
		select4.selectByIndex(1);
	}

	private static void selectRegularBookingDateInCalendar(String date) {
		WebElement calendar = driver.findElement(By.xpath("//input[@id='txtDateBooking']"));
		calendar.clear();
		calendar.sendKeys(date);
	}

	private static void selectEcoTouristPlace() throws InterruptedException {

		WebElement ecoTouristPlaceDropdown = driver.findElement(By.xpath("//select[@id='cmbSanctuary']"));
		wait15.until(ExpectedConditions.elementToBeClickable(ecoTouristPlaceDropdown));
		Select select4 = new Select(ecoTouristPlaceDropdown);
		select4.selectByIndex(0);
		Thread.sleep(100);
		select4.selectByVisibleText(TatkalBooking_DataProfile1.ecoTouristPlace);
	}

	private static boolean isElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public static void getNumberOfMembers() {
		numberOfMembers = TatkalBooking_DataProfile1.numberOfMembers;
		int intNumberOfMembers = Integer.parseInt(numberOfMembers);
		System.out.println("Numbers of members from datasheet is " + intNumberOfMembers);

	}

	public static void printImplicitWaitAtThisStep() {
		Duration waitatThisMoment = driver.manage().timeouts().getImplicitWaitTimeout();
		System.out.println("Implicit wait at this moment is -->" + waitatThisMoment);

	}

	public static void clickOnAvailabilityButton() throws InterruptedException {
		Thread.sleep(300);
		WebElement buttonCheckAvailability = driver.findElement(By.xpath("//button[@id='btn_CheckAvailibility']"));
		wait30.until(ExpectedConditions.elementToBeClickable(buttonCheckAvailability));
		buttonCheckAvailability.click();
		Thread.sleep(200);

	}

	public static void setMaxCount() {
		System.out.println("Number of people to select is " + intNumberOfMembers);
	}

	public static void selectVehicleForRegularFlow() throws InterruptedException {
		List<WebElement> vehicleDropDown = driver.findElements(By.xpath("//select[@id='cmbVehicle']"));
		int vehicleDropDownSize = vehicleDropDown.size();
		System.out.println(vehicleDropDownSize);
		if (vehicleDropDownSize > 0) {
			WebElement vehicleDropdown = driver.findElement(By.xpath("//select[@id='cmbVehicle']"));
			wait15.until(ExpectedConditions.elementToBeClickable(vehicleDropdown));
			Select select4 = new Select(vehicleDropdown);
			select4.selectByVisibleText("Gypsy");

		}
	}

	public static void selectZone() throws InterruptedException {
		try {
		WebElement zoneDropdown = driver.findElement(By.xpath("//select[@id='cmbZone']"));
		wait15.until(ExpectedConditions.elementToBeClickable(zoneDropdown));
		wait15.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//select[@id='cmbZone']"),
				TatkalBooking_DataProfile1.zoneFromData));
		Select select4 = new Select(driver.findElement(By.xpath("//select[@id='cmbZone']")));
		select4.selectByVisibleText(TatkalBooking_DataProfile1.zoneFromData);
		}catch(Exception e) {
			selectEcoTouristPlace();
		}

	}
	
	public static void performSearchAgain() throws InterruptedException{
		
		// Select Eco Tourist Place
		
				System.out.println("*************Performing Search Again ******************");
				

				waitUntilZoneDropdownIsDisplayed();

				if (typeOfBooking.toLowerCase().equalsIgnoreCase("regular")) {
				    // select vehicle for Regular : Regular change 1
				    selectVehicleForRegularFlow();
				}

				if (typeOfBooking.toLowerCase().equalsIgnoreCase("tatkal")) {
				    selectDateForTatkalFlow(); // for Tatkal flow
				}

				if (typeOfBooking.toLowerCase().equalsIgnoreCase("regular")) {
				    // select Date for Regular flow from test data : Regular change 2
				    selectRegularBookingDateInCalendar("09/04/2025"); // for Regular flow
				}

				// click on search button
				clickOnSearchButton();

		
	}
	
	public static void waitUntilDropdownIsDisplayed() {
		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
            // Loop until the link is displayed and clickable
            while (true) {
                try {
                	
                	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(250));
                	WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='cmbSanctuary']")));
                    System.out.println("Text displayed is "+linkElement.getText());
                	if (linkElement.getText().toLowerCase().contains("please select")){
                		
                		WebElement ecoTouristPlaceDropdown = driver.findElement(By.xpath("//select[@id='cmbSanctuary']"));
                		Select select4 = new Select(ecoTouristPlaceDropdown);
                		select4.selectByVisibleText(TatkalBooking_DataProfile1.ecoTouristPlace);
                        break; // Exit the loop if the link is clicked

                	}else {
                		System.out.println("Dropdown not found...");
                		Thread.sleep(200);
                        
                	}
                	} catch (Exception e) {
                		System.out.println("Waiting for eco tourist place dropdown to display --> ");
                        //e.printStackTrace();
                }
            }
            
        } catch (Exception e) {
        	System.out.println("Dropdown not found, but i will continue to try --> ");
            //e.printStackTrace();
        }
		
	}
	
public static void waitUntilZoneDropdownIsDisplayed() {
		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
            // Loop until the link is displayed and clickable
            while (true) {
                try {
                	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(200));
                	WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='cmbZone']")));
                	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//select[@id='cmbZone']"),
            				TatkalBooking_DataProfile1.zoneFromData));
                    System.out.println("Text displayed is "+linkElement.getText());
                	if (linkElement.getText().toLowerCase().contains(TatkalBooking_DataProfile1.zoneFromData.toLowerCase())){
                		System.out.println("################Zone is found in dropdown#############");
                		Select select4 = new Select(driver.findElement(By.xpath("//select[@id='cmbZone']")));
                		select4.selectByVisibleText(TatkalBooking_DataProfile1.zoneFromData);
                        break; // Exit the loop if the link is clicked

                	}else {
                		System.out.println("Dropdown not found...");
                		Thread.sleep(200);
                        
                	}
                	} catch (Exception e) {
                		selectEcoTouristPlace();
                		System.out.println("Waiting for zone dropdown to display --> ");
                        //e.printStackTrace();
                }
            }
            
        } catch (Exception e) {
        	System.out.println("Zone Dropdown not found, but i will continue to try --> ");
            //e.printStackTrace();
        }
		
	}

}
