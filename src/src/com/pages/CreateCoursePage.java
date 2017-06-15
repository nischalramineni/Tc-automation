package src.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCoursePage {
	WebDriver driver;
	
	
	public CreateCoursePage(WebDriver driver){
		this.driver = driver;
		
	}
	
	//Object Repository
	private By CoursesLink 	= By.xpath("//a[contains(text(),'Courses')]");
	private By newCourse   	= By.xpath("//button[contains(text(),'New Course')]");
	private By courseName  	= By.id("course_title");
	private By courseDesc   = By.id("course_description");
	private By createCourse = By.xpath("//input[contains(@class,'btn primary a-create-course')]");
	private By newMod		= By.xpath("//button[contains(@class,'btn js-toggle-show js-toggle-hide-on-show')]");
	//public methods
	
	public void clickCoursesLink(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CoursesLink));
		element.click();		
	}
	
	public void clickNewCourse(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(newCourse));
		element.click();		
	}
	
	public void setCourseName(String CourseName){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(courseName));
		element.click();
		element.sendKeys(CourseName);
	}
	
	public void setCourseDesc(String CourseDesc){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(courseDesc));
		element.click();
		element.sendKeys(CourseDesc);
	}
	
	public void selectGradeValue(String GradeValue){
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			WebElement Grade = driver.findElements(By.xpath("//div[contains(@class,'selectize-input items not-full has-options')]")).get(0);
			Grade.click();
			driver.findElement(By.xpath("//div[contains(@class,'selectize-dropdown-content')]//div[text()='"+GradeValue+"']")).click();
			driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		}
		
	
	public void clickCreateCourse(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(createCourse));
		element.click();
		WebElement Step = wait.until(ExpectedConditions.visibilityOfElementLocated(newMod));
		Step.isDisplayed();
	}
}
