@TestAllPages
Feature: Retail Page
Background:
Given User is on Retail website 
And User click on MyAccount
When User click on Login 
And User enter username 'userName' and password 'password'
And User click on Login button
Then User should be logged in to MyAccount dashboard

Scenario: Register as an Affiliate user with Cheque Payment Method
When User click on Register for an Affiliate Account link 
And User fill affiliate form with below information
|company|website|taxID|paymentMethod|
|toyota|www.toyota.com|13121LXR|cheque|
And User check on About us check box 
And User click on Continue button 
Then User should see a success message 

Scenario: Edit your affiliate information from Cheque payment method to Bank Transfer
When User click on Edit your affiliate information link 
And user click on Bank Transfer radio button
And User fill Bank information with below information
|bankName|abaNumber|swiftCode|accountName|accountNumber|
|WellsFargo|Columbia|7887231SW|Masoom Hussaini|1122334455|
And User click on Continue button 
Then User should see a success message 

Scenario: Edit your account Information 
When User click on Edit your account information link 
And User modify below information 
|firstname|lastName|email|telephone|
|Ahmad|Ahmadi|Ahmad.Ahmadi013@gmail.com|2223334444|
And User click on Continue button 
Then User should see a message Success: 'Your account has been successfully updated.'

