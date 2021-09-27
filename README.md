# Filming locations in San Francisco
    This application was created by Mykyta Tymko as a test case for IBM Austria.

## Functionality
- Creating, reading, upgrading and deleting films produced in San Francisco.

## The technology stack used
- Java 11
- Angular
- Spring Web
- Spring Data JPA
- Lombok
- H2 database
- Gradle
- HTML
- CSS

## Working Principle
1) Each time when the application starts up, it reads the data from the open web database  [Film Locations in San Francisco](https://data.sfgov.org/Culture-and-Recreation/Film-Locations-in-San-Francisco/yitu-d5am). The information is only read from the title and locations columns.
2) The data are placed in the database H2, which is stored in memory.
3) Then, using the functionality implemented in the application, you can interact with the data.

## Some features
- With each new start of the server database is created and populated anew! Therefore, each time you start, you will have a database with 1000 records (as there are currently 1000 records on [Film Locations in San Francisco](https://data.sfgov.org/Culture-and-Recreation/Film-Locations-in-San-Francisco/yitu-d5am)).
- When adding a new record or editing an existing one, the fields cannot be empty. Otherwise, you will see a "Parameters must not be empty!" warning in the Web Console.

## How to Get Started
1) Launch the back-end side (TestIbmBackApplication).
2) Launch the front-end side (Angular CLI Server (test-IBM-front)).
3) Go to http://localhost:4200/.
4) To view only the server part, go to http://localhost:8080/api/locations.
