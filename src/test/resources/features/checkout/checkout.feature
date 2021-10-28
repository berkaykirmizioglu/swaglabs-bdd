@checkout
Feature: Checkout Feature

  Background:
    Given User on the login page
    When User submit login form with credentials
      | username      | password     |
      | standard_user | secret_sauce |
    Then User should be redirected to inventories page and see header title as "PRODUCTS"

  Scenario Outline: Users should order products in type of variations
    When User sort products as "<sortingType>"
    And User Add To Cart product "<productTitle>" with "<price>" price on the Inventory Page
    Then Badge should visible and shopping cart should be updated
    When User click to Shopping Cart button
    Then User checks product price again as "<price>" at the Cart Page
    When User click to Checkout button
    And User fills checkout information form and submit
      | firstName | lastName    | zipCode |
      | Berkay    | Kirmizioglu | 34096   |
    Then User keep check Checkout informations are correct
      | price   | title          | paymentInformation | shippingInformation         | itemTotal | tax   |
      | <price> | <productTitle> | SauceCard #31337   | FREE PONY EXPRESS DELIVERY! | <price>   | <tax> |
    When User finishes order process
    Then User should see checkout completion status as "CHECKOUT: COMPLETE!"
    Then User should see order success message as "THANK YOU FOR YOUR ORDER"

    Examples:
      | sortingType         | productTitle                      | price  | tax   |
      | Price (high to low) | Sauce Labs Bike Light             | $9.99  | $0.80 |
      | Price (low to high) | Test.allTheThings() T-Shirt (Red) | $15.99 | $1.28 |
      | Name (Z to A)       | Sauce Labs Fleece Jacket          | $49.99 | $4.00 |
      | Name (A to Z)       | Sauce Labs Onesie                 | $7.99  | $0.63 |


########################################################################################################################
