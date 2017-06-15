package src.com.flows;
import org.openqa.selenium.WebDriver;
import src.com.pages.GroupsPage;

public class GroupsFlow {
	
	WebDriver driver;
	GroupsPage objgroup;
	
	public GroupsFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	 
	
	public void CreateGroupScenario(String grpName, String purpose, String grpType, String GroupPrivacy, String SchValue, String GradeValue) throws InterruptedException
	{
		objgroup = new GroupsPage(driver);
		
		//clicking on group link
		objgroup.clickGroupLink();
		
		//clicking on new group 
		objgroup.clickNewGroup();
		
		//Entering Group Name
		objgroup.setGroupName(grpName);
		
		//Entering Purpose
		objgroup.setPurpose(purpose);
		
		//clicking group type
		objgroup.setGroupType(grpType, GroupPrivacy, SchValue, GradeValue);
		
		//Clicking on Create Group Button
		objgroup.clickCreateGroup();
	}
	
}
