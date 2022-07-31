@TestAllPages
Feature: Desktops Tab

Background: 
Given User is on Retail website
When User click on Desktops tab 
And User click on Show all desktops 

Scenario: User verify all items are present in Desktops tab
Then User should see all items are present in Desktop page

Scenario: User add HP LP 3065 from Desktops tab to the cart
And User click ADD TO CART option on HP LP3065 item 
And User select quantity '1' 
And User click add to Cart button 
Then User should see a message'Success: You have added HP LP3065 to your shopping cart!'

Scenario: User add Canon EOS 5D from Desktops tab to the cart
And User click ADD TO CART option on Canon EOS 5D item 
And User select color from dropdown Red
And User select quantity '1' 
And User click add to Cart button 
Then User should see a message 'Success: You have added Canon EOS 5D Camera to your shopping cart!'

Scenario: User add a review to Canon EOS 5D item in Desktops tab
And User click on Canon EOS 5D item 
And User click on write a review link 
And user fill the review information with below information
|yourname| yourReview| Rating|
|Masoom Hussaini|This item is advised for professional photographer|3 |
And User click on Continue Button 
Then User should see a message with 'Thank you for your review. It has been submitted to the webmaster for approval.'
