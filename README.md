## Employee

### Environment Setup 

1.install JDK
2.Install Sdk
3.Install appium desktop
4.Setup environmental variables for jdk and sdk
5.Enable developers mode options android phone
6.Install android sdkpackages
7.check device connectivity using adb command 'adb devices'
8.install eclipse ide and setup project
9.setup appium project in eclipse
10.setup testng


1. Global Dependencies
    * [Install Maven](https://maven.apache.org/install.html)
    * Or Install Maven with [Homebrew](http://brew.sh/)
    ```
    $ brew install maven
    ```

    ```
2. Project Dependencies
	* Check that Packages are available
	```
	$ cd Java-TestNg-Appium-Android
	$ mvn test-compile
	```
	* You may also want to run the command below to check for outdated dependencies. Please be sure to verify and review updates before editing your pom.xml file. The updated packages may or may not be compatible with your code.
	```
	$ mvn versions:display-dependency-updates
	```

    * [Selenium tips regarding explicit waits](https://wiki.saucelabs.com/display/DOCS/Best+Practice%3A+Use+Explicit+Waits)

### Resources

##### [Appium Documentation](http://appium.io/slate/en/master/)

##### [TestNg Documentation](http://testng.org/javadocs/index.html)

##### [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)

##### [Stack Overflow](http://stackoverflow.com/)
* A great resource to search for issues not explicitly covered by documentation.


Defects:


Defect #1

Title: Delete confirmation is not displaying

Steps to reproduce:
1)Open "Employee" application
2)Select an employee- Employee details page will display with employee details
3)Now click on "DELETE EMPLOYEE" button and observe

Actual: Delete employee confirmation is not displaying
Expected: Delete employee confirmation should display

Defect #2

Title:Error message "Project is required" is displaying even after selecting the Current Project

Steps to reproduce:

1)Open "Employee" application
2)Click on "+" icon from the bottom right corner
3)Enter employee details in "Create Employee" page as below
4)Select any job title and click on CREATE EMPLOYEE --- 3 ERRORS WILL BE DISPLAYED
5)Now select any current project from dropdown
6) Now click on 'CREATE EMPLOYEE' button and observe

Actual Result : Error message "Project is required" is still displaying even after selecting the required current project.
Expected: Error should not be displayed under Current project as this field is already selected.





