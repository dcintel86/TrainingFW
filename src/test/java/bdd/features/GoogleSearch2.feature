@google_wiki
Feature: Google Search Wiki
 	Search for wiki on google

Scenario: Normal Search in Google
  Given tui mo "https://www.google.com" len
  When I enter "wiki" text into search field
  And click on "Create" button
  When I select the first result
  Then I should go to "https://www.wikipedia.org/"