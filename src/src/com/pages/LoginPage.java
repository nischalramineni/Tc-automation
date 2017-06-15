package src.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	//Object Repository
	
	private By signIn = By.xpath("//a[contains(text(), 'Sign In')]");
	
	private By emailId = By.id("user_email");
	
	private By password = By.id("user_password");
	
	private By btnSignin = By.xpath("//button[contains(text(), 'Sign In')]");
	
	private By forgotPwd = By.xpath("//a[contains(text(), 'Forgot your password?')]");
	
	private By sendResetInstr = By.xpath("//span[contains(text(), 'Send Reset Instructions')]");
	
	//Public Methods 
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickSignin() throws InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(signIn).click();
	}
	
	public void setUserName(String strUserName){

		driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys(strUserName);

    }

	public void setPassword(String strPassword){

		driver.findElement(password).click();
        driver.findElement(password).sendKeys(strPassword);

    }

	public void clickLogin() throws InterruptedException
	{
		driver.findElement(btnSignin).isDisplayed();
		driver.findElement(btnSignin).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
	}
	
	public void clickForgotPwd(String EmailId) throws InterruptedException
	{
		driver.findElement(forgotPwd).isDisplayed();
		driver.findElement(forgotPwd).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sendResetInstr));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(emailId).click();
		driver.findElement(emailId).sendKeys(EmailId);
		element.click();
				
	}

}
