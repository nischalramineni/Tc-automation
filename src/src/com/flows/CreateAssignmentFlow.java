package src.com.flows;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import src.com.pages.CreateAssignmentPage;

public class CreateAssignmentFlow {
	
	WebDriver driver;
	CreateAssignmentPage objass;
	
	public CreateAssignmentFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	 
	
	public void CreateAssignmentScenario(String AssgnDescr) throws InterruptedException, IOException
	{
		objass = new CreateAssignmentPage(driver);
		
		//Clicking on Assignments Link 
		objass.clickAssignmentsLink();
		
		//Clicking on New Assignment
		objass.clickNewAssignment();
		
		//Entering Assignment Description
		objass.setAssignmentDesc(AssgnDescr);
		
		//Attaching File Resource
		objass.AttachFileResource();
				
		//Attaching Existing Resource
		objass.AttachExistingResource();
				
		//Attaching TchVideo
		objass.AttachTchResource();
				
		//Clicking on Create Lesson
		objass.clickCreateAssignment();
	}
	
}
