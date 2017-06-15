package src.com.pages;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAssignmentPage {

WebDriver driver;
	
	
	public CreateAssignmentPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	//Object Repository
	private By Assignments      = By.xpath("//a[contains(text(),'Assignment')]");
	private By NewAssignment		= By.xpath("//button[contains(@class,'btn js-toggle-show js-toggle-hide-on-show')]");
	private By CreateAssignment     = By.xpath("//input[contains(@class,'btn primary a-create-course-assignment')]");
	
	//private By AssgnDesc			= By.xpath("//div[contains(@class,'tinymce-input--toolbar')]");
	
	//Attach Resources
		private By AttachResources = By.xpath("//button[contains(@class,'js-action-menu-open js-action-menu-spinner')]");
		//Add New Resource
		private By NewResource = By.xpath("//li[contains(@class,'action-add menu-item attachment-type a-add-new-resource')]");
			//File
			private By FileType = By.xpath("//div[contains(text(),'File')]");
				//ChooseFile
				private By ChooseFile = By.xpath("//span[contains(text(),'Choose File')]");
				//ResourceTitle
				private By ResourceTitle = By.id("resource_title");
				//ResourceDescription
				private By ResourceDesc = By.id("resource_description");
				
			//Link
			//private By LinkType = By.xpath("//div[contains(text(),'Link')]");
			//Google Doc
			//private By DocType = By.xpath("//div[contains(text(),'Google Doc')]");
			
		//Add Existing Resource
		private By ExistingResource = By.xpath("//a[contains(text(),'Existing Resource')]");
		private By ResourceContainer = By.xpath("//li[contains(@class,'js-resource-list-item resource spaced-list--item')]");
		private By AttachRes		 = By.xpath("//button[contains(text(),'Attach')]");
		//Add Existing Resource
		private By TchResource = By.xpath("//a[contains(text(),'Tch Video')]");
		private By TchSearch   = By.xpath("//button[contains(@class,'search-field--button')]");
		private By TchVideo	   = By.xpath("//li[contains(@class,'spaced-list--item video')]");

		//Submit
		private By SubmitButn = By.name("commit");
		
	//public methods
	
	public void clickAssignmentsLink(){
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Assignments));
			element.click();		
	}
		
	public void clickNewAssignment(){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NewAssignment));
		element.click();		
	}
	
	
	public void setAssignmentDesc(String AssgDescr){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();	
		
		WebElement frame = driver.findElement(By.xpath("//*[contains(@id, 'course_assignment_instructions_ifr')]"));
		driver.switchTo().frame(frame); 	
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement body = driver.findElement(By.cssSelector("body"));
		body.click();
		body.sendKeys(AssgDescr);
		driver.switchTo().defaultContent();	
		}
	
	public void AttachFileResource() throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement eleAttachRes = wait.until(ExpectedConditions.elementToBeClickable(AttachResources));
		eleAttachRes.click();		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NewResource));
		String parentWindow = driver.getWindowHandle();
		element.click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		//Checking File Type
		WebElement eleFileType = wait.until(ExpectedConditions.elementToBeClickable(FileType));
		eleFileType.click();
		
		//Choose File
		WebElement eleChooseFile = wait.until(ExpectedConditions.elementToBeClickable(ChooseFile));
		eleChooseFile.click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 
		// below line execute the AutoIT script .
	     Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Entering Resource Title
		WebElement eleResourceTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(ResourceTitle));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleAttachRes);
        } catch (Exception e) {

        }

		eleResourceTitle.sendKeys("Sample Step Resource");
		
		//Entering Resource Description
		WebElement eleResourceDesc = wait.until(ExpectedConditions.elementToBeClickable(ResourceDesc));
		eleResourceDesc.click();
		eleResourceDesc.sendKeys("Sample Description");
		
		//Clicking on Submit Button
		WebElement eleSubmit = wait.until(ExpectedConditions.elementToBeClickable(SubmitButn));
		eleSubmit.click();
		
		driver.switchTo().window(parentWindow);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void AttachExistingResource() throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement eleAttachRes = driver.findElement(AttachResources);
		//WebElement eleAttachRes = wait.until(ExpectedConditions.visibilityOfElementLocated(AttachResources));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleAttachRes);
        } catch (Exception e) {

        }
		//eleAttachRes.click();		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ExistingResource));
		String parentWindow = driver.getWindowHandle();
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        } catch (Exception e) {

        }

		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		List<WebElement> resCont = driver.findElements(ResourceContainer);
		System.out.println(resCont.size());
		WebElement res = resCont.get(2);

	    try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", res);
        } catch (Exception e) {

        }
	    WebElement btnAttach = wait.until(ExpectedConditions.elementToBeClickable(AttachRes));
		
	    try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", btnAttach);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", btnAttach);
        } catch (Exception e) {

        }

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().window(parentWindow);
	}
	
	public void AttachTchResource() throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement eleAttachRes = driver.findElement(AttachResources);
		//WebElement eleAttachRes = wait.until(ExpectedConditions.visibilityOfElementLocated(AttachResources));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleAttachRes);
        } catch (Exception e) {

        }
		//eleAttachRes.click();		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(TchResource));
		String parentWindow = driver.getWindowHandle();
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        } catch (Exception e) {

        }

		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		WebElement TchSearchIcon = wait.until(ExpectedConditions.elementToBeClickable(TchSearch));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", TchSearchIcon);
        } catch (Exception e) {

        }

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List <WebElement> allChildobjs = driver.findElements(TchVideo);
		int count = allChildobjs.size();
		System.out.println("Number of child objects:"+count);
		
		WebElement res = allChildobjs.get(2);
		try {
			((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", res);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", res);
        } catch (Exception e) {

        }
	    WebElement btnAttach = wait.until(ExpectedConditions.elementToBeClickable(AttachRes));
		
	    try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", btnAttach);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", btnAttach);
        } catch (Exception e) {

        }

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().window(parentWindow);
		
		wait.until(ExpectedConditions.elementToBeClickable(AttachResources));
		
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleAttachRes);
        } catch (Exception e) {

        }
		//eleAttachRes.click();		
		wait.until(ExpectedConditions.elementToBeClickable(TchResource));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        } catch (Exception e) {

        }
		
	/*	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
	*/
		//WebElement TchCancelIcon = wait.until(ExpectedConditions.elementToBeClickable(CancelButn));
	/*	List <WebElement> childs = driver.findElements(CancelButn);
		
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", childs.get(0));
        } catch (Exception e) {
	}
	*/
         
		//driver.switchTo().window(parentWindow);
		
		
	}

	public void clickCreateAssignment(){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CreateAssignment));
		try {
			
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        	} catch (Exception e) {

        }
		
		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
	}
		
}
