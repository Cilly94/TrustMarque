# TrustMarque Automation Framework

This project is a UI automation framework built using:

- Java
- Selenium WebDriver
- TestNG
- Maven

The framework demonstrates:
- Test design
- Framework structure
- UI automation execution
- Page Object Model (POM)
- Reusable methods
- Assertions and validations
- Screenshot capturing

---

# Test URL

https://www.saucedemo.com/

---

# Framework Structure

src/test/java
│
├── base
│   └── BaseTest.java
│
├── pages
│   ├── LoginPage.java
│   ├── InventoryPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
│
├── tests
│   ├── LoginTests.java
│   ├── CartTest.java
│   └── CheckoutTest.java
│
├── utils
│   └── ScreenshotUtils.java
│
└── resources
└── config.properties

---

# Implemented Test Scenarios

## 2.1 Successful Login
- Navigate to login page
- Enter valid credentials
- Click login
- Validate successful login

## 2.2 Unsuccessful Login
- Enter invalid credentials
- Validate error message

## 2.3 Add Item to Basket
- Login
- Add product to basket
- Validate basket update

Additional Scenarios:
- Add two products
- Add three products
- Remove product from cart

## 2.4 Checkout Flow
- Login
- Add product to basket
- Complete checkout
- Validate confirmation

Additional Scenario:
- Remove item before checkout

---

# Screenshot Functionality

The framework automatically captures screenshots after test execution.

Screenshots are saved inside:

screenshots/

---

# How To Run Tests

## Run all tests

Using IntelliJ:
- Right click test suite
- Click Run

Using Maven:

```bash
mvn test