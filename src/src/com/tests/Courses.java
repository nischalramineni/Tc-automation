package src.com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import src.com.flows.CollaborationFlow;
import src.com.flows.CreateAssignmentFlow;
import src.com.flows.CreateCourseFlow;
import src.com.flows.CreateModuleFlow;
import src.com.flows.LoginFlow;
import src.com.utilities.ExcelUtils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Courses {
	
	 public WebDriver driver;
	  public String DriverPath = "C:/Drivers/chromedriver.exe";
	  //objects creation
	  LoginFlow 		objloginflow;
	  CreateCourseFlow  objcourseflow;
	  CreateModuleFlow  objmodflow;
	  CreateAssignmentFlow objassflow;
	  CollaborationFlow objcolab;
 @BeforeClass
  public void beforeClass() throws Exception {
	 System.setProperty("webdriver.chrome.driver", DriverPath);
	  String filePath = System.getProperty("user.dir")+"\\Data\\Courses.xlsx";
		//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
		ExcelUtils.setExcelFile(filePath,"CoursesSheet");
		
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
 
 @Test(priority = 1)
  public void testCreateCourse() throws Exception {
	 objcourseflow = new CreateCourseFlow(driver);
	 
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  
		String sCourseName = ExcelUtils.getCellData(1, 3);

		String sCourseDesc = ExcelUtils.getCellData(1, 4);

		String sGradeValue = ExcelUtils.getCellData(1, 5);
		
		//Calling Create Course Scenario
		objcourseflow.CreateCourseScenario(sCourseName, sCourseDesc, sGradeValue);
  }

 @Test(priority = 2)
 public void testCreateModule() throws Exception {
	 objmodflow = new CreateModuleFlow(driver);
	 
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  
		String sModuleTitle = ExcelUtils.getCellData(1, 6);
		String sModuleDesc  = ExcelUtils.getCellData(1, 7);
		
		//Calling Create Module Flow
		objmodflow.CreateModuleScenario(sModuleTitle, sModuleDesc);
 }
 
 @Test(priority = 3)
 public void testCreateAssignment() throws Exception {
	 objassflow = new CreateAssignmentFlow(driver);
	 
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  
		String sAssgnDesc  = ExcelUtils.getCellData(1, 8);
		
		//Calling Create Module Flow
		objassflow.CreateAssignmentScenario(sAssgnDesc);
 }
 
 @Test(priority = 4)
 public void testCreateInstructions() throws Exception {
	 objcolab = new CollaborationFlow(driver);
	 
	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	  
		String sInstrs  = ExcelUtils.getCellData(1, 9);
		
		//Calling Create Module Flow
		objcolab.CreateInstructionsScenario(sInstrs);
 }

 @AfterClass
  public void afterClass() {
	//driver.close();
	  //driver.quit();
  }

}
