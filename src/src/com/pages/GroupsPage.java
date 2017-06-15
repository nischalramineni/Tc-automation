package src.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupsPage {
	WebDriver driver;
	
	
	public GroupsPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	//Object Repository
	private By groupsLink 	= By.xpath("//a[contains(text(),'Groups')]");
	private By newGroup   	= By.xpath("//div[contains(@class,'btn-step-style')]");
	private By groupName  	= By.id("group_name");
	private By groupPurpose = By.id("group_purpose");
	//Group Type
	private By internalGroup=  By.id("group_cross_team_false");
	private By crossteamGroup= By.id("group_cross_team_true");
	//Group Privacy
	private By openGroup	= By.id("group_invite_only_false");
	private By invitedGroup	= By.id("group_invite_only_true");
	//Scholastic Drop down
	private By schdrpdwn	= By.xpath("//div[contains(@class,'selectize-input items not-full has-options')]");
	
	private By StepID		= By.xpath("//div[contains(text(),'Add Step')]");
	
	private By btnCreateGroup = By.xpath("//input[contains(@name,'commit')]");
	
	//public methods
	
	public void clickGroupLink(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(groupsLink));
		element.click();		
	}
	
	public void clickNewGroup(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(newGroup));
		element.click();		
	}
	
	public void setGroupName(String grpName){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(groupName));
		element.click();
		element.sendKeys(grpName);
	}
	
	public void setPurpose(String purpose){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(groupPurpose));
		element.click();
		element.sendKeys(purpose);
	}
	
	public void setGroupType(String GroupType, String GroupPrivacy, String SchValue, String GradeValue){
		if(GroupType.equals("InternalGroup")){
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(internalGroup));
			element.click();
			//Group Privacy
			if(GroupPrivacy.equals("Open")){
				WebElement opengrp = wait.until(ExpectedConditions.elementToBeClickable(openGroup));
				opengrp.click();
			}
			else if(GroupPrivacy.equals("InvitedGroup")){
			WebElement invitedgrp = wait.until(ExpectedConditions.elementToBeClickable(invitedGroup));
			invitedgrp.click();
			}
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement eledrp = wait.until(ExpectedConditions.elementToBeClickable(schdrpdwn));
			try {
	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].click()", eledrp);
	        } catch (Exception e) {

	        }

			driver.findElement(By.xpath("//div[contains(@class,'selectize-dropdown-content')]//div[text()='"+SchValue+"']")).click();
		
		}
		else if(GroupType.equals("CrossTeam")){
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(crossteamGroup));
			element.click();
			
			//Group Privacy
			if(GroupPrivacy.equals("Open")){
				WebElement opengrp = wait.until(ExpectedConditions.elementToBeClickable(openGroup));
				opengrp.click();
			}
			else if(GroupPrivacy.equals("InvitedGroup")){
			WebElement invitedgrp = wait.until(ExpectedConditions.elementToBeClickable(invitedGroup));
			invitedgrp.click();
			}
			
			//Entering Grades 
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			//driver.findElement(grades).click();
			driver.findElement(By.xpath("//span[contains(text(),'Subjects')]")).click();
			driver.switchTo().activeElement().sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//div[contains(@class,'selectize-dropdown-content')]//div[text()='"+GradeValue+"']")).click();
			driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		}
		
	}
	
	public void clickCreateGroup(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnCreateGroup));
		element.click();
		WebElement Step = wait.until(ExpectedConditions.visibilityOfElementLocated(StepID));
		Step.isDisplayed();
	}
}
