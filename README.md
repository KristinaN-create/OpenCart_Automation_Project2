# OpenCart Automation Project 🛒

This repository contains automated functional tests for the *OpenCart* e-commerce platform. The project is built using *Java*, *Selenium WebDriver*, and the *TestNG* framework.

## 🚀 Test Coverage (Total: 13 Test Cases)

The suite is designed to run via testng.xml and covers the following scenarios:

### 🔍 Search (2 Tests)
*   *Product Search:* Searching for iPhone and verifying visibility.
*   *Product Search:* Searching for MacBook and verifying visibility.

### 👤 Registration (4 Tests)
*   *Success Scenarios:* 3 successful registrations with unique user data (handled via DataProvider).
*   *Negative Scenario:* Validation check for an already registered email address.

### 🔑 Login (4 Tests)
*   *Success Scenarios:* 3 successful logins with valid credentials (handled via DataProvider).
*   *Negative Scenario:* Validation check for an invalid password.

### 🛒 Shopping Cart (3 Tests)
*   *Product Addition:* Adding an iPhone to the cart with a specific quantity.
*   *Product Addition:* Adding a MacBook to the cart.
*   *Cart Verification:* Direct validation of the Shopping Cart page content.

## 🛠 Tech Stack
*   *Language:* Java
*   *Automation Tool:* Selenium WebDriver
*   *Test Management:* TestNG
*   *Build Tool:* Maven / IntelliJ IDEA

## ⚙️ How to Run
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Locate testng.xml in the project root.
4. Right-click on testng.xml and select *Run*.
