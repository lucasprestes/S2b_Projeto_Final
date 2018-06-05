package verificationpoint;

import org.openqa.selenium.WebDriver;

public class LoginVerificationPoint {
	private WebDriver driver;
	
	public LoginVerificationPoint(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String message = "";
	
	public void checkTestLoginSuccess() 
	{
		message = "TEST T16A01";
		if(this.driver.getPageSource().contains("Bem Vindo!"))
		{
			message += " - APPROVED";

		}else 
			{
				message += " - REPROVED";
			}
		
		System.out.println(message);
	}
	
	public void checkTestLoginFail() 
	{
		 message = "TEST T16A01";
		if(this.driver.getPageSource().contains("Usuário e/ou senha inválidos."))
		{
			message += " - APPROVED";

		}else 
			{
				message += " - REPROVED";
			}
		
		System.out.println(message);
			
	}
	
	
	

}
