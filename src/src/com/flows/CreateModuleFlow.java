package src.com.flows;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import src.com.pages.CreateModulePage;;

public class CreateModuleFlow {
	
	WebDriver driver;
	CreateModulePage objmod;
	
	public CreateModuleFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	 
	
	public void CreateModuleScenario(String ModName, String ModDescr) throws InterruptedException, IOException
	{
		objmod = new CreateModulePage(driver);
		
		//Clicking on New Module 
		objmod.clickNewModule();
		
		//Entering Module Title
		objmod.setModuleTitle(ModName);
		
		//Clicking on Create Module
		objmod.clickCreateModule();
		
		//Entering Lesson Desc
		objmod.setModuleDesc(ModDescr);
				
		//Attaching File Resource
		objmod.AttachFileResource();
				
		//Attaching Existing Resource
		objmod.AttachExistingResource();
				
		//Attaching TchVideo
		objmod.AttachTchResource();
		
		//Clicking on Create Lesson
		objmod.clickCreateLesson();
	}
	
}
