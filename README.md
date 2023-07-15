# Employee Management System

## Description

This webapp is used to perform basic CRUD functionalities using core JAVA for backend using _java servlets_, and _mySQL_ as database.

It is part of the learning project during internship period.

In this webapp, 
- Used JDBC Driver to connect to mySQL database
- Used different Servlets for different purposes.
- To implement MVC architecture,
   - DAO(Data Access Object) for controller,
   - Servlets for views
 
## Running the program

For the jdbc driver connection in DAO, set

```bash
String url = "jdbc:mysql://localhost:3306/<database-name>";
String uname = "<root>";
String pass = "<password>";
```

Change the fields within <> with your specific machine instances

## Author

Suyash Shrestha
