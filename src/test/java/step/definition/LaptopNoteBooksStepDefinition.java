package step.definition;


import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import core.Base;
import io.cucumber.java.en.*;

import page.objects.LaptopNoteBooksPageObject;
import utilities.Utils;

public class LaptopNoteBooksStepDefinition extends Base{
	LaptopNoteBooksPageObject laptopNoteBooksPageObject = new LaptopNoteBooksPageObject();
	
	@When("User click on Laptop &NoteBook tab")
	public void user_click_on_laptop_note_book_tab() {
		Utils.hardWait(1000);
		laptopNoteBooksPageObject.clickOnLaptopsNotebooksTab();
		logger.info("User clicked Laptop & NoteBook tab successfully");
	}
	@When("User click on Show all Laptop &NoteBook option")
	public void user_click_on_show_all_laptop_note_book_option() {
		Utils.hardWait(1000);
		laptopNoteBooksPageObject.clickShowAllLaptopNoteBookOption();
		logger.info("User clicked on Show All Laptop & NoteBoook Option");
	}
	@And("User click on MacBook item")
	public void user_click_on_mac_book_item() {
		Utils.hardWait(1000);
		laptopNoteBooksPageObject.clickOnMacBookItem();
		logger.info("User clicked on MacBook Item successfully");
	}
	@Then("User should see a message Success: You have added MacBook to your shopping cart!")
	public void user_should_see_a_message_success_you_have_added_mac_book_to_your_shopping_cart() {
		laptopNoteBooksPageObject.showMacBookSuccessMessage();
		logger.info("User saw a success message of adding MacBook to shopping cart successfully ");
	}
	@And("User should see {string} showed to the cart")
	public void user_should_see_showed_to_the_cart(String expected) {
		Assert.assertTrue(expected, laptopNoteBooksPageObject.getCartTotalShowText());
		logger.info("User saw " + laptopNoteBooksPageObject.getCartTotalShowText()+ " showed to the cart successfully");
	}
	@Then("User click on cart option")
	public void user_click_on_cart_option() {
		Utils.hardWait(1000);
		laptopNoteBooksPageObject.clickOnCartOption();
		logger.info("User clicked on cart option successfully");
	}
	@Then("user click on red X button to remove the item from cart")
	public void user_click_on_red_x_button_to_remove_the_item_from_cart() {
		Utils.hardWait(1000);
		laptopNoteBooksPageObject.clickOnRedXButton();
		logger.info("User clicked on red X button to remove the item from cart successfully");
	}
	@Then("item should be removed and cart should show {string}")
	public void item_should_be_removed_and_cart_should_show(String expected) {
		Utils.hardWait(1000);
		Assert.assertTrue(expected,laptopNoteBooksPageObject.showNoItemsOnCart());
		logger.info("Items removed and cart show " + laptopNoteBooksPageObject.showNoItemsOnCart() + " successfully" );
		try {
			Utils.takeScreenShot("Item Removed from cart");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@When("User click on product comparison icon on ‘MacBook’")
	public void user_click_on_product_comparison_icon_on_mac_book() {
		laptopNoteBooksPageObject.clickOnMacBookCompareIcon();
		logger.info("User clicked on MacBook comparison icon successfully");
	}
	@When("User click on product comparison icon on ‘MacBook Air")
	public void user_click_on_product_comparison_icon_on_mac_book_air() {
		laptopNoteBooksPageObject.clickOnMacBookAirCompareIcon();
		logger.info("User click on MacBook Air comparison icon successfully");
	}
	@Then("User should see a message Success: You have added MacBook Air to your product comparison!")
	public void user_should_see_a_message_success_you_have_added_mac_book_air_to_your_product_comparison() {
		laptopNoteBooksPageObject.macBookAirSuccessMessage();
		Utils.hardWait(1000);
		logger.info("User saw a success message of adding MacBookAir to comparison successfully ");
	}
	@Then("User click on Product comparison link")
	public void user_click_on_product_comparison_link() {
		laptopNoteBooksPageObject.clickOnProductComparisonLink();
		Utils.hardWait(1000);
		logger.info("User clicked on Product comparison link successfully");
	}
	@Then("User should see Product Comparison Chart")
	public void user_should_see_product_comparison_chart() {
		List<WebElement> productElements = laptopNoteBooksPageObject.productCompareList();
		for (WebElement element:productElements) {
			Assert.assertTrue(element.isDisplayed());
			Utils.hardWait(1000);
			logger.info(element.getAttribute("table") + " is perent successfully");
		}
		try {
			Utils.takeScreenShot("Product Comparison Chart");
		} catch (IOException e) {
			e.printStackTrace();
		}	
		}
	@When("User click on heart icon to add {string} laptop to wish list")
	public void user_click_on_heart_icon_to_add_laptop_to_wish_list(String string) {
		laptopNoteBooksPageObject.clickOnsonyVAIOHeartIcon();
		logger.info("User clicked on Sony VAIO heart icon Successfully");
	}
	@Then("User should get a message {string}")
	public void user_should_get_a_message(String expectedMessage) {
		Assert.assertEquals(laptopNoteBooksPageObject.sonyVAIOSuccessMessage(), expectedMessage);
		logger.info("User got a message Successfully");
		try {
			Utils.takeScreenShot("Sony VAIO laptop Message");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@When("User click on {string} item")
	public void user_click_on_item(String string) {
		laptopNoteBooksPageObject.clickOnmacBookProItem();
		logger.info("User clicked on MacBookPro item successfully");
	}
	@Then("User should see {string} price tag is present on UI.")
	public void user_should_see_price_tag_is_present_on_ui(String expectedPriceTag) {
		Assert.assertTrue(expectedPriceTag, laptopNoteBooksPageObject.seeMacBookProPriceTag());
		logger.info("User was able to see the price tag successfully");
		try {
			Utils.takeScreenShot("MacBookPro price tag");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
