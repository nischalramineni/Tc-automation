package src.com.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import src.com.flows.LoginFlow;
import src.com.utilities.ExcelUtils;

public class SignIn {
	public String DriverPath = "C:/Drivers/chromedriver.exe";
	public WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	//Creation of flow object
	LoginFlow objloginflow;
	
 @BeforeClass
  public void beforeClass() throws Exception {
	System.setProperty("webdriver.chrome.driver", DriverPath);
	 String filePath = System.getProperty("user.dir")+"\\Data\\Login.xlsx";
	//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
	ExcelUtils.setExcelFile(filePath,"LoginSheet");
	driver = new ChromeDriver();
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method 
	String BaseURL = ExcelUtils.getCellData(1, 0);
	driver.get(BaseURL);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[contains(@class, 'btn transparent modal--close icon x square js-modal-close')]")).click();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
 }  

  @Test(priority = 0)
  public void testLogin() throws Exception {
	  objloginflow = new LoginFlow(driver);
	  
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  
		String sUserName = ExcelUtils.getCellData(1, 1);

		String sPassword = ExcelUtils.getCellData(1, 2);

	  //Calling Login Functionality
	  objloginflow.LoginScenario(sUserName, sPassword);
	  
	  //Calling Forgot Password Functionality
	 // objloginflow.ForgotPwdScenario(sUserName);
  }

  @AfterClass
  public void afterClass() {
	 driver.close();
	 driver.quit();
  }

}
