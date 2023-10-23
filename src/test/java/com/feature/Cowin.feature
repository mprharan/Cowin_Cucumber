Feature: Government Site
Scenario: Search Page
Given User Launch The Site
When Click Select By District
And Click Select State
And Verify The List and Select State
And CLick Select District
Then Verify The List and Select District and Click Search

Scenario: Filter By Choice
Given Click and Verify The Age
When Click and Verify The Dose
And Click and Verify The Cost
And Click and Verify The Vaccine
Then Verify The Hospital Shown
