package step.definition;

import java.io.IOException;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.*;

import page.objects.HomePageObject;
import utilities.Utils;

public class HomePageStepDefinition extends Base {
	HomePageObject homePageObject = new HomePageObject();
	
	@When("User click on Currency")
	public void user_click_on_currency() {
		homePageObject.clickOnCurrencyLink();
		logger.info("User clicked on Currency link successfully");  
	}
	@When("User Chose Euro from dropdown")
	public void user_chose_Euro_from_dropdown() {
		Utils.hardWait(1000);
		homePageObject.choseOnEuroDropdown();
		logger.info("User chose the Euro currency from dropDown successfully");
	}
	@Then("currency value should change to Euro")
	public void currency_value_should_change_to_Euro() {
		Utils.hardWait(1000);
		homePageObject.isEuroCurrencyValueDisplayed();
		logger.info("currency value changed to Euro successfully");
		try {
			Utils.takeScreenShot("Euro Currency Display");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@When("User click on shopping cart")
	public void user_click_on_shopping_cart() {
		Utils.hardWait(1000);
		homePageObject.clickOnShoppingCart();
		logger.info("User clicked on shopping cart successfully");
	}
	@Then("{string} message should display")
	public void message_should_display(String expected) {
		Assert.assertEquals(homePageObject.showEmptyCartMessage(),expected);
		Utils.hardWait(1000);
		logger.info(homePageObject.showEmptyCartMessage() + " message was displayed");
		try {
			Utils.takeScreenShot("Empty Cart Message");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
