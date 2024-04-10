# WebstoreAutomator

## Overview
This project automates a test scenario for the WebstaurantStore website using Selenium WebDriver and Java. It's designed to run on Windows 10 and uses Chrome as the browser.

## System Requirements
- **Operating System:** Windows 10
- **Programming Language:** Java (JDK 17 or higher recommended)
- **Build Tool:** Maven
- **Browser:** Chrome
- **Browser Driver:** Managed by WebDriverManager

## Installation
1. **Java Development Kit (JDK):** Ensure Java 17 is installed on your system.
2. **Maven:** Ensure Maven is installed and configured.
3. **Google Chrome:** Ensure the latest version of Google Chrome is installed.
4. **Clone the project:** `git clone https://github.com/vadym-usatiuk/WebstoreAutomator`
5. **Navigate to the project directory:** `cd WebstoreAutomator`

## Running the Tests
To run the automated tests, execute the following command in your terminal or command line:
```bash
mvn clean test
```

### Test Scenario
- Navigate to `https://www.webstaurantstore.com/`.
- Search for 'stainless work table'.
- Verify each product in the search results contains the word 'Table' in its title.
- Add the last item found to the cart.
- Empty the cart.

## Libraries Used
- **Selenium WebDriver:** For browser automation.
- **WebDriverManager:** To manage the browser driver automatically.
- **JUnit:** As the testing framework.

## Architecture

- **WebDriver Setup**: Utilizes `WebDriverManager` to handle browser driver setup, ensuring compatibility and ease of maintenance.
- **Page Object Model (POM)**: Implements the Page Object Model pattern to provide an abstraction layer for page-specific elements and interactions. This improves test maintainability and reduces code duplication.
- **Test Runner**: Employs JUnit as the test runner to execute tests, manage test lifecycle, and report outcomes.
- **Assertions**: Uses assertion mechanisms to validate the conditions and outcomes of the tests, ensuring the reliability of test results.
- **Utilities**: Contains utility functions and common methods to support test operations and enhance the framework's functionality.

This architecture is designed to support maintainability, scalability, and ease of integration with continuous integration/continuous deployment (CI/CD) pipelines.

## Author
- Vadym Usatiuk

## License
- This project is licensed under the MIT License - 2024
