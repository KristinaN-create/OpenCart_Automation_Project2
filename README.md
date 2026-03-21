# OpenCart Automation Project 🛒

This project is a comprehensive automated testing suite for the OpenCart e-commerce platform. It was developed as part of my *Software Quality Assurance (QA)* training to demonstrate proficiency in web automation and testing frameworks.

## 🚀 Technologies & Tools
* *Java*: Core programming language.
* *Selenium WebDriver*: For browser automation and element interaction.
* *TestNG*: Testing framework for assertions, annotations, and test suite management.
* *Maven*: Dependency management and build automation.
* *IntelliJ IDEA*: Primary IDE for development.

## 🏗️ Project Architecture
The project follows the *Page Object Model (POM)* design pattern to ensure code reusability, maintainability, and clear separation between test logic and UI elements.

*   **src/main/java/pages**: Contains Page Classes with element locators and specific page methods (e.g., HomePage, LoginPage, CartPage).
*   **src/test/java/tests**: Contains the actual Test Scripts organized by functionality.
*   **testng.xml**: Configuration file for defining and running test suites.

## 🧪 Automated Test Scenarios
1.  *Login Functionality*: Validates user authentication with both valid and invalid credentials.
2.  *Product Search*: Automates the search bar to verify result accuracy and product visibility.
3.  *Shopping Cart*: Covers the end-to-end flow of adding products to the cart and verifying the cart state.
4.  *Registration*: Automates the user sign-up process and form validation.

## 🛠️ Setup and Installation
1.  *Clone the repository*:

    git clone [https://github.com/your-username/OpenCart_Automation_Project.git](https://github.com/your-username/OpenCart_Automation_Project.git)

2.  *Open in IntelliJ IDEA*: Import the project as a Maven project.
3.  *Download Dependencies*: Allow Maven to resolve and download all libraries from the pom.xml file.
4.  *Run Tests*: Right-click on testng.xml and select *Run*, or use the Maven command:

    mvn clean install


---
Developed as part of the Software Testing curriculum at ROI Academy.
