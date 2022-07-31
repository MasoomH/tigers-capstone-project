package utilities;


	import java.io.File;

	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Properties;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import core.Base;
	import io.cucumber.java.Scenario;



	public class Utils extends Base{

	public static Scenario verify;

	public static void hoveMouseOverElement(WebElement element) {
	Actions actions = new Actions(driver);
	actions.moveToElement(element).perform();
	}

	public static String getTextFromUI(WebElement element) {
	String textFromUI = element.getText();
	return textFromUI;
	}

	public static void clickOnRadioButton(WebElement element) {
	try {
	if(element.isDisplayed() == true && element.isEnabled() == true && element.isSelected() == false) {
	element.click();
	}else {
	System.out.println("One of the conditions did not return expected value");
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	public static void clickOnCheckBoxButton(WebElement element) {
	try {
	if(element.isDisplayed() == true && element.isEnabled() == true && element.isSelected() == false) {
	element.click();
	}else {
	System.out.println("One of the conditions did not return expected value");
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	// method for taking screenshots
	public static void takeScreenShot(String screenshotName) throws IOException {
	// we need to create a folder at project level and store the path here so that
	// when even we take screenshots, they are all saved in that specific folder
	String path = ".\\output\\screenshots\\";
	// I create object of the file class
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	// After taking the screenshot, take the file and store it in a location in my
	// computer
	// and also I want to provide the file_name and the extension
	try {
	FileUtils.copyFile(file, new File(path + screenshotName + ".png"));
	} catch (Exception e) {
	e.printStackTrace();
	System.out.println("takeScreenshot: => Exception was throw during execution");
	}
	}


	// JSExecutor methods start
	// .click()
	// if the .click() does not work, then we get the help JSExecuter
	public static void clickWithJSE(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", element);
	}

	// How we can give border to an element on webpage
	public static void highlightelementRedBorder(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].style.border='2px solid red'", element);
	}

	// How we can highlight an element background
	public static void highlightelementBackground(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].style.background='yellow'", element);
	}

	// What if we want to do both/above with same method?
	// give border and highlight
	public static void highlightelementBorderAndBackground(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}

	// How we can scroll down the page with JSExecutor
	public static void scrolldownPage() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	// from (0, 1000), you can modify the 100 field and scroll down the page as per
	// your testing needs
	js.executeScript("window.scrollBy(0, 1000)");
	// scroll all the way down the page
	// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}



	// how to sendkeys with JSExecutor
	public static void sendKeys(WebElement element, String value) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].value='" + value + "'", element);
	}



	/**
	* This method will select the value from static Dropdown by visible value
	*/
	public static void selectByVisibleText(WebElement element, String text) {
	Select select = new Select(element);
	select.selectByVisibleText(text);
	}



	/**
	* This method will select value from static Dropdown by index
	*/
	public static void selectByIndex(WebElement element, int index) {
	Select select = new Select(element);
	select.selectByIndex(index);
	}



	/**
	* This method will select value from static dropdown by value
	*/
	public static void selectByValue(WebElement element, String value) {
	Select select = new Select(element);
	select.selectByValue(value);
	}



	/**
	* This method accepts alerts
	*/
	public static void acceptAlert() {
	driver.switchTo().alert().accept();
	}



	public static void dismissAlert() {
	driver.switchTo().alert().dismiss();
	}

	
	/////This method will switch webdriver from parent window to child
	
	public static void switchToWindow() {
	Set<String> WindowsHandles = driver.getWindowHandles();
	Iterator<String> it = WindowsHandles.iterator();
	String window = it.next();
	driver.switchTo().window(window);
	}


	/////This method will return text of element
	
	public static String getText(WebElement ele) {
	String ElementText = ele.getText();
	return ElementText;
	}

	/////This method will drag and drop using Actions class
	
	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
	Actions action = new Actions(driver);
	action.dragAndDrop(sourceElement, targetElement).perform();

	}
	
	//this method will help us to use hard wait during test execution if we need to debugg our test script
	//or if we want to pause our test execution for checking our test
	public static void hardWait(int timeUnit) {
		try {
			Thread.sleep(timeUnit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

	/////////////////read test data from testData.properties file	////////////////////////////////////
	public static String getData(String key) {													////////
	String testDataPath = ".\\src\\test\\resources\\input\\testData.properties";				////////
	Properties property = null;																	////////
	try {																						////////
	FileReader reader = new FileReader(testDataPath);											////////
	property = new Properties();																////////
	property.load(reader);																		////////
	} catch (FileNotFoundException e) {															////////
	e.printStackTrace();																		////////
	} catch (IOException e) {																	////////
	e.printStackTrace();																		////////
	}																							////////
	return property.getProperty(key);															////////			
	}																							////////	
	////////////////////////////////////////////////////////////////////////////////////////////////////
}
