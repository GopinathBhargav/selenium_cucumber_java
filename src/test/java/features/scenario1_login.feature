@userLoginWithoutRegisteredEmail
Feature: Verification of user trying to sign in with valid email id but not registered to amazon portal

  @login_happy_path
  Scenario: Verify that user cannot log in to the amazon website without registering the email and verify the valid error message
    Given User is on Amazon home page
    When User clicked on signin button
    And User passed valid email "vgopinathbhargav@outlook.com" not registered on amazon
    Then User should be able to see the error "We cannot find an account with that email address"

  @login_negative_case
    # failing this test case knowingly in order to check the generation of screenshot in test reports
  Scenario: Verify that user cannot log in to the amazon website without registering the email and verify the invalid error message
    Given User is on Amazon home page
    When User clicked on signin button
    And User passed valid email "vgopinathbhargav@outlook.com" not registered on amazon
    Then User should be able to see the error "please try again with the same email address"