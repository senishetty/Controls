package testScripts;

import mainMethods.Application;
import mainMethods.GeneralFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DeleteTestPlan {
	@Test
	public static void DeletePlan()throws Exception
	{
		WebDriver driver = new FirefoxDriver();
		driver.get(GeneralFunction.readTestData("Url"));
		Application.pageLoad(10000);
		Application.loginInToApplication(driver,GeneralFunction.readTestData("Username"),GeneralFunction.readTestData("Password"));
		Application.pageLoad(10000);
		deleteTestPlanMainMethod(driver);
		driver.switchTo().defaultContent();
		Application.pageLoad(10000);
		Application.logout(driver);
		Application.closeDriver(driver);	
	}
	public static void deleteTestPlanMainMethod(WebDriver driver) throws Exception
	{
		String a = "";
		Application.switchFrame(driver,"mainframe");
		WebElement testplan = driver.findElement(By.xpath(GeneralFunction.readXpath("testplanlink")));
		testplan.click();
		Application.pageLoad(10000);
		int irow = driver.findElements(By.xpath(GeneralFunction.readXpath("testPlanTableRows"))).size();
		for(int i=1;i<=irow;i++)
		{
			a=driver.findElement(By.xpath("//table[@id='item_view']/tbody/tr["+i+"]/td/a")).getText();
			//if(driver.findElement(By.xpath("//table[@id='item_view']/tbody/tr["+i+"]/td/a[contains(text(),'Test123')]")).isDisplayed())
			if(a.equals(GeneralFunction.readTestData("TestplanName")))
			{
				driver.findElement(By.xpath(GeneralFunction.readXpath("deleteImage"))).click();
				break;
			}	
		}
		WebElement delete=driver.findElement(By.xpath(GeneralFunction.readXpath("deleteButton")));
		
		if(delete.isEnabled())
		{
			delete.click();
			System.out.println("Successfully deleted");
		}
		
		
	}
	
}
