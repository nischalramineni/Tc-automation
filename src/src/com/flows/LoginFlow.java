package src.com.flows;
import org.openqa.selenium.WebDriver;
import src.com.pages.LoginPage;

public class LoginFlow {

	WebDriver driver;
	LoginPage objlogin; 
	public LoginFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	 
	
	public void LoginScenario(String Uname, String Pwd) throws InterruptedException
	{
		objlogin = new LoginPage(driver);
		
		objlogin.clickSignin();
		objlogin.setUserName(Uname);
		objlogin.setPassword(Pwd);
		objlogin.clickLogin();
	}
	
	public void ForgotPwdScenario(String Uname) throws InterruptedException
	{
		objlogin = new LoginPage(driver);
		objlogin.clickSignin();
		objlogin = new LoginPage(driver);
		objlogin.clickForgotPwd(Uname);
	}
}
