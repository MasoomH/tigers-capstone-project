package page.objects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.Utils;

public class RetailPageObject extends Base{
	public RetailPageObject() {
		PageFactory.initElements(driver, this);
	}

	//Background:
	@FindBy(xpath = "//a[text()='TEST ENVIRONMENT']")
	private WebElement testEnvironmentText;
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountButton;
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginLink;
	@FindBy(id = "input-email")
	private WebElement emailField;
	@FindBy(id = "input-password")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccountDashboard;
	
	public String getTestEnvironmentText() {
		String textFromUI =testEnvironmentText.getText();
		return textFromUI;
	}
	public void clickOnMyAccountButton() {
		myAccountButton.click();
	}
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public String getMyAccountDashboardText() {
		String myAccountText = myAccountDashboard.getText();
		return myAccountText;
	}
	
	//Scenario 1
	@FindBy(xpath = "//a[text()='Register for an affiliate account']")
	private WebElement registerAffiliateAccLink;
	@FindBy(id = "input-company")
	private WebElement companyField;
	@FindBy(id = "input-website")
	private WebElement websiteField;
	@FindBy(id = "input-tax")
	private WebElement taxIDField;
	@FindBy(id = "input-cheque")
	private WebElement chequePayeeField;
	@FindBy(name = "agree")
	private WebElement aboutUsCheckBox;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath = "//div[@id='account-account']/div[1]")
	private WebElement successMessage;
	
	public void clickOnRegisterAffiliateAccLink() {
		registerAffiliateAccLink.click();
	}
	public void enterCompanyName(String company) {
		companyField.sendKeys(company);
	}
	public void enterWebsite(String website) {
		websiteField.sendKeys(website);
	}
	public void enterTaxID(String taxID) {
		taxIDField.sendKeys(taxID);
	}
	public void enterPaymentMethod(String paymentMethod) {
		chequePayeeField.sendKeys(paymentMethod);
	}
	public void clickOnAboutUsCheckBox() {
		//aboutUsCheckBox.click();
		Utils.clickOnCheckBoxButton(aboutUsCheckBox);
	}
	public void clickOncontinueButton() {
		continueButton.click();
	}
	public String getSuccessMessage() {
		String successMessageText = successMessage.getText();
		return successMessageText;
	}
	
	//Scenario 2 
	@FindBy(xpath = "//a[text()='Edit your affiliate information']")
	private WebElement editAffiliatLink;
	@FindBy(xpath = "//input[@value='bank']")
	private WebElement bankTransferButton;
	@FindBy(id = "input-bank-name")
	private WebElement bankNameField;
	@FindBy(id = "input-bank-branch-number")
	private WebElement abaNumberField;
	@FindBy(id = "input-bank-swift-code")
	private WebElement swiftCodeField;
	@FindBy(id = "input-bank-account-name")
	private WebElement accountNameField;
	@FindBy(id = "input-bank-account-number")
	private WebElement accountNumberField;

	public void clickOnEditAffiliatLink() {
		editAffiliatLink.click();
	}
	public void clickOnBankTransferButton() {
		bankTransferButton.click();
	}
	public void enterBankName(String bankName) {
		bankNameField.sendKeys(bankName);
	}
	public void enterAbaNumber(String abaNumber) {
		abaNumberField.sendKeys(abaNumber);
	}
	public void enterSwiftCode(String swiftCode) {
		swiftCodeField.sendKeys(swiftCode);
	}
	public void enterAccountName(String accountName) {
		accountNameField.sendKeys(accountName);
	}
	public void enterAccountNumber(String accountNumber) {
		accountNumberField.sendKeys(accountNumber);
	}

	//Scenario 3 
	@FindBy(xpath = "//div[@id='content']/ul[1]/li[1]/a")
	private WebElement editAcctLink;
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	@FindBy(id = "input-email")
	private WebElement newEmailField;
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	public void clickOnEditAcctLink() {
		editAcctLink.click();
	}
	public void enterFirstName(String firstname) {
		firstNameField.clear();
		firstNameField.sendKeys(firstname);
	}
	public void enterLastName(String lastName) {
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
	}
	public void enterEmailAddress(String email) {
		newEmailField.clear();
		newEmailField.sendKeys(email);
	}
	public void enterTelephoneNumber(String telephone) {
		telephoneField.clear();
		telephoneField.sendKeys(telephone);
	}
}
