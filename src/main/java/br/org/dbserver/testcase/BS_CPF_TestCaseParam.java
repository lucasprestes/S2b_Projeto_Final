package br.org.dbserver.testcase;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runners.Parameterized;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(value = Parameterized.class)
public class BS_CPF_TestCaseParam {

	
    private String expected="";
    private String actual = "";
    private WebDriver driver;
    
    
    public void InputTest_Param(String ac, String ex) {
    	actual= ac;
    	expected= ex;
    }
    
    @Parameters(name = "{index}: testAdd({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
        	 { "123.456.778-89", "Dado inválido." }, 
        	 { "008.015.510-30", "Dado já cadastrado." } 
        });
    }
    
    public boolean Verify_CPF(String in, String expected)
    {		
    	
    	WebElement usernameTextField = this.driver.findElement(By.name("txtUsuario"));
		usernameTextField.sendKeys("lucaspp");
		
		WebElement PasswordTextField = this.driver.findElement(By.name("txtSenha"));
		PasswordTextField.sendKeys("123456");
		
		WebElement LoginButton = this.driver.findElement(By.tagName("button"));
		LoginButton.click();
    	
		driver.get("https://devbs.azurewebsites.net/Pessoa/Create");
		WebElement Cpf = this.driver.findElement(By.id("Cpf"));
		Cpf.sendKeys(in);
		
		WebElement SalvarButton = this.driver.findElement(By.id("btnSalvar"));
		SalvarButton.click();

		actual = Cpf.findElement(By.xpath("//span[@class='field-validation-error']")).getText();
		
		if(actual.equals(expected))
		{
			return true;
		}else
			{
			return false;
			}
	
    }
    
    @Before 
	public void setUp(){
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.get("https://devbs.azurewebsites.net");
		
		//Estou utilizando o assert neste exemplo para demostrar conhecimento
		//this.verifificationpoint = new LoginVerificationPoint(driver);
	}

    
    @Test
      public void test_CPF_Param(){   
    	
        assertTrue(Verify_CPF(actual,expected));
      }
       
    @After
	public void tearDown() {
		
		this.driver.quit();
		
	}
    
}
