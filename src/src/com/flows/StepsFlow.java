package src.com.flows;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import src.com.pages.StepsPage;

public class StepsFlow {
	
	WebDriver driver;
	StepsPage objstep;
	
	public StepsFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	 
	
	public void CreateStepScenario(String stepTitle, String stepDesc, String webLink, String Grade, String Email, String Pwd) throws InterruptedException, IOException
	{
		objstep = new StepsPage(driver);
		
		//clicking on Add Step link
		objstep.clickStepID();
		
		//Select Step Template
		objstep.selectStepTemplate();
		
		//Entering Step Title
		objstep.enterStepTitle(stepTitle);
		
		//Entering Step Description
		objstep.enterStepDesc(stepDesc);
		
		//Attaching File Resource
		objstep.AttachFileResource();
		
		//Attaching Link Resource
		objstep.AttachLinkResource(webLink, Grade);
						
		//Attaching Cloud DOc Resource
		objstep.AttachDocResource(Email, Pwd, Grade);
		
		//Attaching Existing Resource
		objstep.AttachExistingResource();
		
		//Attaching TchVideo
		objstep.AttachTchResource();
				
		//Adding Action
		objstep.clickAddAction();
		objstep.enterAction();
		
		//Click Add Step
		objstep.clickAddStep();
		
	}
	
}
