package src.com.tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

import src.com.flows.SignupFlow;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SignUp {

	public String BaseURL = "http://www.Teachingchannel.org";
	public String DriverPath = "C:/Drivers/chromedriver.exe";
	public WebDriver driver;
	//Creation of flow object
	SignupFlow objflow;
  @BeforeClass
  public void beforeClass() {
	  	
	  	System.setProperty("webdriver.chrome.driver", DriverPath);
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(@class, 'btn transparent modal--close icon x square js-modal-close')]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();

  }

  @Test
  public void testSignUp() throws InterruptedException {
	  objflow = new SignupFlow(driver);
	  objflow.SignupScenario("ramineni", "Nischal", "ramineninischal@gmail.com", "crazyguy206");
  }
  
  @AfterClass
  public void afterClass() {
	  //	driver.close();
		//driver.quit();
  }
  

}
