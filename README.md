# Online Music Instrument Store

An online store with basic functionality for users and admins written in Java. 
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
 - Mysql Connector Java 8.0.21
 - Bootstrap

## Running the Project

To run the project on your local machine, clone this project into your local folder and open the project in an IDE. 

Configure Tomcat Server and set up the MySQL DS and MySQL Workbench on your machine. 

Replicate the database from the project by copying the script from init_db.sql into the MySQL Workbench query editor window. 

Insert your own MySQL username and login in dbProperties in the ConnectionUtil class. 

Your MySQL server must be up and running when you launch the project.
 