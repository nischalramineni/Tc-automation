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

public class StepsPage {
	WebDriver driver;
	
	
	public StepsPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	//Object Repository
	private By StepID		= By.xpath("//div[contains(text(),'Add Step')]");
	//Step Template
	private By StepTemplate = By.xpath("//div[contains(@class,'selectize-dropdown-content')]//div[text()='Create your own Learning Plan Step!']");
	//StepTitle 
	private By StepTitle	= By.xpath("//input[contains(@name,'learning_plan_step[title]')]");
	//Step Description
	//private By StepDesc   	= By.xpath("//div[contains(@class,'mce-edit-area mce-container mce-panel mce-last mce-stack-layout-item')]");
	//private By StepDesc   	= By.id("tinymce");
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
		private By LinkType = By.xpath("//div[contains(text(),'Link')]");
			//URL 
			private By URL = By.xpath("//input[contains(@id,'resource_url')]");
			//Title
			private By resTitle = By.xpath("//input[contains(@id,'resource_title')]");
			//Description
			private By resDesc = By.xpath("//textarea[contains(@id,'resource_description')]");
			
		//Google Doc
		private By DocType = By.xpath("//div[contains(text(),'Google Doc')]");
		//ChooseDoc
		private By ChooseDoc = By.xpath("//span[contains(text(),'Choose Google Doc')]");
		
			//Connect to Google Account
			private By ConnectGoogle = By.xpath("//a[contains(text(),'Connect to your Google account')]");
			
			//Disconnect existing connection
			private By DisconnectGoogle = By.xpath("//a[contains(text(),'Disconnect from your Google account')]");
		
			//Use Another Account
			private By UseAnotherAccount = By.xpath("//p[contains(text(),'Use another account')]");
			
			//Email 
			private By Email = By.xpath("//input[contains(@id,'identifierId')]");
			
			//Password
			private By Password = By.xpath("//input[contains(@name,'password')]");
			
			//Next Button
			private By btnNext = By.xpath("//span[contains(text(),'Next')]");
			
			//Allow Button
			private By btnAllow = By.xpath("//span[contains(text(),'ALLOW')]");
			//Resource selection
			private By resSelect = By.xpath("//div[contains(@class,'card--link js-resource-list-item')]");
			//Select Doc
			private By selectDoc = By.xpath("//button[contains(text(),'Select')]");
		//Add Existing Resource
	private By ExistingResource = By.xpath("//a[contains(text(),'Existing Resource')]");
	private By ResourceContainer = By.xpath("//li[contains(@class,'js-resource-list-item resource spaced-list--item')]");
	private By AttachRes		 = By.xpath("//button[contains(text(),'Attach')]");
	//Add Existing Resource
	private By TchResource = By.xpath("//a[contains(text(),'Tch Video')]");
	private By TchSearch   = By.xpath("//button[contains(@class,'search-field--button')]");
	private By TchVideo	   = By.xpath("//li[contains(@class,'spaced-list--item video')]");
	//Add Action
	private By AddAction= By.xpath("//a[contains(text(),'Add an Action')]");
	private By ActionTitle = By.xpath("//input[contains(@class,'js-add-list-item-on-enter')]");
	//Submit Resource
	private By SubmitRes = By.xpath("//input[contains(@class,'btn primary js-attach icon-spinner res-form-submit')]");
	//Submit
	private By SubmitButn = By.name("commit");
	//public methods
	
	public void clickStepID(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(StepID));
		element.click();		
	}
	
	public void selectStepTemplate(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement stepTemp = wait.until(ExpectedConditions.elementToBeClickable(StepTemplate));
		stepTemp.click();
	
	}
	
	public void enterStepTitle(String stepTitle){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(StepTitle));
		element.click();
		element.sendKeys(stepTitle);
	}
	
	public void enterStepDesc(String stepDesc){
		//WebDriverWait wait = new WebDriverWait(driver,10);
		driver.switchTo().defaultContent();	
		WebElement frame = driver.findElement(By.xpath("//*[contains(@id, 'mce_1_ifr')]"));
		driver.switchTo().frame(frame); 	
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement eleBody = driver.findElement(By.cssSelector("body"));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleBody);
        } catch (Exception e) {}		
		eleBody.sendKeys(stepDesc);
		driver.switchTo().defaultContent();
		}

	public void AttachFileResource() throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement eleAttachRes = wait.until(ExpectedConditions.elementToBeClickable(AttachResources));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleAttachRes);
        } catch (Exception e) {}		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NewResource));
		//String parentWindow = driver.getWindowHandle();
		element.click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		//Checking File Type
		WebElement eleFileType = wait.until(ExpectedConditions.elementToBeClickable(FileType));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleFileType);
        } catch (Exception e) {}
		

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
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleResourceDesc);
        } catch (Exception e) {}
		eleResourceDesc.sendKeys("Sample Description");
		
		//Clicking on Submit Button
		WebElement eleSubmit = wait.until(ExpectedConditions.elementToBeClickable(SubmitButn));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleSubmit);
        } catch (Exception e) {}
		
		//driver.switchTo().window(parentWindow);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void AttachLinkResource(String strURL,String GradeValue) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement eleAttachRes = wait.until(ExpectedConditions.elementToBeClickable(AttachResources));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleAttachRes);
        } catch (Exception e) {}		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NewResource));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        } catch (Exception e) {}		
		
		//String parentWindow = driver.getWindowHandle();
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Checking Link Type
		WebElement eleLink = wait.until(ExpectedConditions.elementToBeClickable(LinkType));
		
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleLink);
        } catch (Exception e) {}		
		
		//Entering URL value
		List<WebElement> eleURLVals = driver.findElements(URL);
		WebElement eleURL = eleURLVals.get(1);

	    try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleURL);
        } catch (Exception e) {

        }
	    
	    eleURL.sendKeys(strURL);
		
		//Entering Resource Title
		List<WebElement> eleTitleVals = driver.findElements(resTitle);
		WebElement eleTitle = eleTitleVals.get(1);

	    try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleTitle);
        } catch (Exception e) {

        }
	    
		eleTitle.sendKeys("Sample Resource Title");
		
		//Entering Resource Description
		List<WebElement> eleDescVals = driver.findElements(resDesc);
		WebElement eleDesc = eleDescVals.get(1);

	    try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleDesc);
        } catch (Exception e) {

        }
		eleDesc.sendKeys("Sample Resource Description");
		
		//Entering Grades 
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//driver.findElement(grades).click();
		
		List<WebElement> eleText = driver.findElements(By.xpath("//div[contains(@class,'margin-bottom-12 text-12 heavy')]"));
		WebElement eletxt = eleText.get(1);
		eletxt.click();
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//div[contains(@class,'selectize-dropdown-content')]//div[text()='"+GradeValue+"']")).click();
		eletxt.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Clicking on Submit Button
		List<WebElement> eleSubmits = driver.findElements(SubmitRes);
		WebElement eleSubmit = eleSubmits.get(1);
		wait.until(ExpectedConditions.elementToBeClickable(eleSubmit));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleSubmit);
        } catch (Exception e) {}
		
		
	}

	public void AttachDocResource(String strEmail, String strPwd,String GradeValue) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.switchTo().defaultContent();
		WebElement eleAttachRes = wait.until(ExpectedConditions.elementToBeClickable(AttachResources));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleAttachRes);
        } catch (Exception e) {}		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NewResource));
		//String parentWindow = driver.getWindowHandle();
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        } catch (Exception e) {}
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//Checking Doc Type
		WebElement eleDocType = wait.until(ExpectedConditions.elementToBeClickable(DocType));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleDocType);
        } catch (Exception e) {}
		
		//Clicking on ChooseDoc
		WebElement eleChooseDoc = wait.until(ExpectedConditions.elementToBeClickable(ChooseDoc));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleChooseDoc);
        } catch (Exception e) {}
		
		String ParWindow = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		try{
			
		WebElement eleDisconnect = wait.until(ExpectedConditions.elementToBeClickable(DisconnectGoogle));
		if(eleDisconnect.isDisplayed())
		{
			try {
	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].click()", eleDisconnect);
	        } catch (Exception e) {}
			driver.switchTo().alert().accept();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
		//Connect to google account
		WebElement eleConnect = wait.until(ExpectedConditions.elementToBeClickable(ConnectGoogle));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleConnect);
        } catch (Exception e) {}
		} catch(Exception e){
			e.printStackTrace();
		}
		try{
		//Use Another Account 
		WebElement eleUseAA = wait.until(ExpectedConditions.elementToBeClickable(UseAnotherAccount));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleUseAA);
        } catch (Exception e) {}
		}catch(Exception e){
			e.printStackTrace();
		}
			//String ParWindow = driver.getWindowHandle();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
		//Entering Email ID
		WebElement eleEmail = wait.until(ExpectedConditions.elementToBeClickable(Email));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleEmail);
        } catch (Exception e) {}
		eleEmail.sendKeys(strEmail);
		
		//clicking on Next 
		WebElement eleNext = wait.until(ExpectedConditions.elementToBeClickable(btnNext));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleNext);
        } catch (Exception e) {}
		
		//Entering password
		WebElement elePwd = wait.until(ExpectedConditions.elementToBeClickable(Password));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", elePwd);
        } catch (Exception e) {}
		elePwd.sendKeys(strPwd);
		
		//clicking on Next 
				WebElement eleNext2 = wait.until(ExpectedConditions.elementToBeClickable(btnNext));
				try {
		            ((JavascriptExecutor) driver).executeScript(
		                    "arguments[0].click()", eleNext2);
		        } catch (Exception e) {}

				
		//Clicking on Allow
		WebElement eleAllow = wait.until(ExpectedConditions.elementToBeClickable(btnAllow));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleAllow);
        } catch (Exception e) {}
		
		driver.switchTo().window(ParWindow);
		
		//Selecting resource
		List<WebElement> resCont = driver.findElements(resSelect);
		//System.out.println(resCont.size());
		WebElement res = resCont.get(2);

	    try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", res);
        } catch (Exception e) {

        }
	    WebElement btnAttach = wait.until(ExpectedConditions.elementToBeClickable(selectDoc));
		
	    try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", btnAttach);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", btnAttach);
        } catch (Exception e) {

        }

	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		//switch to parent window
	    driver.switchTo().window(ParWindow);
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		//Entering Resource Description
	    List<WebElement> resDescr = driver.findElements(resDesc);
		//System.out.println(resCont.size());
		WebElement resDesc = resDescr.get(2);
		
		WebElement eleDesc = wait.until(ExpectedConditions.elementToBeClickable(resDesc));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", eleDesc);
        } catch (Exception e) {}
		eleDesc.sendKeys("Sample Resource Description");
		
		//Entering Grades 
				driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
				//driver.findElement(grades).click();
				
				List<WebElement> eleText = driver.findElements(By.xpath("//div[contains(@class,'margin-bottom-12 text-12 heavy')]"));
				WebElement eletxt = eleText.get(2);
				eletxt.click();
				driver.switchTo().activeElement().sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//div[contains(@class,'selectize-dropdown-content')]//div[text()='"+GradeValue+"']")).click();
				eletxt.click();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Clicking on Submit Button
				List<WebElement> eleSubmits = driver.findElements(SubmitRes);
				WebElement eleSubmit = eleSubmits.get(2);
				wait.until(ExpectedConditions.elementToBeClickable(eleSubmit));
				try {
		            ((JavascriptExecutor) driver).executeScript(
		                    "arguments[0].click()", eleSubmit);
		        } catch (Exception e) {}
				
		
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
	}	
	//Adding Action
	public void clickAddAction(){
	/*	WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddAction));
		element.click(); */
		
		WebElement element = driver.findElement(AddAction);
		try {
			((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        } catch (Exception e) {

        }

	}
	
	//Entering Action value
	public void enterAction(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ActionTitle));
		element.click();
		element.sendKeys("Sample Action");
	}
	
	//Clicking on Add Step Button
	public void clickAddStep(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SubmitButn));
		element.click();
	}
}
