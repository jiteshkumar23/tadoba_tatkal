package booking;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TatkalBooking extends TatkalBooking_DataProfile1 {
	static ChromeDriver driver;
	static JavascriptExecutor js;
	static WebDriverWait waitnew;
	static WebDriverWait wait2;
	static WebDriverWait wait5;
	static WebDriverWait wait10;
	static WebDriverWait wait15;
	static WebDriverWait wait30;
	static WebDriverWait wait200;
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
	static int maxCount;
	static String numberOfMembers;
	static int intNumberOfMembers;
	static String dateToBeClickedOnCalendar;
	static Actions actions;
	static String maxCountFromLink;
	static String xpathForLink;

	@BeforeTest()
	public static void prerequisite() throws InterruptedException, IOException {

		// Create ChromeOptions instance
		WebDriverManager.chromedriver().setup();
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
		actions = new Actions(driver);

		listOfName = new ArrayList<String>();
		listOfName.add(TatkalBooking_DataProfile1.name1FromData);
		listOfName.add(TatkalBooking_DataProfile1.name2FromData);
		listOfName.add(TatkalBooking_DataProfile1.name3FromData);
		listOfName.add(TatkalBooking_DataProfile1.name4FromData);
		listOfName.add(TatkalBooking_DataProfile1.name5FromData);
		listOfName.add(TatkalBooking_DataProfile1.name6FromData);

		listOfGender = new ArrayList<String>();
		listOfGender.add(TatkalBooking_DataProfile1.gender1FromData);
		listOfGender.add(TatkalBooking_DataProfile1.gender2FromData);
		listOfGender.add(TatkalBooking_DataProfile1.gender3FromData);
		listOfGender.add(TatkalBooking_DataProfile1.gender4FromData);
		listOfGender.add(TatkalBooking_DataProfile1.gender5FromData);
		listOfGender.add(TatkalBooking_DataProfile1.gender6FromData);

		listOfAge = new ArrayList<String>();
		listOfAge.add(TatkalBooking_DataProfile1.age1FromData);
		listOfAge.add(TatkalBooking_DataProfile1.age2FromData);
		listOfAge.add(TatkalBooking_DataProfile1.age3FromData);
		listOfAge.add(TatkalBooking_DataProfile1.age4FromData);
		listOfAge.add(TatkalBooking_DataProfile1.age5FromData);
		listOfAge.add(TatkalBooking_DataProfile1.age6FromData);

		listOfCountry = new ArrayList<String>();
		listOfCountry.add(TatkalBooking_DataProfile1.country1FromData);
		listOfCountry.add(TatkalBooking_DataProfile1.country2FromData);
		listOfCountry.add(TatkalBooking_DataProfile1.country3FromData);
		listOfCountry.add(TatkalBooking_DataProfile1.country4FromData);
		listOfCountry.add(TatkalBooking_DataProfile1.country5FromData);
		listOfCountry.add(TatkalBooking_DataProfile1.country6FromData);

		listOfId = new ArrayList<String>();
		listOfId.add(TatkalBooking_DataProfile1.Id1FromData);
		listOfId.add(TatkalBooking_DataProfile1.Id2FromData);
		listOfId.add(TatkalBooking_DataProfile1.Id3FromData);
		listOfId.add(TatkalBooking_DataProfile1.Id4FromData);
		listOfId.add(TatkalBooking_DataProfile1.Id5FromData);
		listOfId.add(TatkalBooking_DataProfile1.Id6FromData);

		listOfIdNumber = new ArrayList<String>();
		listOfIdNumber.add(TatkalBooking_DataProfile1.IdNumber1FromData);
		listOfIdNumber.add(TatkalBooking_DataProfile1.IdNumber2FromData);
		listOfIdNumber.add(TatkalBooking_DataProfile1.IdNumber3FromData);
		listOfIdNumber.add(TatkalBooking_DataProfile1.IdNumber4FromData);
		listOfIdNumber.add(TatkalBooking_DataProfile1.IdNumber5FromData);
		listOfIdNumber.add(TatkalBooking_DataProfile1.IdNumber6FromData);

		numberOfMembers = TatkalBooking_DataProfile1.numberOfMembers;
		intNumberOfMembers = Integer.parseInt(numberOfMembers);

		listOfChildName = new ArrayList<String>();
		listOfChildName.add(TatkalBooking_DataProfile1.child1Name);
		listOfChildName.add(TatkalBooking_DataProfile1.child2Name);

		listOfChildAge = new ArrayList<String>();
		listOfChildAge.add(TatkalBooking_DataProfile1.child1Age);
		listOfChildAge.add(TatkalBooking_DataProfile1.child2Age);

		listOfCameraSelection = new ArrayList<String>();
		listOfCameraSelection.add(TatkalBooking_DataProfile1.camera1);
		listOfCameraSelection.add(TatkalBooking_DataProfile1.camera2);
		listOfCameraSelection.add(TatkalBooking_DataProfile1.camera3);
		listOfCameraSelection.add(TatkalBooking_DataProfile1.camera4);
		listOfCameraSelection.add(TatkalBooking_DataProfile1.camera5);
		listOfCameraSelection.add(TatkalBooking_DataProfile1.camera6);
	}

	@Test
	private static void doBooking() throws Exception {

		System.out.println("###################   Starting   ###################");
		System.out.println("");

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);

		// Set implicit timeout later
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Select Eco Tourist Place
		selectEcoTouristPlace();

		// Select Zone
		selectZone();

		if (typeOfBooking.toLowerCase().equalsIgnoreCase("regular")) {
			// select vehicle for Regular : Regular change 1
			selectVehicleForRegularFlow();
		}

		if (typeOfBooking.toLowerCase().equalsIgnoreCase("tatkal")) {
			selectDateForTatkalFlow();// for Tatkal flow
		}

		if (typeOfBooking.toLowerCase().equalsIgnoreCase("regular")) {
			// select Date for Regular flow from test data : Regular change 2
			selectRegularBookingDateInCalendar("29/05/2024"); // for Regular flow
		}

		// click on search button
		clickOnSearchButton();

		// wait for display of table
		waitForDisplayOfTable();

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

		// enter Member details

		fillMemberDetailsTadoba();

		fillChildrenDetails();

		fillTouristAddressAndMobile();

		enterCameraDetails();

		selectAgreement();

		clickOnPayButton();

		if (paymentMode.toLowerCase().equalsIgnoreCase("upi")) {
			doUPIPayment();
		} else if (paymentMode.toLowerCase().equalsIgnoreCase("credit card")) {
			doCreditCardPayment();
		}

		System.out.println("");
		System.out.println("Flow successfully completed");
		System.out.println("###################   Completed   ###################");

	}

	private static void clickOnLinkForRegularFlow() throws InterruptedException {
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody/tr[3]//a)[1]")));
		WebElement availableOption = driver.findElement(By.xpath("(//tbody/tr[3]//a)[1]"));
		maxCountFromLink = driver.findElement(By.xpath("(//tbody/tr[3]//a)[1]")).getText();
		System.out.println("maxCountFromLink is ---> " + maxCountFromLink);
		Thread.sleep(250);
		wait15.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//tbody/tr[3]//a)[1]"))));
		driver.findElement(By.xpath("(//tbody/tr[3]//a)[1]")).click();

	}

	private static void clickOnLinkForTatkalFlow() throws InterruptedException {
		// xpath morning - //tbody/tr[3]/td[6]/a[1]
		// xpath afternoon - //tbody/tr[3]/td[7]/a[1]

		if (shiftFromData.toLowerCase().equalsIgnoreCase("morning")) {

			xpathForLink = "//tbody/tr[3]/td[6]/a[1]";

		} else if (shiftFromData.toLowerCase().equalsIgnoreCase("afternoon")) {

			xpathForLink = "//tbody/tr[3]/td[7]/a[1]";
		}
		System.out.println("Now attempting to check if link is displayed or not ");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(250));

		while (!isElementPresent(driver, By.xpath(xpathForLink))) {

			System.out.println("Link is not displayed yet");
			// Click the button
			driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
			System.out.println("Search button clicked");
			Thread.sleep(500);
			waitForDisplayOfTable();
		}
		System.out.println("Link was displayed , proceeding ahead");
		Thread.sleep(250);
		try {
			wait15.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpathForLink))));
			wait15.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathForLink))));
			maxCountFromLink = driver.findElement(By.xpath(xpathForLink)).getText();
			System.out.println("maxCountFromLink is ---> " + maxCountFromLink);
			Thread.sleep(250);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.findElement(By.xpath(xpathForLink)).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void waitForDisplayOfTable() {
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bookingHtml']")));

	}

	private static void doUPIPayment() {
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Other Payment Modes']")));
		WebElement upiLink = driver
				.findElement(By.xpath("//*[text()='Other Payment Modes']/../../following-sibling::div/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", upiLink);

		wait15.until(ExpectedConditions.urlContains("merchantotherupidisplay"));
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='QRcode']")));
		WebElement qrCode = driver.findElement(By.cssSelector("label[for='QRcode']"));
		qrCode.click();
		wait15.until(ExpectedConditions.urlContains("merchantinterotherconfirm"));
		scrollDownUsingMouse(driver, 5);

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
		WebElement payButton = driver.findElement(By.xpath("//button[@id='btnSubmit']"));
		wait15.until(ExpectedConditions.elementToBeClickable(payButton));
		try {
			payButton.click();
			wait5.until(ExpectedConditions.urlContains("merchant"));
		} catch (Exception e) {
			try {
				payButton.click();
			} catch (Exception e2) {
				System.out.println("Some error - merchant was not seen in URL -->" + driver.getCurrentUrl());
			}
		}
	}

	private static void selectAgreement() {

		WebElement agreementCheckBox = driver.findElement(By.xpath("//input[@id='agree_term']"));
		scrollToElementUsingMouse(driver, agreementCheckBox);
		agreementCheckBox.click();
		wait15.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait10.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath("//th[normalize-space()='Grand Total']"), "Grand Total"));
		scrollToElementUsingMouse(driver, driver.findElement(By.xpath("//button[@id='btnSubmit']")));
		scrollDownUsingMouse(driver, 5);
	}

	private static void enterCameraDetails() {
		if (cameraRequired.toLowerCase().equalsIgnoreCase("yes")) {

			WebElement yesRadio = driver.findElement(By.xpath("(//input[@id='your_camera1'])[1]"));
			yesRadio.click();

			WebElement cameraDropDown = driver.findElement(By.xpath("//select[@id='no_of_camera']"));
			wait15.until(ExpectedConditions.elementToBeClickable(cameraDropDown));
			Select select4 = new Select(driver.findElement(By.xpath("//select[@id='no_of_camera']")));
			select4.selectByVisibleText(numberOfCamera);

			int intNumberOfCamera = Integer.parseInt(numberOfCamera);
			for (int i = 0; i < intNumberOfCamera; i++) {

				String cameraXpath = "(//select[@id='cmbCamera";
				WebElement cameraDropDownElement = driver.findElement(By.xpath(cameraXpath + i + "'])[1]"));
				wait15.until(ExpectedConditions.elementToBeClickable(cameraDropDownElement));
				Select select4A = new Select(driver.findElement(By.xpath(cameraXpath + i + "'])[1]")));
				if (listOfCameraSelection.get(i).equalsIgnoreCase("PointAndShoot")) {
					select4A.selectByIndex(1);
				} else if (listOfCameraSelection.get(i).equalsIgnoreCase("VideoCamera")) {
					select4A.selectByIndex(2);
				}

			}

		} else if (cameraRequired.toLowerCase().equalsIgnoreCase("no")) {
			WebElement noRadio = driver.findElement(By.xpath("(//input[@id='your_camera1'])[2]"));
			noRadio.click();
		}

	}

	private static void fillTouristAddressAndMobile() {

		WebElement touristAdd = driver.findElement(By.xpath("//textarea[@id='address']"));
		touristAdd.clear();
		touristAdd.sendKeys(touristAddress);

		WebElement touristMob = driver.findElement(By.xpath("//input[@id='mobile_no']"));
		touristMob.clear();
		touristMob.sendKeys(touristMobileNumber);

	}

	private static void fillChildrenDetails() {
		int intnumberofChildren = Integer.parseInt(numberOfChildren);
		if (intnumberofChildren > 0) {

			for (int i = 1; i <= intnumberofChildren; i++) {
				// enter name
				String basicXpathChildName = "(//input[@id='children_name";
				WebElement childName = driver.findElement(By.xpath(basicXpathChildName + i + "'])[1]"));
				childName.sendKeys(listOfChildName.get(i - 1));

				// enter age

				String childXpathAge = "(//select[@id='child_age";
				WebElement ageDropDown = driver.findElement(By.xpath(childXpathAge + i + "'])[1]"));
				wait15.until(ExpectedConditions.elementToBeClickable(ageDropDown));
				Select select4 = new Select(driver.findElement(By.xpath(childXpathAge + i + "'])[1]")));
				select4.selectByVisibleText(listOfChildAge.get(i - 1));

			}
		}

	}

	private static void fillMemberDetailsTadoba() throws FindFailed, InterruptedException {
		for (int i = 0; i < maxCount; i++) {

			// fill name
			String basicXpathName = "//input[@id='touristName";
			WebElement touristName = driver.findElement(By.xpath(basicXpathName + i + "']"));
			touristName.clear();
			touristName.sendKeys(listOfName.get(i));

			// fill gender
			String gender = listOfGender.get(i);

			switch (gender) {
			case "Male": {
				String basicXpathMaleGender = "(//input[@name='gender";
				WebElement maleGenderRadio = driver.findElement(By.xpath(basicXpathMaleGender + i + "'])[1]"));
				maleGenderRadio.click();
			}
				break;
			case "Female": {
				String basicXpathFemaleGender = "(//input[@name='gender";
				WebElement femaleGenderRadio = driver.findElement(By.xpath(basicXpathFemaleGender + i + "'])[2]"));
				femaleGenderRadio.click();
			}
				break;
			case "Transgender": {
				String basicXpathTransgender = "(//input[@name='gender";
				WebElement transGenderRadio = driver.findElement(By.xpath(basicXpathTransgender + i + "'])[3]"));
				transGenderRadio.click();
			}
				break;
			default: {
				String basicXpathMaleGender = "(//input[@name='gender";
				WebElement maleGenderRadio = driver.findElement(By.xpath(basicXpathMaleGender + i + "'])[1]"));
				maleGenderRadio.click();
			}
				break;
			}

			// select Age
			String basicXpathAge = "(//select[@id='age";
			WebElement ageDropDown = driver.findElement(By.xpath(basicXpathAge + i + "'])[1]"));
			wait15.until(ExpectedConditions.elementToBeClickable(ageDropDown));
			Select select4 = new Select(driver.findElement(By.xpath(basicXpathAge + i + "'])[1]")));
			select4.selectByVisibleText(listOfAge.get(i));

			// select Country

			String basicXpathCountry = "(//select[@id='cmbCountry";
			WebElement countryDropDown = driver.findElement(By.xpath(basicXpathCountry + i + "'])[1]"));
			wait15.until(ExpectedConditions.elementToBeClickable(countryDropDown));
			Select select5 = new Select(driver.findElement(By.xpath(basicXpathCountry + i + "'])[1]")));
			select5.selectByVisibleText(listOfCountry.get(i));

			// select Identity

			String basicXpathIdentity = "(//select[@id='cmbIndentity";
			WebElement identityDropDown = driver.findElement(By.xpath(basicXpathIdentity + i + "'])[1]"));
			wait15.until(ExpectedConditions.elementToBeClickable(identityDropDown));
			Select select6 = new Select(driver.findElement(By.xpath(basicXpathIdentity + i + "'])[1]")));
			select6.selectByVisibleText(listOfId.get(i));

			// enter identitiy number

			String basicXpathIdentityNumber = "(//input[@id='indentityNo";
			WebElement identityNumberField = driver.findElement(By.xpath(basicXpathIdentityNumber + i + "'])[1]"));
			wait15.until(ExpectedConditions.elementToBeClickable(identityNumberField));
			identityNumberField.sendKeys(listOfIdNumber.get(i));
		}

	}

	private static void selectNumberOfPeopleInDropdown() {
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='no_people']")));
		WebElement numberOfPeopleDropdown = driver.findElement(By.xpath("//select[@id='no_people']"));

		wait15.until(ExpectedConditions.elementToBeClickable(numberOfPeopleDropdown));
		Select select4 = new Select(driver.findElement(By.xpath("//select[@id='no_people']")));

		try {
			select4.selectByVisibleText(String.valueOf(maxCount));
		} catch (Exception e) {

			e.printStackTrace();
			select4.selectByVisibleText(numberOfMembers);
		}

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
		System.out.println(maxCountFromLink);
		maxCount = Integer.parseInt(maxCountFromLink);
		if (intNumberOfMembers < maxCount) {
			maxCount = intNumberOfMembers;
		}
		if (maxCount > 6) {
			maxCount = 6;
		}
		System.out.println("Updated max count is " + maxCount);
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
		WebElement zoneDropdown = driver.findElement(By.xpath("//select[@id='cmbZone']"));
		wait15.until(ExpectedConditions.elementToBeClickable(zoneDropdown));
		wait15.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//select[@id='cmbZone']"),
				TatkalBooking_DataProfile1.zoneFromData));
		Select select4 = new Select(driver.findElement(By.xpath("//select[@id='cmbZone']")));
		select4.selectByVisibleText(TatkalBooking_DataProfile1.zoneFromData);

	}

}
