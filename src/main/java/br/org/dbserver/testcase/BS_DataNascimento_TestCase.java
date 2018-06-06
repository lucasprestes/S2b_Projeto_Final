package br.org.dbserver.testcase;

import static org.junit.Assert.assertEquals;
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




public class BS_DataNascimento_TestCase {

	private WebDriver driver;
	private String message = "";
	
	@Before 
	public void setUp(){
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.get("https://devbs.azurewebsites.net");
		
		//Estou utilizando o assert neste exemplo para demostrar conhecimento
		//this.verifificationpoint = new LoginVerificationPoint(driver);
	}
	
	@Test
	public void test_T05A01() {
		
		String expected = "";
		String actual = "";
		message = "T05A01";
		
		WebElement usernameTextField = this.driver.findElement(By.name("txtUsuario"));
		usernameTextField.sendKeys("lucaspp");
		
		WebElement PasswordTextField = this.driver.findElement(By.name("txtSenha"));
		PasswordTextField.sendKeys("123456");
		
		WebElement LoginButton = this.driver.findElement(By.tagName("button"));
		LoginButton.click();
		
		driver.get("https://devbs.azurewebsites.net/Pessoa/Create");
		WebElement SalvarButton = this.driver.findElement(By.id("btnSalvar"));
		SalvarButton.click();
		
		WebElement LN = this.driver.findElement(By.id("LocalNascimento"));
		LN.sendKeys("AAAAAAAAAasdasdasd 1233445");
		
		actual = LN.findElement(By.xpath("//span[@class='field-validation-valid']")).getText();
		
		assertEquals(message,expected, actual);
	}
	
	@Test
	public void test_T05A02() {
		
		String actual = "";
		Boolean state = false;
		message = "T05A02";
		
		WebElement usernameTextField = this.driver.findElement(By.name("txtUsuario"));
		usernameTextField.sendKeys("lucaspp");
		
		WebElement PasswordTextField = this.driver.findElement(By.name("txtSenha"));
		PasswordTextField.sendKeys("123456");
		
		WebElement LoginButton = this.driver.findElement(By.tagName("button"));
		LoginButton.click();
		
		driver.get("https://devbs.azurewebsites.net/Pessoa/Create");
		WebElement SalvarButton = this.driver.findElement(By.id("btnSalvar"));
		SalvarButton.click();
		
		WebElement LN = this.driver.findElement(By.id("LocalNascimento"));
		LN.sendKeys("%&*@@@@@@@@@@@");
		
		actual = LN.findElement(By.xpath("//span[@class='field-validation-error']")).getText();
	
		if(actual != "")
		{
			state = false;
		}
		
		assertTrue(message,state);
	}
	
	
	
	@After
	public void tearDown() {
		
		this.driver.quit();
		
	}
	
	
	
}
