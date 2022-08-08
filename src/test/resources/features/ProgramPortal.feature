Feature:BDD scenario

  @Smoke
  Scenario:Amazon Login
    Given user launches portal
    When user clicks on signup on the homepage
    Then user navigates to the signup page
    When user enters "srinag401@gmail.com" as email
    And user enters "srinag123" as password

