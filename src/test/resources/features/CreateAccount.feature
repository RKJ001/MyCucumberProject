Feature: Create Account Feature

  Scenario Outline: Create Account with different set of data
    Given user navigates to create account page
    When user fills form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on create an account button
    Then it shows successfull message "Thank you for registering with Main Website Store."

    Examples:
      | SheetName     | RowNumber |
      | createaccount | 0         |
      | createaccount | 1         |
