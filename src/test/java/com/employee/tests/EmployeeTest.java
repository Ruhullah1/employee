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
	//capabilities.setCapability("appPackage", "com.aaks.qaautomation2");
   
// This package name of your app (you can get it from apk info app)
	//capabilities.setCapability("appActivity","com.aaks.qaautomation.MainActivity"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}


//@Test
//public void employeeFormValidation() throws Exception {
//   //locate the Text on the calculator by using By.name()
//   WebElement addEmpElement=driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));
//   addEmpElement.click();
//   
//   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//
//   WebElement createButtonElement=driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]"));
//   createButtonElement.click();
//   
//   WebElement firstNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationFirstNameTextView')]"));
//   
//   WebElement lastNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationLastNameTextView')]"));
//   
//   WebElement jobTitleValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationTitleTextView')]"));
//   
//   WebElement projectValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationProjectTextView')]"));
//   
//   assert firstNameValidatorElement.getText().equals("First Name is Required"):"Actual value is : "+firstNameValidatorElement.getText()+" did not match with expected value";
//
//   assert lastNameValidatorElement.getText().equals("Last Name is Required"):"Actual value is : "+lastNameValidatorElement.getText()+" did not match with expected value";
//
//   assert jobTitleValidatorElement.getText().equals("Position is Required"):"Actual value is : "+jobTitleValidatorElement.getText()+" did not match with expected value";
//
//   assert projectValidatorElement.getText().equals("Project is Required"):"Actual value is : "+projectValidatorElement.getText()+" did not match with expected value";
//
//}
//
//
//@Test
//public void employeeFormValidation2() throws Exception {
//   //locate the Text on the calculator by using By.name()
//   WebElement addEmpElement=driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));
//   addEmpElement.click();
//   
//   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//
//   WebElement createButtonElement=driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]"));
//   createButtonElement.click();
//   
//   WebElement firstNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationFirstNameTextView')]"));
//   
//   WebElement lastNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationLastNameTextView')]"));
//   
//   WebElement jobTitleValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationTitleTextView')]"));
//   
//   WebElement projectSpinnerElement=driver.findElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'projectSpinner')]"));
//   
//   new Select(projectSpinnerElement).selectByIndex(1);
//   
//   WebElement projectValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationProjectTextView')]"));
//   
//   
//   assert firstNameValidatorElement.getText().equals("First Name is Required"):"Actual value is : "+firstNameValidatorElement.getText()+" did not match with expected value";
//
//   assert lastNameValidatorElement.getText().equals("Last Name is Required"):"Actual value is : "+lastNameValidatorElement.getText()+" did not match with expected value";
//
//   assert jobTitleValidatorElement.getText().equals("Position is Required"):"Actual value is : "+jobTitleValidatorElement.getText()+" did not match with expected value";
//
//   assert projectValidatorElement.getText().equals(""):"Actual value is : "+projectValidatorElement.getText()+" did not match with expected value";
//
//}

@Test
public void deleteEmployeeTest() {
	
    WebElement addEmpElement=driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));
//  addEmpElement.click();
//  
//  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//
//  WebElement createButtonElement=driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]"));
//  createButtonElement.click();
//  
//  WebElement firstNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationFirstNameTextView')]"));
//  
//  WebElement lastNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationLastNameTextView')]"));
//  
//  WebElement jobTitleValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationTitleTextView')]"));
//  
//  WebElement projectSpinnerElement=driver.findElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'projectSpinner')]"));
//  
//  new Select(projectSpinnerElement).selectByIndex(1);
//  
//  WebElement projectValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationProjectTextView')]"));
//  
//  
//  assert firstNameValidatorElement.getText().equals("First Name is Required"):"Actual value is : "+firstNameValidatorElement.getText()+" did not match with expected value";
//

	
	
}


@AfterTest
public void teardown(){
	//close the app
	driver.quit();
}
}