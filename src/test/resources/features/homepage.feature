Feature: Home Page Feature

  Background:
    Given user already logged into Application
      | email            | password |
      | test@account.com | Test@123 |

  @SearchItem
  Scenario: Search Items
      When user search items in search field
      Then search result displayed

  @AddingItem
  Scenario: Select Size , color and Add to Cart
      When user select size and color
      And user clicks on Add to cart button
      Then item should get added to cart
      Then checkout button is displayed