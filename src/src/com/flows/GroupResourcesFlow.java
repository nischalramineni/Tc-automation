package src.com.flows;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import src.com.pages.GroupResourcesPage;

public class GroupResourcesFlow {

	WebDriver driver;
	GroupResourcesPage objres;
	
	public GroupResourcesFlow(WebDriver driver)
	{
		this.driver=driver;
	}

	public void AddResources(String webLink, String Grade, String Email, String Pwd) throws IOException{
		objres = new GroupResourcesPage(driver);
		
		objres.ClickResources();
		
		//Attaching File Resource
		objres.AttachFileResource();
		
		//Attaching Link Resource
		objres.AttachLinkResource(webLink, Grade);
								
		//Attaching Cloud DOc Resource
		objres.AttachDocResource(Email, Pwd, Grade);

		//Attaching Existing Resource
		objres.AttachExistingResource();
				
		//Attaching TchVideo
		objres.AttachTchResource();
	}
}
