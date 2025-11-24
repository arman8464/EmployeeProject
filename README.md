# Employee Management System (Java + JDBC)

A simple, console-based **Employee Management System** built using **Java, JDBC, and MySQL**.  
This project includes a **secure login system**, and full **CRUD operations** for managing employee data.

---

## 🚀 Features

### 🔐 Admin Login  
- Username + Password stored in the database  
- Validates user before accessing system

### 👨‍💼 Employee Management
- ➕ Add Employee  
- 👀 View All Employees  
- ✏️ Update Employee Salary  
- ❌ Delete Employee  
- 🔎 Search Employee by ID  

### 💾 Database (MySQL)
- Employees stored permanently  
- Uses PreparedStatement (safe & secure)

---

## 🛠 Tech Stack
- **Java (JDK 17/21/25)**  
- **JDBC**  
- **MySQL Database**  
- **VS Code / IntelliJ / Eclipse**  
- **MySQL Connector JAR**

---

## 📁 Project Structure
EmployeeProject/
│── Employee.java
│── EmployeeDAO.java
│── Auth.java
│── Main.java
-----------------------------------------------------------------

## 🗄 Database Setup

### Create Database & Tables:

```sql
CREATE DATABASE IF NOT EXISTS ems;
USE ems;

CREATE TABLE admin(
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50));


INSERT INTO admin VALUES ('admin', 'admin123');

CREATE TABLE employees(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    salary DOUBLE,
    department VARCHAR(50));

======================================================================
    ▶️ How to Run-
	1.	Clone the project
	2.	Add MySQL Connector JAR to classpath
	3.	Update username/password in code if needed
	4.	Run Main.java
=======================================================================
    📌 Output Preview-
    ===== EMPLOYEE MANAGEMENT LOGIN =====
Enter username:
Enter password:
Login Successful!

===== EMPLOYEE MANAGEMENT SYSTEM =====
1. Add Employee
2. View Employees
3. Update Salary
4. Delete Employee
5. Search Employee
6. Exit
---------------------------------------------
👤 Author

Arman Khan.
