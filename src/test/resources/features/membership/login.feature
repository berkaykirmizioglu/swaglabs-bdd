@login
Feature: Login Feature

  Scenario Outline: *Valid Users* Successfully Login to SwagLabs App
    Given User on the login page
    When User submit login form with credentials
      | username   | password   |
      | <username> | <password> |
    Then User should be redirected to inventories page and see header title as "PRODUCTS"

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

########################################################################################################################

  Scenario Outline: Users Try to Login and Failed at SwagLabs App
    Given User on the login page
    When User submit login form with credentials
      | username    | password    |
      | <username_> | <password_> |
    Then User should see error message as "<errorMessage_>" at the Login Page

    Examples:
      | username_       | password_        | errorMessage_                                                             |
      | locked_out_user | secret_sauce     | Epic sadface: Sorry, this user has been locked out.                       |
      | invalid_user    | secret_sauce     | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | invalid_password | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce     | Epic sadface: Username is required                                        |
      | standard_user   |                  | Epic sadface: Password is required                                        |
      |                 |                  | Epic sadface: Username is required                                        |
