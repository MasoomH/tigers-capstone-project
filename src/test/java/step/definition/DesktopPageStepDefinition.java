package step.definition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import page.objects.DesktopPageObject;
import utilities.Utils;

public class DesktopPageStepDefinition extends Base{
	DesktopPageObject desktopPageObject = new DesktopPageObject();

	@When("User click on Desktops tab")
	public void user_click_on_desktops_tab() {
		Utils.hardWait(2000);
		desktopPageObject.clickOnDesktopsTab();
		logger.info("user clicked Desktops tab successfully");
	}
	@When("User click on Show all desktops")
	public void user_click_on_show_all_desktops() {
		Utils.hardWait(2000);
		desktopPageObject.clickOnshowAllDesktops();
		logger.info("User clicked on show all desktops link successfully");
	}
	@Then("User should see all items are present in Desktop page")
	public void user_should_see_all_items_are_present_in_desktop_page() {
		List<WebElement> desktopsElements = desktopPageObject.desktopsItemsList();
		for (WebElement element:desktopsElements) {
			Assert.assertTrue(element.isDisplayed());
			logger.info(element.getAttribute("title") + " is perent successfully");
		}
		try {
			Utils.takeScreenShot("DesktopAllItems");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@When("User click ADD TO CART option on HP LP3065 item")
	public void user_click_add_to_cart_option_on_hp_lp3065_item() {
		desktopPageObject.clickOnAddToCartOfHPLp3065();
		logger.info("User clicked on Add to Cart Option on HP LP3065 successfully");
	}
	@When("User select quantity {string}")
	public void user_select_quantity(String string) {
		desktopPageObject.selectQuantityField(string);
		logger.info("User select quantity and sent value successfully");
	}
	@When("User click add to Cart button")
	public void user_click_add_to_cart_button() {
		desktopPageObject.clickOnAddToCartButton();
		logger.info("User clicked add to Cart button successfully");
	}
	@Then("User should see a message{string}")
	public void user_should_see_a_message(String expectedSuccessMessage) {
		Assert.assertEquals(desktopPageObject.successMessage(), expectedSuccessMessage);
		logger.info(expectedSuccessMessage+ " equals to " + desktopPageObject.successMessage());
	try {
		Utils.takeScreenShot("HPLP3065 Success Message");
	} catch (IOException e) {
		e.printStackTrace();
	}

	}
	@When("User click ADD TO CART option on Canon EOS 5D item")
	public void user_click_add_to_cart_option_on_canon_eos_5d_item() {
		desktopPageObject.clickOnCanonEOS5DAddToCartLink();
		logger.info("User clicked on Add to Cart Option on Canon EOS 5D successfully");
	}
	@When("User select color from dropdown Red")
	public void user_select_color_from_dropdown_red() {
		desktopPageObject.selectRedColorInDropdown();
		logger.info("User selected Red color from dropdown successfully");
	}
	@Then("User should see a message {string}")
	public void user_should_see_a_message_(String expectedSuccessMessage) {
		Assert.assertEquals(desktopPageObject.canonSuccessMessage(), expectedSuccessMessage);
		logger.info(expectedSuccessMessage + " equals to " + desktopPageObject.canonSuccessMessage());
		try {
			Utils.takeScreenShot("CanonEOS5D Camera Success Message");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@When("User click on Canon EOS 5D item")
	public void user_click_on_canon_eos_5d_item() {
		desktopPageObject.clickOnCanonEOS5Ditems();
		logger.info("User clicked on Canon EOS 5D item successfully");
	}
	@When("User click on write a review link")
	public void user_click_on_write_a_review_link() {
		desktopPageObject.clickOnWriteReviewLink();
		logger.info("User clicked on write a review link successfully");
	}
	@When("user fill the review information with below information")
	public void user_fill_the_review_information_with_below_information(DataTable dataTable) {
		List<Map<String,String>> reviewInformation = dataTable.asMaps(String.class, String.class);
		desktopPageObject.enterName(reviewInformation.get(0).get("yourname"));
		desktopPageObject.enterReview(reviewInformation.get(0).get("yourReview"));
		desktopPageObject.selectRating(reviewInformation.get(0).get("Rating"));
		logger.info("User filled the review information successfully");
	}
	@When("User click on Continue Button")
	public void user_click_on_continue_button() {
		desktopPageObject.clickOnContinueButton();
		logger.info("User clicked on Continue Button successfully");
	}
	@Then("User should see a message with {string}")
	public void user_should_see_a_message_with(String expectedSuccessMessage) {
		Assert.assertTrue(desktopPageObject.reviewSuccessMessage());
		logger.info(expectedSuccessMessage + " Equal to "+ desktopPageObject.reviewSuccessMessage()+ " sucessfully");
		try {
			Utils.takeScreenShot("Review Success Message");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
