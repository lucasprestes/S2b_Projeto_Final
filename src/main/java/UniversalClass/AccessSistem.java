package UniversalClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AccessSistem {
	
	private WebDriver driver;
	
	
	public Boolean IsLoginValid() {
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.get("https://devbs.azurewebsites.net");
		
		WebElement usernameTextField = this.driver.findElement(By.name("txtUsuario"));
		usernameTextField.sendKeys("lucaspp");
		
		WebElement PasswordTextField = this.driver.findElement(By.name("txtSenha"));
		PasswordTextField.sendKeys("123456");
		
		WebElement LoginButton = this.driver.findElement(By.tagName("button"));
		LoginButton.click();
		
		if(this.driver.getPageSource().contains("Usuário e/ou senha inválidos."))
		{
			return false;
		}else 
			{
			return true;
			}

	}
	
	
	
public Boolean IsLoginValid(String User, String Pwd) {
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.get("https://devbs.azurewebsites.net");
		
		WebElement usernameTextField = this.driver.findElement(By.name("txtUsuario"));
		usernameTextField.sendKeys(User);
		
		WebElement PasswordTextField = this.driver.findElement(By.name("txtSenha"));
		PasswordTextField.sendKeys(Pwd);
		
		WebElement LoginButton = this.driver.findElement(By.tagName("button"));
		LoginButton.click();
		
		if(this.driver.getPageSource().contains("Usuário e/ou senha inválidos."))
		{
			return false;
		}else 
			{
			return true;
			}

	}
	
	
	

}
