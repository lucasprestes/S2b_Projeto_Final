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
import UniversalClass.AccessSistem;




public class BS_DataNascimento_TestCase {

	private WebDriver driver;
	private LoginVerificationPoint verifificationpoint;
	//private AccessSistem As;
	//private Boolean status; 
	private String message = "";
	
	@Before 
	public void setUp(){
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.get("https://devbs.azurewebsites.net");
		
		//Estou utilizando o assert neste exemplo
		//this.verifificationpoint = new LoginVerificationPoint(driver);
	}
	
	
	
	
	@Test
	public void test_Field_Email() {
		
		message = "T05A01";
		
		WebElement usernameTextField = this.driver.findElement(By.name("txtUsuario"));
		usernameTextField.sendKeys("lucaspp");
		
		WebElement PasswordTextField = this.driver.findElement(By.name("txtSenha"));
		PasswordTextField.sendKeys("123456");
		
		WebElement LoginButton = this.driver.findElement(By.tagName("button"));
		LoginButton.click();
		
		driver.get("https://devbs.azurewebsites.net/Pessoa/Create");
		
		
		
		assertTrue(this.driver.getPageSource().contains("Informações Pessoais"));
		
	}
	
	@After
	public void tearDown() {
		
		this.driver.quit();
		
	}
	
	
	
}
