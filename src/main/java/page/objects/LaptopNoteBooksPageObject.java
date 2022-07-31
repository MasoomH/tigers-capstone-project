package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class LaptopNoteBooksPageObject extends Base{
	public  LaptopNoteBooksPageObject() {
		PageFactory.initElements(driver, this);
	}
	// Senario 1
	@FindBy (xpath = "//a[text()='Laptops & Notebooks']")
	private WebElement LaptopsNotebooksTab;
	@FindBy (xpath = "//a[text()='Show All Laptops & Notebooks']")
	private WebElement showAllLaptopNoteBookOption;
	@FindBy (xpath = "//a[text()='MacBook']")
	private WebElement macBookItem;
	@FindBy (id = "button-cart")
	private WebElement cartButton;
	@FindBy (xpath = "(//a[text()='MacBook'])[3]")
	private WebElement macBookMessage;
	@FindBy (id = "cart-total")
	private WebElement cartShow;
	@FindBy (id = "cart")
	private WebElement cartOption;
	@FindBy (xpath = "//button[@title='Remove']")
	private WebElement redXbutton;
	
	public void clickOnLaptopsNotebooksTab() {
		LaptopsNotebooksTab.click();
	}
	public void clickShowAllLaptopNoteBookOption() {
		showAllLaptopNoteBookOption.click();
	}
	public void clickOnMacBookItem() {
		macBookItem.click();
	}
	public void clickOnCartButton() {
		cartButton.click();	
	}
	public String showMacBookSuccessMessage() {
		String actualMacBookMessagfromUI = "Success: You have added "+macBookMessage.getText()+" to your shopping cart!";
		return actualMacBookMessagfromUI;
	}
	public boolean getCartTotalShowText() {
		if (cartShow.getText().equalsIgnoreCase("1 item(s) - $602.00"))
			return true;
		else
			return false;	
	}
	public void clickOnCartOption() {
		cartOption.click();
	}
	public void clickOnRedXButton() {
		redXbutton.click();
	}
	public boolean showNoItemsOnCart() {
		if (cartShow.isDisplayed())
			return true;
		else
			return false;
	}
	
	//Senario 2
	@FindBy (xpath = "(//i[@class='fa fa-exchange'])[2]")
	private WebElement macBookCompareIcon;
	@FindBy (xpath = "(//i[@class='fa fa-exchange'])[3]")
	private WebElement macBookAirCompareIcon;
	@FindBy (xpath = "(//a[text()='MacBook Air'])[1]")
	private WebElement macBookAirMessage;
	@FindBy (xpath = "//a[text()='product comparison']")
	private WebElement productComparisonLink;
	@FindBy(tagName = "table")
	private List <WebElement> product; 
	
	public void clickOnMacBookCompareIcon() {
		macBookCompareIcon.click();
	}
	public void clickOnMacBookAirCompareIcon() {
		macBookAirCompareIcon.click();
	}
	public String macBookAirSuccessMessage() {
		String ActualMacBookAirMessageFromUI = "Success: You have added "+ macBookAirMessage.getText() +" to your product comparison!";
		return ActualMacBookAirMessageFromUI;
	}
	public void clickOnProductComparisonLink() {
		productComparisonLink.click();
	}
	public List<WebElement> productCompareList() {
		List<WebElement> productCompareChart = product;
		return productCompareChart;
	}
	
	//Scenario 3
	@FindBy (xpath = "(//button[@data-original-title='Add to Wish List'])[5]")
	private WebElement sonyVAIOHeartIcon;
	@FindBy (xpath = "(//a[text()='Sony VAIO'])[1]")
	private WebElement sonyVAIOmessage;
	
	public void clickOnsonyVAIOHeartIcon() {
		sonyVAIOHeartIcon.click();
	}
	public String sonyVAIOSuccessMessage() {
		String ActualsonyVAIOMessageFromUI = "You must login or create an account to save "+sonyVAIOmessage.getText() +" to your wish list!";
		return ActualsonyVAIOMessageFromUI;	
	}
	
	//Scenario 4
	@FindBy (xpath = "(//a[text()='MacBook Pro'])[1]")
	private WebElement macBookProItem;
	@FindBy (xpath = "//h2[text()='$2,000.00']")
	private WebElement priceTag;
	
	public void clickOnmacBookProItem() {
		if (macBookProItem.getText().equalsIgnoreCase("MacBook Pro"))
			macBookProItem.click();
		else
			System.out.println("****Element NOT found with get text****");;
	}
	public boolean seeMacBookProPriceTag() {
			if (priceTag.isDisplayed())
				return true;
			else
				return false; 
	}		
}
