Feature:  Verify the Login Feature

  Background:
    Given User launches the SwagLabs

    @e2eTest
  Scenario: Test Login Functionality with Standard user
    Given user navigate to SwagLabs URL
    When User attempts to login with below valid credentials
      | username      | password     |
      | standard_user | secret_sauce |
    Then user should be directed to product catalog page
    And Add the First and Second Products To The Cart and Click On The Cart Icon
    Then User Should be in Cart Page And able to see his products
    And Click On Checkout
    Then User Should be in Checkout Page
    And user Fill The information with below valid credentials And Click On Continue
      | firstName | LastName | ZipCode |
      | Ahmed     | Khaled   | 12345   |
    Then user should be in Overview page
    And click on Finish
    Then user Should be in Complete page see a message Thank you for your order
