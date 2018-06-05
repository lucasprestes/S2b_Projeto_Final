package verificationpoint;

import org.openqa.selenium.WebDriver;

public class LoginVerificationPoint {
	private WebDriver driver;
	
	public LoginVerificationPoint(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void checkTestLoginSuccess() {
		if(this.driver.getPageSource().contains("Bem Vindo!"))
		{
			System.out.println("APPROVED - TEST XXXXX");
			
		}else 
			{
				System.out.println("REPROVED - TEST XXXXX");
			}
	}

}
