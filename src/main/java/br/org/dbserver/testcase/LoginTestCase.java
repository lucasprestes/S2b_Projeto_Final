package br.org.dbserver.testcase;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import verificationpoint.LoginVerificationPoint;

public class LoginTestCase {
	private WebDriver driver;
	private LoginVerificationPoint verifificationpoint;
	
	@Before 
	public void setUp(){
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.get("http://demo.virtuemart.net/");
		
		this.verifificationpoint = new LoginVerificationPoint(driver);
		
	}

	@Test
	public void testMain()
	{
		WebElement usernameTextField = this.driver.findElement(By.id("modlgn-username"));
		usernameTextField.sendKeys("demo");
		
		WebElement PasswordTextField = this.driver.findElement(By.id("modlgn-passwd"));
		PasswordTextField.sendKeys("demo");
		
		WebElement LoginButton = this.driver.findElement(By.name("Submit"));
		LoginButton.click();
		
		this.verifificationpoint.checkhellomessage();
		
		//assertTrue(this.driver.getPageSource().contains("Hi demo"));
		
	}
	
	@After
	public void tearDown() {
		
		this.driver.quit();
		
	}

}
	
