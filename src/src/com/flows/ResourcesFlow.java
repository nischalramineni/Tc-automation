package src.com.flows;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import src.com.pages.ResourcesPage;

public class ResourcesFlow {

	WebDriver driver;
	ResourcesPage objres;
	
	public ResourcesFlow(WebDriver driver)
	{
		this.driver=driver;
	}

	public void GetResources() throws IOException, InterruptedException{
		
		int [] counts = new int[3];
		
		objres = new ResourcesPage(driver);
		
		//Click on Resources Tab
		objres.clickResources();
		
		//Get Resources Count
		counts = objres.getResourceCount();
		
		//Counts Verification
		objres.CountVerification(counts[0],counts[1]);
	}
}
