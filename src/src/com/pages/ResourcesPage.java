package src.com.pages;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResourcesPage {
WebDriver driver;
	
	public ResourcesPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	//Object Repository
	//Resources
	private By Resources		= By.xpath("//a[contains(text(),'Resources')]");
	//Label
	private By ResourcesCount   = By.xpath("//span[contains(@class,'js-inner-title')]");
	//Resources Root
	private By ResRootClass 	= By.xpath("//div[contains(@class,'resource-card-details')]");
	//Load More Resources
	private By LoadMore			= By.xpath("//a[contains(@class,'load-more btn')]");
	//Scroll to Top
	private By Scroller			= By.xpath("//span[contains(text(),'Scroll to Top')]");
	
	//Public Methods
	public void clickResources(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Resources));
		element.click();
	}
		
	public int[] getResourceCount() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ResourcesCount));
		//Getting Expected Count
		String ResCount = element.getText();
		String counter[]= ResCount.split(" ");
		int ExpCount = Integer.parseInt(counter[0]);
		System.out.println("Expected Count :"+ExpCount);
		
		WebElement load = wait.until(ExpectedConditions.elementToBeClickable(LoadMore));
		String pagenum = load.getAttribute("data-items");
		System.out.println("Data Items :"+pagenum);
		int pages = Integer.parseInt(pagenum);
		int ActualCount=0;
		for(int i=15;i<pages;i=i+15){
			
			WebElement More = wait.until(ExpectedConditions.elementToBeClickable(LoadMore));
			try {
	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].scrollIntoView(true);", More);
	        } catch (Exception e) {

	        }
			try {
	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].click()", More);
	        } catch (Exception e) {

	        }
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);			
		}
		
		WebElement Scroll = wait.until(ExpectedConditions.elementToBeClickable(Scroller));
		try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", Scroll);
        } catch (Exception e) {

        }
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(LoadMore));
		
		List<WebElement> resCount = driver.findElements(ResRootClass);
		 ActualCount = resCount.size();
		 
		 Thread.sleep(10);
		 	if(ActualCount!=ExpCount){
		 		
		 		List<WebElement> resCountagain = driver.findElements(ResRootClass);
				 ActualCount = resCountagain.size();
		 	}
		System.out.println("Actual Count:"+ActualCount);
		
		int [] count = new int[3];
		count[0]=ExpCount;
		count[1]=ActualCount;
		
		return count;
	}
	
	public void CountVerification(int ExpCount, int ActualCount){
		
		Assert.assertEquals(ActualCount, ExpCount);
	}
}
