Feature: Delete Functionality

  Background: 
    Given [API] user is logged in
      | email    | hui-pretender@outlook.com |
      | password | Hui123456                 |

  @api @cleanup
  Scenario: API - Delete Experience
    Then user deletes all experiences

  @api @cleanup
  Scenario: API - Delete Education
    Then user deletes all educations

  @api @cleanup
  Scenario: API - Delete Education
    Then user deletes all posts
