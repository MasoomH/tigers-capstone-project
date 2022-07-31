@TestAllPages
Feature: Home Page
Background:
Given User is on Retail website

Scenario: User verify currency values change
When User click on Currency 
And User Chose Euro from dropdown 
Then currency value should change to Euro

Scenario: User empty Shopping cart message displays 
When User click on shopping cart 
Then 'Your shopping cart is empty!' message should display