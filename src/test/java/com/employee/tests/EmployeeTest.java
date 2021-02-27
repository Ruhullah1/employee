package com.employee.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class EmployeeTest{
WebDriver driver;

@BeforeTest
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "Android");
	capabilities.setCapability("VERSION", "10"); 
	capabilities.setCapability("deviceName","c4ee1482");
	capabilities.setCapability("platformName","Android");
 
   
	capabilities.setCapability("app", "C:\\Users\\Ruhullah\\Downloads\\app-debug.apk");
	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}


@Test
public void employeeFormValidation() throws Exception {
   //locate the Text on the calculator by using By.name()
   WebElement addEmpElement=driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));
   addEmpElement.click();
   
   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


   WebElement createButtonElement=driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]"));
   createButtonElement.click();
   
   WebElement firstNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationFirstNameTextView')]"));
   
   WebElement lastNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationLastNameTextView')]"));
   
   WebElement jobTitleValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationTitleTextView')]"));
   
   WebElement projectValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationProjectTextView')]"));
   
   assert firstNameValidatorElement.getText().equals("First Name is Required"):"Actual value is : "+firstNameValidatorElement.getText()+" did not match with expected value";

   assert lastNameValidatorElement.getText().equals("Last Name is Required"):"Actual value is : "+lastNameValidatorElement.getText()+" did not match with expected value";

   assert jobTitleValidatorElement.getText().equals("Position is Required"):"Actual value is : "+jobTitleValidatorElement.getText()+" did not match with expected value";

   assert projectValidatorElement.getText().equals("Project is Required"):"Actual value is : "+projectValidatorElement.getText()+" did not match with expected value";

}


@Test
public void employeeFormValidation2() throws Exception {
   //locate the Text on the calculator by using By.name()
   WebElement addEmpElement=driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));
   addEmpElement.click();
   
   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


   WebElement createButtonElement=driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]"));
   createButtonElement.click();
   
   WebElement firstNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationFirstNameTextView')]"));
   
   WebElement lastNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationLastNameTextView')]"));
   
   WebElement jobTitleValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationTitleTextView')]"));
   
   WebElement projectSpinnerElement=driver.findElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'projectSpinner')]"));
   
   new Select(projectSpinnerElement).selectByIndex(1);
   
   WebElement projectValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationProjectTextView')]"));
   
   
   assert firstNameValidatorElement.getText().equals("First Name is Required"):"Actual value is : "+firstNameValidatorElement.getText()+" did not match with expected value";

   assert lastNameValidatorElement.getText().equals("Last Name is Required"):"Actual value is : "+lastNameValidatorElement.getText()+" did not match with expected value";

   assert jobTitleValidatorElement.getText().equals("Position is Required"):"Actual value is : "+jobTitleValidatorElement.getText()+" did not match with expected value";

   assert projectValidatorElement.getText().equals(""):"Actual value is : "+projectValidatorElement.getText()+" did not match with expected value";

}

@Test
public void deleteEmployeeTest() {
	
    WebElement firstEmployee=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'fullNameTextView')]"));
    firstEmployee.click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement deleteButtonElement=driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'deleteEmployeeButton')]"));
    deleteButtonElement.click();
    
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    
    WebElement firstEmployee2=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'fullNameTextView')]"));
    
    assert firstEmployee2.getText().equals("Carl Pavano"):"Actual value is : "+firstEmployee2.getText()+" did not match with expected value";
	
}


@Test
public void advertisementAppearTest() {
	
	int userCount = 1;
	int noOfUsers =2;
	for(int i =0;i<noOfUsers;i++) {
		this.addUser(userCount);
		userCount++;
	}
	
	//and verify the advertisement
}


@Test
public void multipleUsersAdditionAndDeletion() {
	
	int userCount = 1;
	int noOfUsers =10;
	for(int i =0;i<noOfUsers;i++) {
		this.addUser(userCount);
		userCount++;
	}
	//delete user
	//dismis adds
}


public void addUser(int userId) {
	WebElement addEmpElement=driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));
    addEmpElement.click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	WebElement firstNameElement=driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'firstNameEditText')]"));
  
	firstNameElement.sendKeys("firstname-"+userId);
    WebElement lastNameElement=driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'lastNameEditText')]"));
    lastNameElement.sendKeys("lastname-"+userId);
    WebElement jobTitleElement=driver.findElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'titleSpinner')]"));
  
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	jobTitleElement.click();
	
	jobTitleElement.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'text1')]")).click();
    
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement projectElement=driver.findElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'projectSpinner')]"));
    
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    projectElement.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'text1')]")).click();
    
    WebElement createButtonElement=driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]"));
    createButtonElement.click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

@AfterTest
public void teardown(){
	//close the app
	driver.quit();
}
}