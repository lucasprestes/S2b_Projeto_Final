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


import org.junit.Test;

public class BS_Login_TestCase {

	private WebDriver driver;
	
	
	@Before 
	public void setUp(){
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.get("https://devbs.azurewebsites.net");
		
		
	}
	
	
	@Test
	public void testLoginSuccess() {
		WebElement usernameTextField = this.driver.findElement(By.name("txtUsuario"));
		usernameTextField.sendKeys("lucaspp");
		
		WebElement PasswordTextField = this.driver.findElement(By.name("txtSenha"));
		PasswordTextField.sendKeys("123456");
		
		WebElement LoginButton = this.driver.findElement(By.tagName("button"));
		LoginButton.click();
		
		assertTrue(this.driver.getPageSource().contains("Bem Vindo!"));
		
		if(this.driver.getPageSource().contains("Bem Vindo!") == true)
		{
			System.out.println("Error T16A01");
			
		}
	
		
	}
	
	
	@Test
	public void testLoginFail() {
		WebElement usernameTextField = this.driver.findElement(By.name("txtUsuario"));
		usernameTextField.sendKeys("lucaspp");
		
		WebElement PasswordTextField = this.driver.findElement(By.name("txtSenha"));
		PasswordTextField.sendKeys("111111");
		
		WebElement LoginButton = this.driver.findElement(By.tagName("button"));
		LoginButton.click();
		
		
		assertTrue(this.driver.getPageSource().contains("Usuário e/ou senha inválidos."));
		
		if(this.driver.getPageSource().contains("Usuário e/ou senha inválidos.") != true)
		{
			System.out.println("Error T16A02");
			
		}
		
	}

	@After
	public void tearDown() {
		
		this.driver.quit();
		
	}
	
	
}
