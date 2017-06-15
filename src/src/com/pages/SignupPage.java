package src.com.pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

	WebDriver driver;
	
	//Object Repository
	
	private By signUp 			= By.xpath("//a[contains(text(), 'Sign Up')]");
	
	private By firstName 		= By.id("new_registration_form_first_name");
	
	private By lastName  		= By.id("new_registration_form_last_name");
	
	private By emailId  		= By.id("new_registration_form_email");
	
	private By password  		= By.id("new_registration_form_password");
	
	private By passwordConfirm  = By.id("new_registration_form_password_confirm");
	
	private By btnSignUp		= By.xpath("//button[contains(text(), 'Sign Up')]");
	
	//Public Methods 
	
		public SignupPage(WebDriver driver)
		{
		this.driver=driver;
		}
		
		public void clickSignup() throws InterruptedException{
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(signUp).click();
		}
		
		public void setFirstName(String fname){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstName));
			element.click();
			element.sendKeys(fname);
		}
		
		public void setLastName(String lname){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(lastName));
			element.click();
			element.sendKeys(lname);
		}
		
		public void setEmail(String email){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailId));
			element.click();
			element.sendKeys(email);
		}
		
		public void setPassword(String pwd){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(password));
			element.click();
			element.sendKeys(pwd);
		}
		
		public void setPasswordConf(String pwdconf){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordConfirm));
			element.click();
			element.sendKeys(pwdconf);
		}
		
		public void clickSubmit(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnSignUp));
			element.click();
		}
		
		

}
