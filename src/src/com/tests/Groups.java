package src.com.tests;

import org.testng.annotations.Test;

import src.com.flows.GroupsFlow;
import src.com.flows.LoginFlow;
import src.com.flows.GroupResourcesFlow;
import src.com.flows.StepsFlow;
import src.com.utilities.ExcelUtils;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


public class Groups {
  public WebDriver driver;
  public String DriverPath = "C:/Drivers/chromedriver.exe";
  //objects creation
  LoginFlow objloginflow;
  GroupsFlow objgroupflow;
  StepsFlow objstepflow;
  GroupResourcesFlow objresflow;
  
  @BeforeClass
  public void beforeClass() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver", DriverPath);
	  String filePath = System.getProperty("user.dir")+"\\Data\\Groups.xlsx";
		//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
		ExcelUtils.setExcelFile(filePath,"GroupsSheet");
		
	  driver = new ChromeDriver();
	  //This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method 
	  String BaseURL = ExcelUtils.getCellData(1, 0);
	  driver.get(BaseURL);
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//button[contains(@class,'btn transparent modal--close icon x square js-modal-close')]")).click();
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

  }
  
  @Test (priority = 1)
  public void testCreateGroup() throws Exception {
	  objgroupflow = new GroupsFlow(driver);
	  objstepflow  = new StepsFlow(driver);
	  objresflow   = new GroupResourcesFlow(driver);
	  
	 
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  String sGroupName 	= ExcelUtils.getCellData(1, 3);
	  String sPurpose   	= ExcelUtils.getCellData(1, 4);
	  String sGroupType 	= ExcelUtils.getCellData(1, 5);
	  String sPrivacy   	= ExcelUtils.getCellData(1, 6);
	  String sSchValue 		= ExcelUtils.getCellData(1, 7);
	  String sGradeValue 	= ExcelUtils.getCellData(1, 8);
	  objgroupflow.CreateGroupScenario(sGroupName, sPurpose, sGroupType, sPrivacy, sSchValue, sGradeValue);
	 
  }
  
  @Test (priority = 2)
  public void testCreateStep() throws Exception {
	  objstepflow  = new StepsFlow(driver);
	  
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  String sGradeValue 	= ExcelUtils.getCellData(1, 8);
	  String sStepTitle 	= ExcelUtils.getCellData(1, 9);
	  String sStepDesc	 	= ExcelUtils.getCellData(1, 10);
	  String sLink			= ExcelUtils.getCellData(1, 11);
	  String sEmail			= ExcelUtils.getCellData(1, 12);
	  String sPwd			= ExcelUtils.getCellData(1, 13);
	  objstepflow.CreateStepScenario(sStepTitle, sStepDesc,sLink,sGradeValue, sEmail, sPwd);
	 
  }

  @Test (priority = 3)
  public void testAddResources() throws Exception {
	  
	  objresflow   = new GroupResourcesFlow(driver);
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  String sGradeValue 	= ExcelUtils.getCellData(1, 8);
	  String sLink			= ExcelUtils.getCellData(1, 11);
	  String sEmail			= ExcelUtils.getCellData(1, 12);
	  String sPwd			= ExcelUtils.getCellData(1, 13);
	  
	  objresflow.AddResources(sLink,sGradeValue, sEmail, sPwd);
	 
  }
  @AfterClass
  public void afterClass() {
	// driver.close();
	// driver.quit();
  }

}
