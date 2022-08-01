Feature: Searching of various categories should be possible along with product search

Scenario: Search for the products under Apple category
Given I visit the website as a guest users
When I select the Mobile option from the dropdown
And I click on Search icons
Then I should see the apple page loaded
And I should see Books at flipkart as heading
But I should not see other category product