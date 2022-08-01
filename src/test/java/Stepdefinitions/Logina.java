package Stepdefinitions;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logina {
	WebDriver driver;
	@Given("^I navigate to the omayo   blog website$")
	public void I_navigate_to_the_omayo_website()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Web\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");

		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
	}
	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\" into the fields$")
    public void i_enter_username_as_someusername_and_password_as_somepassword_into_the_fields(String Username, String Password) 
	{
		driver.findElement(By.name("userid")).sendKeys(Username);
		driver.findElement(By.name("pswrd")).sendKeys(Password);
	}
	
	@And("^I click on Login button$")
    public void i_click_on_login_button() 
	{
		  driver.findElement(By.cssSelector("input[value='Login']")).click();
	}
	

	@Then("^User should login based on expected \"([^\"]*)\" status$")
	public void User_should_login_based_on_expected_status(String expectedLoginStatus) {
		
		String expectedStatus=expectedLoginStatus;
		String actualStatus=null;
		try {
			Alert alert = driver.switchTo().alert();
			String actualText = alert.getText();
			if(actualText.equals("Error Password or Username")) {
				actualStatus="failure";
			}else {
				actualStatus="success";
			}
		}catch(Exception e) {
			actualStatus="success";		
		}
		
		if(actualStatus.equals(expectedStatus)) {
			//Do nothing
		}else {
			Assert.fail("Actual login status is not equal to the expected login status");
		}
		
		
	}

			
		
		
       
       
    


}
