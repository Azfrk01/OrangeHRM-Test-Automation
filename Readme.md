# Selenium Automation Framework for OrangeHRM Application

## 🎯 Project Goal
I designed and implemented a *real-world Selenium automation framework* for the OrangeHRM application using *Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)*.  
I built a Selenium automation framework using Java, TestNG, Maven, and Page Object Model.
This project demonstrates my ability to create *maintainable, stable, and professional automation frameworks*, ready for real-world testing scenarios.

## 1️⃣ Website I Automated
I chose *OrangeHRM Demo* because it is a *stable and widely recognized demo site*, commonly used in interviews.  
URL: [https://opensource-demo.orangehrmlive.com/](https://opensource-demo.orangehrmlive.com/)

*Features I automated:*
- Login Module  
- Dashboard  
- Employee (PIM) Module  
- Forms & validations  

## 2️⃣ Tech Stack I Used
I intentionally kept the stack *simple and professional*:  
- *Java*  
- *Selenium WebDriver*  
- *TestNG*  
- *Maven*  
- *Page Object Model (POM)*  
- *Extent Reports*  
- *Git + GitHub*

## 3️⃣ Project Structure

Here’s how I organized the project:
AutomationFramework/
├── src/main/java
│ ├── base
│ │ └── BaseTest.java
│ ├── pages
│ │ ├── LoginPage.java
│ │ ├── DashboardPage.java
│ │ └── PIMPage.java
│ ├── utils
│ │ ├── ConfigReader.java
│ │ ├── WaitUtils.java
│ │ └── ScreenshotUtil.java
│
├── src/test/java
│ └── tests
│ ├── LoginTest.java
│ ├── DashboardTest.java
│ └── PIMTest.java
│
├── src/test/resources
│ ├── config.properties
│ └── testng.xml
│
├── pom.xml
└── README.md

> I followed *modular design principles* to keep my framework maintainable and clean.

## 4️⃣ Test Scenarios I Implemented
### 🔹 Login Module
- Valid login  
- Invalid login  
- Empty username/password  
### 🔹 Dashboard
- Verify dashboard loads correctly  
- Validate welcome message  
### 🔹 PIM (Employee Module)
- Add employee  
- Search employee  
- Validate employee details  
## 5️⃣ Key Features I Built

✅ *Page Object Model (POM)*  
- Each page has its own class  
- No locators inside test classes  

✅ *Config-Driven Execution*  
- Centralized `config.properties` for URL, credentials, browser:

properties
'```url=https://opensource-demo.orangehrmlive.com/
username=Admin
password=admin123
browser=chrome```

✅ Wait Strategy
Explicit waits only
No Thread.sleep() usage

✅ Reports
Integrated Extent Reports
Screenshots automatically captured on test failures

6️⃣ How I Set Up & Ran the Project
Tools I Used
Java JDK – verified with java -version
Eclipse IDE – to run and debug the project
Maven Plugin – for dependency management
Git – version control
Browser Drivers – ChromeDriver 
TestNG Plugin – for running test suites
Extent Reports – added via Maven dependency

7️⃣ Test Automation Practices I Followed

Centralized BaseTest for driver setup and teardown
Clean Page Object design
Explicit waits for dynamic elements
Config-driven for cross-browser execution
Automatic screenshots on failures for easier debugging
8️⃣ Timeline I Followed
Day	Task
1	Project setup + Login automation
2	Dashboard tests + POM design
3	PIM module tests
4	Extent Reports + cleanup
5	README + GitHub push

I completed this in 5 days, staying focused on stability and maintainability.
