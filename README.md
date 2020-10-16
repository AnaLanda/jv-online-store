# Online Music Instrument Store

A prototype of an online store with basic functionality for users and admins written in Java. 

## Project Structure
The project has an N-tier structure and consists of the database layer, the DAO layer for interaction with the database, the service layer which contains the business logic, and the presentation layer.

Servlets are used to receive and respond to client requests; filters control access to the store's functionality; and the presentation layer is implemented with JSP and Bootstrap. 

The DAO layer includes two implementations - one for the JDBC, which is used for interaction with the database; and one where data is stored locally in Lists. 

This project also includes custom-made annotations and an injector, which utilizes Reflection API. 

Store clients can perform the following actions:
 - register on the store's website;
 - log in and out;
 - look through the instruments sold at the store;
 - add items to their cart;
 - delete items from the cart;
 - place orders. 

Admins in their turn can: 
 - view all registered users;
 - delete users from the store's database;
 - view all orders placed at the store; 
 - edit the store's stock of instruments.
 
## Technologies Used

 - Java 11
 - Maven 3.1.1
 - Maven Checkstyle Plugin
 - Javax Servlet API 3.1.0
 - JSTL 1.2
 - JSP
 - Apache Tomcat
 - MySQL RDBMS
 - Bootstrap

## Running the Project

To run the project on your local machine, clone this project into your local folder and open the project in an IDE. 

Configure Tomcat Server and set up the MySQL DS and MySQL Workbench on your machine. 

Replicate the database from the project by copying the script from init_db.sql into the MySQL Workbench query editor window. 

Insert your own MySQL username and login in dbProperties in the ConnectionUtil class. 

Your MySQL server must be up and running when you launch the project.

When you launch the website for the first time, click on "Inject data" to add the user and admin data to the DB so that the store works properly.

To log in as a User on the website without registration, you can log in as `imp` with the password `password1234`. 

To log in as an Admin on the website, you should log in as `admin` with the password `1234`. 

## Author

[Anastasiia Melnyk](https://github.com/AnaLanda)
