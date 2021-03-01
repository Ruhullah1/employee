package com.employee.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class EmployeeTest2{
WebDriver driver;
WebDriverWait wait = null;
@BeforeMethod
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
	wait = new WebDriverWait(driver, 20);
}


//@Test(priority=1)
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




public void deleteEmployeeTest() {
	String firstName = "testuser";
	String Lastname = "testuser";
	addUser(firstName,Lastname);
	deleteUser(firstName,Lastname);
	} 

public void deleteUser(String firstname,String lastname) {
	String userId  =  firstname + " " + lastname ;
	driver.findElement(By.xpath("//android.widget.TextView[@text='"+ userId + "']")).click();
	
    
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

   driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'deleteEmployeeButton')]")).click();
    
    
   
	try
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ firstname + " " + lastname + "']"));
		System.out.println("User Delected successfully");
	}
	catch(Exception e)
	{
		System.out.println("User is not Deleted");
	} 
  driver.findElement(By.xpath("//android.widget.TextView[@text='"+ firstname + " " + lastname + "']")).click();
	
    
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

   driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'deleteEmployeeButton')]")).click();
    
    
   
	try
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ firstname + " " + lastname + "']"));
		System.out.println("User Delected successfully");
	}
	catch(Exception e)
	{
		System.out.println("User is not Deleted");
	}
}

public void wait(By loc) {
	wait.until(ExpectedConditions.presenceOfElementLocated(loc));
}
public void addUser(String firstname,String lastname) {
	WebElement addEmpElement=driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));
    addEmpElement.click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'firstNameEditText')]")).sendKeys(firstname);
 
  wait(By.xpath("//android.widget.EditText[contains(@resource-id,'lastNameEditText')]"));
  driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'lastNameEditText')]")).sendKeys(lastname);
   
  driver.findElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'titleSpinner')]")).click();
  wait(By.xpath("//android.widget.TextView[@text='Developer']"));
	driver.findElement(By.xpath("//android.widget.TextView[@text='Developer']")).click();
    
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    driver.findElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'projectSpinner')]")).click();
    wait(By.xpath("//android.widget.TextView[@text='Professional']"));
	driver.findElement(By.xpath("//android.widget.TextView[@text='Professional']")).click();
	
	   driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]")).click();
	   
    String xpa="//android.widget.TextView[@text='"+ firstname + " " + lastname + "']";
    try
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ firstname + " " + lastname + "']"));
		System.out.println("User added successfully");
	}
	catch(Exception e)
	{
		System.out.println("User is not added");
	}
    
    	//and verify the advertisement
    }
   
//@Test(priority=3)
public void advertisementAppearTest() {
	
	int userCount = 1;
	int noOfUsers =2;
	for(int i =0;i<noOfUsers;i++) {
		String firstName = "testuser" + i ;
		String Lastname = "testuser" + i ;
		this.addUser(firstName,Lastname);
		userCount++;
	}
	int count = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.aaks.qaautomation:id/adView']")).size();

	Assert.assertTrue(count > 0, "Advertisement is displayed");
   


   //
}


@Test(priority=1)
public void multipleUsersAdditionAndDeletion() {
	
	String userName = "testuser";
	int noOfUsers =10;
	for(int i =1;i<=noOfUsers;i++) {
		this.addUser(userName + i,userName + i);
	}
	for(int i =1;i<=noOfUsers;i++) {
		this.deleteUser(userName + i,userName + i);
	}
}

public void entervalue(By loc,String value)
{
	
}

public void clickElement(By loc)
{
	
}
@AfterTest
public void teardown(){
	//close the app
	driver.quit();
}
}