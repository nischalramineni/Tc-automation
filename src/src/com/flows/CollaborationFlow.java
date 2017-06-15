package src.com.flows;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import src.com.pages.CreateCollaborationPage;

public class CollaborationFlow {
	
	WebDriver driver;
	CreateCollaborationPage objcolab;
	
	public CollaborationFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	 
	
	public void CreateInstructionsScenario(String Instrs) throws InterruptedException, IOException
	{
		objcolab = new CreateCollaborationPage(driver);
		
		//Clicking on Collaboration Link 
		objcolab.clickCollaborationLink();
		
		//Clicking on Add Instructions
		objcolab.clickAddInstructions();
		
		//Entering Instructions 
		objcolab.setCollabInstructions(Instrs);
				
		//Clicking on Create Instructions
		objcolab.clickCreateInstructions();
	}
	
}
