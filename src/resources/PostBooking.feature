@postbooking
Feature: Post Booking

  Scenario: As a user at Restful Booker, I would like to reserve a room.

    Given User wants to make a reservation for a room
    When Making the call
    Then Customer should successfully reserve the room