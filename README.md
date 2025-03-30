# StudentManagementSystem
Student Management System A simple Java + Oracle JDBC project that allows students to register, log in, update details, and view records.
This is a simple **Java + Oracle JDBC** project for student registration and login.

## Features:
- ✅ Student Registration  
- ✅ Login System  
- ✅ Update Email & Phone  
- ✅ View Students with Percentage Filters  
- ✅ Delete Records Based on Percentage  

## Setup Instructions:
1. Install **Oracle Database** and create a table using `student39.sql`.
2. Update database connection details in the Java file.
3. Run the `DBConn4.java` file to start the application.

## Database Schema:
The project uses a table named `student39` with the following structure:

-> sql
CREATE TABLE student39 (
    sroll NUMBER PRIMARY KEY,
    sname VARCHAR2(50),
    spercentage FLOAT,
    fname VARCHAR2(50),
    lname VARCHAR2(50),
    mailid VARCHAR2(100),
    sphoneno NUMBER(10)
);

