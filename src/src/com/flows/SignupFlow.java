package src.com.flows;
import org.openqa.selenium.WebDriver;
import src.com.pages.SignupPage;

public class SignupFlow {

	WebDriver driver;
	SignupPage objsignup;
	
	public SignupFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SignupScenario(String fname, String lname, String email, String pwd) throws InterruptedException{
		
		objsignup = new SignupPage(driver);
		
		objsignup.clickSignup();
		objsignup.setFirstName(fname);
		objsignup.setLastName(lname);
		objsignup.setEmail(email);
		objsignup.setPassword(pwd);
		objsignup.setPasswordConf(pwd);
		objsignup.clickSubmit();
	}
}
