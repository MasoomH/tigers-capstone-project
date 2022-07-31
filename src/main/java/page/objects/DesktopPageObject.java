package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class DesktopPageObject extends Base{
	public DesktopPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	//Scenario 1
	@FindBy(xpath = "//a[text()='Desktops']")
	private WebElement desktopsTab;
	@FindBy(xpath = "//a[text() ='Show All Desktops']")
	private WebElement showAllDesktopsLink;
	@FindBy(tagName = "img")
	private List <WebElement> items; 
	
	public void clickOnDesktopsTab() {
		//desktopsTab.click();
		Actions action = new Actions(driver);
		action.moveToElement(desktopsTab).perform();
	}
	public void clickOnshowAllDesktops() {
		showAllDesktopsLink.click();
	}
	public List<WebElement> desktopsItemsList() {
		List<WebElement> desktopsItems = items;
		return desktopsItems;
	}
	
	//Scenario 2
	@FindBy(xpath = "(//span[text()='Add to Cart'])[3]")
	private WebElement HPLp3065AddToCartLink;
	@FindBy(id = "input-quantity")
	private WebElement quantityField;
	@FindBy(id = "button-cart")
	private WebElement addToCartButton;
	@FindBy(xpath = "(//a[text()='HP LP3065'])[3]")
	private WebElement HPLP3065successMessage;
	
	public void clickOnAddToCartOfHPLp3065() {
		HPLp3065AddToCartLink.click();
	}
	public void selectQuantityField(String quantityValue) {
		quantityField.clear();
		quantityField.sendKeys(quantityValue);
	}
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	public String successMessage() {
		String actualResult = "Success: You have added " + HPLP3065successMessage.getText() +  " to your shopping cart!";
		return actualResult;
	}

	//Scenario 3
	@FindBy (xpath = "(//span[text()='Add to Cart'])[2]")
	private WebElement canonEOS5DAddToCartLink;
	@FindBy (xpath = "//select[@id='input-option226']/option[2]")
	private WebElement redColorDropdown;
	@FindBy (xpath = "(//a[text()='Canon EOS 5D Camera'])[3]")
	private WebElement canonEOS5DSuccessMessage;
	
	public void clickOnCanonEOS5DAddToCartLink() {
		canonEOS5DAddToCartLink.click();
	}
	public void selectRedColorInDropdown() {
		redColorDropdown.click();
	}
	public String canonSuccessMessage() {
		String actualResult = "Success: You have added " + canonEOS5DSuccessMessage.getText()+ " to your shopping cart!";
		return actualResult; 
	}

	//Scenario 4
	@FindBy (xpath ="//a[text()='Canon EOS 5D Camera']")
	private WebElement canonEOS5Ditem;
	@FindBy (xpath = "//a[text()='Write a review']")
	private WebElement writeReviewLink;
	@FindBy (id = "input-name")
	private WebElement yourNameField;
	@FindBy (id = "input-review")
	private WebElement yourReviewField;
	@FindBy (xpath = "//input[@type='radio']")
	private List <WebElement> rating;
	@FindBy (id = "button-review")
	private WebElement continueButton;
	@FindBy (xpath = "(//div[@class='alert alert-success alert-dismissible'])")
	private WebElement reviewSubmissionMessage;
	
	public void clickOnCanonEOS5Ditems() {
		canonEOS5Ditem.click();
	}
	public void clickOnWriteReviewLink() {
		writeReviewLink.click();	
	}
	public void enterName(String yourName) {
		yourNameField.sendKeys(yourName);
	}
	public void enterReview(String yourReview) {
		yourReviewField.sendKeys(yourReview);
	}
	public void selectRating(String ratingValue) {
		List<WebElement> ratingElements = rating;
		for(WebElement element:ratingElements) {
			if(element.getAttribute("value").equalsIgnoreCase(ratingValue.trim())) {
				element.click();
				break;
			}
		}
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public boolean reviewSuccessMessage() {
		if(reviewSubmissionMessage.isDisplayed())
		return true;
		else
		return false;
	}
	
	
	
	
	

}
