package verificationpoint;

import org.openqa.selenium.WebDriver;

public class LoginVerificationPoint {
	private WebDriver driver;
	
	public LoginVerificationPoint(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkhellomessage() {
		if(this.driver.getPageSource().contains("Hi demo"))
		{
			System.out.println("passou");
			
		}else 
			{
				System.out.println("nao passou");
			}
	}

}
