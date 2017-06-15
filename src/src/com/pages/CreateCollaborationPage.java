package src.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCollaborationPage {

WebDriver driver;
	
	
	public CreateCollaborationPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	//Object Repository
	private By Collaboration      = By.xpath("//a[contains(text(),'Collaboration')]");
	private By AddInstructions		= By.xpath("//button[contains(@class,'btn js-toggle-show js-toggle-hide-on-show')]");
	private By CreateInstructions     = By.xpath("//input[contains(@class,'btn primary a-create-course-collaboration-settings')]");
	
		
	//public methods
	
	public void clickCollaborationLink(){
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Collaboration));
			element.click();		
	}
		
	public void clickAddInstructions(){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddInstructions));
		element.click();		
	}
	
	
	public void setCollabInstructions(String AssgDescr){
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();	
		
		WebElement frame = driver.findElement(By.xpath("//*[contains(@id, 'course_collaboration_setting_instructions_ifr')]"));
		driver.switchTo().frame(frame); 	
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement body = driver.findElement(By.cssSelector("body"));
		body.click();
		body.sendKeys(AssgDescr);
		driver.switchTo().defaultContent();	
	
		}
	
	public void clickCreateInstructions(){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CreateInstructions));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {

        }

		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        } catch (Exception e) {

        }

	}
		
}
