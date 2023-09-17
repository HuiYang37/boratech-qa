Feature: Delete Functionality

  Background: 
    Given [API] user is logged in
      | email    | hui-pretender@outlook.com |
      | password | Hui123456                 |

  @api
  Scenario: API - Delete Experience
    Then user deletes all experiences

  @api
  Scenario: API - Delete Education
    Then user deletes all educations

  @api
  Scenario: API - Delete Education
    Then user deletes all posts
