# AgileBoard
A backend repo which contains functionality of the Agile Board.
Agile Board is a replica of [Trello](https://trello.com/) with a few additional functionalities.
This application supports the APIs for following business cases till now - 
* Provide the whole board as a json. (To display a board on UI)
* List all the cards by a specified tag (A search by tag on UI)
* List all cards in a column (Collapsable column functionality on UI)
* List all cards created after a specific timestamp (A filter criteria on UI)
* List all card details to be highlighted to the user - Whenever a user visits a board we can highlight the cards which were created/modified after the user's last visit.

This project makes use of the following tech stack
* Spring Boot as a web framework
* WebFlux for reactive programming
* MongoDB as a database
* Gradle as a build tool
* Java 18 as programming language

The code is not fully tested yet and only a few unit test cases are written.
