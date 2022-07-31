package step.definition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import page.objects.RetailPageObject;
import utilities.Utils;

public class RetailStepDefinition extends Base{
	
	RetailPageObject retailpageobject = new RetailPageObject();

	@Given("User is on Retail website")
	public void user_is_on_retail_website() {
		String expectedText = "TEST ENVIRONMENT";
		String textFromUI = retailpageobject.getTestEnvironmentText();
		Assert.assertEquals(expectedText, textFromUI);
	}
	@And("User click on MyAccount")
	public void  user_click_on_myAccount() {
		retailpageobject.clickOnMyAccountButton();
		logger.info("My account button clicked successfully");
		Utils.hardWait(1000);
	}
	@When("User click on Login")
	public void user_click_on_login() {
		retailpageobject.clickOnLoginLink();
		logger.info("Login link clicked successfully");
		Utils.hardWait(1000);
	}
	@And("User enter username {string} and password {string}")
	public void user_enter_username_and_password(String email, String password) {
		retailpageobject.enterEmail("masoom.hussaini010@tiger.com");
		retailpageobject.enterPassword("space!1");
		logger.info("username and password were able to login successfully");
	}
	@And("User click on Login button")
	public void user_click_on_login_button() {
		retailpageobject.clickOnLoginButton();
		logger.info("Login button was clicked successfully");
	}
	@Then("User should be logged in to MyAccount dashboard")
	public void  user_should_be_logged_in_to_myaccount_dashboard() {
		String expectedText = "My Account";
		String ActualTextfromUI = retailpageobject.getMyAccountDashboardText();
		Assert.assertEquals(expectedText, ActualTextfromUI);
		logger.info("My Account text was verified successfully");
		Utils.hardWait(1000);
		try {
			Utils.takeScreenShot("My Account dashboard");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@When("User click on Register for an Affiliate Account link")
	public void user_click_on_register_for_an_affiliate_account_link() {
		retailpageobject.clickOnRegisterAffiliateAccLink();
		logger.info("Register for an affiliate account link was clicked successfully");
	}
	@When("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		retailpageobject.enterCompanyName(data.get(0).get("company"));
		retailpageobject.enterWebsite(data.get(0).get("website"));
		retailpageobject.enterTaxID(data.get(0).get("taxID"));
		retailpageobject.enterPaymentMethod(data.get(0).get("paymentMethod"));
		logger.info("Register as an Affiliate user with cheque payment filled-out successfully");
		Utils.hardWait(1000);
	}
	@When("User check on About us check box")
	public void user_check_on_about_us_check_box() {
		retailpageobject.clickOnAboutUsCheckBox();
		logger.info("The check box for About us clicked successfully");
		Utils.hardWait(1000);
	}
	@When("User click on Continue button")
	public void user_click_on_continue_button() {
	    retailpageobject.clickOncontinueButton();
	    logger.info("Continue button was clicked successfully");
	}
	
	@Then("User should see a success message")
	public void user_should_see_a_success_message() {
		String expectedMessage = "Success: Your account has been successfully updated.";
		String actualMessagefromUI = retailpageobject.getSuccessMessage();
		Assert.assertEquals(expectedMessage, actualMessagefromUI);
		Utils.hardWait(1000);
		logger.info("success message verified successfully ");
		try {
		Utils.takeScreenShot("Cheque payment success message");
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	@When("User click on Edit your affiliate information link")
	public void user_click_on_edit_your_affiliate_information_link() {
		retailpageobject.clickOnEditAffiliatLink();
		logger.info("Edit your affiliate information link was clicked successfully");
	}
	@When("user click on Bank Transfer radio button")
	public void user_click_on_bank_transfer_radio_button() {
		retailpageobject.clickOnBankTransferButton();
		logger.info("User clicked on bank transfer radio button successfully");
	}
	@When("User fill Bank information with below information")
	public void user_fill_bank_information_with_below_information(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		retailpageobject.enterBankName(data.get(0).get("bankName"));
		retailpageobject.enterAbaNumber(data.get(0).get("abaNumber"));
		retailpageobject.enterSwiftCode(data.get(0).get("swiftCode"));
		retailpageobject.enterAccountName(data.get(0).get("accountName"));
		retailpageobject.enterAccountNumber(data.get(0).get("accountNumber"));
		logger.info("Bank account information filled-out successfully");
		Utils.hardWait(1000);
	}
	@When("User click on Edit your account information link")
	public void user_click_on_edit_your_account_information_link() {
		retailpageobject.clickOnEditAcctLink();
		logger.info("User clicked edit account link Successfully");
	}
	@When("User modify below information")
	public void user_modify_below_information(DataTable dataTable) {
		List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
		retailpageobject.enterFirstName(data.get(0).get("firstname"));
		retailpageobject.enterLastName(data.get(0).get("lastName"));
		retailpageobject.enterEmailAddress(data.get(0).get("email"));
		retailpageobject.enterTelephoneNumber(data.get(0).get("telephone"));
		logger.info("Account information modified successfully");
	}
	@Then("User should see a message Success: {string}")
	public void user_should_see_a_message_success(String successMessage) {
		String expectedMessage = "Success: Your account has been successfully updated.";
		String actualMessagefromUI = retailpageobject.getSuccessMessage();
		Assert.assertEquals(expectedMessage, actualMessagefromUI);
		logger.info("success message verified successfully ");
		try {
		Utils.takeScreenShot("Edit Account success message");
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	}
}
