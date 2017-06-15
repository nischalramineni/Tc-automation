package src.com.flows;
import org.openqa.selenium.WebDriver;

import src.com.pages.CreateCoursePage;

public class CreateCourseFlow {
	
	WebDriver driver;
	CreateCoursePage objcourse;
	
	public CreateCourseFlow(WebDriver driver)
	{
		this.driver=driver;
	}
	 
	
	public void CreateCourseScenario(String courseName, String courseDesc, String gradeValue) throws InterruptedException
	{
		objcourse = new CreateCoursePage(driver);
		
		//clicking on Courses link
		objcourse.clickCoursesLink();
		
		//Clicking on Create New course link
		objcourse.clickNewCourse();
		
		//Entering Course Name
		objcourse.setCourseName(courseName);
		
		//Entering Course Description
		objcourse.setCourseDesc(courseDesc);
		
		//Select the grade value
		objcourse.selectGradeValue(gradeValue);
		
		//Click on Create Course
		objcourse.clickCreateCourse();
	}
	
}
