#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Get Text from available elements to save it on a file
  

 
  Scenario: User Opens the Docs link
    Given user launches firefox browser
    When user open the link https://legacy.reactjs.org/ then user should be able to click Docs link


  Scenario Outline: Capturing the Data Dynamically for Main Concepts and Advanced Guide Link and saving it to file
    When user clicks on Main Concepts link 
    Then Navigate to all the sub elements available under main concepts and get text and save it to file
    Then user clicks on Advance Guide tab 
    Then Navigate to all the sub elements available under advanced guide and get text and save it to file
  
  Scenario Outline: clicks on Tutorial and scoll to end and verify text highlight and color
    When user clicks on Tutorials link
    Then user scroll down to the end 
    Then validates the highlightion and color visiblity of text

