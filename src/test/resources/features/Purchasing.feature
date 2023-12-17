@Purchasing
Feature: Purchasing
  User wants to purchasing products in Swag Labs

  @TC4
  Scenario Outline: User purchases a product in Swag Labs
    Given User has already on login page
    When User input "<userName>" as username and "<password>" as password
    Then User will be redirected to inventory page
    And User has already on inventory page
    When User sorts products by "<filter>"
    And User click product "<productName1>" as product
    Then Verify the number of products in cart is "<countProduct1>"
    When User click product "<productName2>" as product
    Then Verify the number of products in cart is "<countProduct2>"
    And User click cart button to go to cart page
    Then User will be redirected to cart page
    And Product "<productName1>" and "<productName2>" will be displayed in item list
    When User remove "<productName2>" from the cart
    And User click checkout button
    Then User has already on 'Checkout Information' page
    When User input "<firstname>" in first name field, "<lastname>" in last name field, and "<code>" in postal code field
    And User click continue button
    Then User will be redirected on Checkout Overview Page
    And Verify the price product "<productName1>" in cart list descriptions should be equal to item total
    And Verify the tax value displayed should be equal to 8% from total price which is "<tax>"
    And Verify total payment should be equal to item total plus tax
    When User click finish button
    Then User will successfully purchasing
    Examples:
      | userName      | password     | filter              | productName1      | countProduct1 | productName2          | countProduct2 | firstname | lastname | code  | tax  |
      | standard_user | secret_sauce | Price (low to high) | Sauce Labs Onesie | 1             | Sauce Labs Bike Light | 2             | Sofie     | Miranti  | 33333 | 0.64 |