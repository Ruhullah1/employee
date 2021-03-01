package com.employee.tests;

import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class EmployeeTest{
//WebDriver driver;
AndroidDriver driver;	
WebDriverWait wait = null;
@BeforeTest
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("automationName", "UiAutomator2");
	capabilities.setCapability("VERSION", "10"); 
	capabilities.setCapability("deviceName","c4ee1482");
	capabilities.setCapability("platformName","Android");
 
   
	capabilities.setCapability("app", "C:\\Users\\Ruhullah\\Downloads\\app-debug.apk");
	//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 20);
}

//@Test(priority=1)
public void employeeFormValidation() throws Exception {
 
   clickElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));

   clickElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]"));

  
   
   WebElement firstNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationFirstNameTextView')]"));
   
   WebElement lastNameValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationLastNameTextView')]"));
   
   WebElement jobTitleValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationTitleTextView')]"));
   
   WebElement projectValidatorElement=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'validationProjectTextView')]"));
   
   assert firstNameValidatorElement.getText().equals("First Name is Required"):"Actual value is : "+firstNameValidatorElement.getText()+" did not match with expected value";

   assert lastNameValidatorElement.getText().equals("Last Name is Required"):"Actual value is : "+lastNameValidatorElement.getText()+" did not match with expected value";

   assert jobTitleValidatorElement.getText().equals("Position is Required"):"Actual value is : "+jobTitleValidatorElement.getText()+" did not match with expected value";

   assert projectValidatorElement.getText().equals("Project is Required"):"Actual value is : "+projectValidatorElement.getText()+" did not match with expected value";

}

//@Test(priority=2)
public void deleteEmployeeTest() {
	String firstName = "testuser";
	String Lastname = "testuser";
	addUser(firstName,Lastname);
	 verifyadduser(firstName,Lastname);
	deleteUser(firstName,Lastname);
	} 

//@Test(priority=3)
public void advertisementAppearTest() {
	
	int userCount = 1;
	int noOfUsers =2;
	for(int i =0;i<noOfUsers;i++) {
		String firstName = "testuser" + i ;
		String Lastname = "testuser" + i ;
		this.addUser(firstName,Lastname);
		verifyadduser(firstName,Lastname);
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
		if(i>=10)
			scrolldown();
		verifyadduser(userName + i,userName + i);
	}
	for(int i =1;i<=noOfUsers;i++) {
		

		
		
		  
		//(new TouchAction(driver)).press(450,1913).moveTo(493,894).release().perform();
		  
		this.deleteUser(userName + i,userName + i);
		//new TouchAction(driver).tap(450, 1913).perform();
		//new TouchAction((MobileDriver) driver).press(100, 100).waitAction(50).release().perform();

	}
}


public void wait(By loc) {
	wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	//wait.until(ExpectedConditions.elementToBeClickable(loc));
}
public void addUser(String firstname,String lastname) {
    
    clickElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'fab')]"));
    entervalue(By.xpath("//android.widget.EditText[contains(@resource-id,'firstNameEditText')]"), firstname);
    entervalue(By.xpath("//android.widget.EditText[contains(@resource-id,'lastNameEditText')]"), lastname);
    clickElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'titleSpinner')]"));

    clickElement(By.xpath("//android.widget.TextView[@text='Developer']"));
    clickElement(By.xpath("//android.widget.Spinner[contains(@resource-id,'projectSpinner')]"));

    clickElement(By.xpath("//android.widget.TextView[@text='Professional']"));
    clickElement(By.xpath("//android.widget.Button[contains(@resource-id,'createButton')]"));
	   
   
    
    	//and verify the advertisement
    }
public void verifyadduser(String firstname,String lastname)
{
	 String xpa="//android.widget.TextView[@text='"+ firstname + " " + lastname + "']";
	    try
		{
	    	//wait(loc);
	    
	    	wait(By.xpath("//android.widget.TextView[@text='"+ firstname + " " + lastname + "']"));
	    	driver.findElement(By.xpath("//android.widget.TextView[@text='"+ firstname + " " + lastname + "']"));
			System.out.println("User added successfully");
		}
		catch(Exception e)
		{
			System.out.println("User is not added");
		}
}
public void scrolldown()
{


	TouchAction touchAction = new TouchAction(driver);
	touchAction.tap(PointOption.point(450, 1913)).perform();
	//(new TouchAction(driver)).press(450,1913).moveTo(493,894).release().perform();
	//new TouchAction(driver).tap(PointOption.point(450,1913)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(30))).moveTo(PointOption.point(450,1913)).release().perform();


}

public void entervalue(By loc,String value)
{
	 
	  try {
		  Thread.sleep(1000);
		  wait(loc);
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.findElement(loc).sendKeys(value);
	   
}

public void clickElement(By loc)
{
	  
	  try {
			Thread.sleep(1000);
			wait(loc);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  driver.findElement(loc).click();

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
 
}



@AfterTest
public void teardown(){
	//close the app
	driver.quit();
}
}