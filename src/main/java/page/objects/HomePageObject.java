package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class HomePageObject extends Base{
	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}
	//Scenario 1
	@FindBy (xpath = "//span[text()='Currency']")
	private WebElement currency;
	@FindBy (xpath = "//ul[@class='dropdown-menu']//li[1]")
	private WebElement euroDropdown;
	@FindBy (xpath = "//strong[text()='€']")
	private WebElement euroCurrencyValue;
	public void clickOnCurrencyLink() {
		currency.click();
	}
	public void choseOnEuroDropdown() {
		euroDropdown.click();
	}
	public void isEuroCurrencyValueDisplayed() {
		euroCurrencyValue.getText();
	}
	
	//Scenario 2 
	@FindBy (xpath = "//span[text()='Shopping Cart']")
	private WebElement shoppingCartLink;
	@FindBy (xpath = "(//p[text()='Your shopping cart is empty!'])[2]")
	private WebElement emptyShoppingCart;
	public void clickOnShoppingCart() {
		shoppingCartLink.click();
	}
	public String showEmptyCartMessage() {
		String actualtextFromUI = emptyShoppingCart.getText();
		return actualtextFromUI;
	}

	
}
