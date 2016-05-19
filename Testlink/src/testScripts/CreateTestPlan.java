package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import mainMethods.Application;
import mainMethods.GeneralFunction;
	
	
	public class CreateTestPlan {
		@Test
		public static void createPlan()throws Exception
		{
			WebDriver driver = new FirefoxDriver();
			driver.get(GeneralFunction.readTestData("Url"));
			Application.pageLoad(10000);
			Application.loginInToApplication(driver,GeneralFunction.readTestData("Username"),GeneralFunction.readTestData("Password"));
			Application.pageLoad(10000);
			createTestPlanMainMethod(driver);
			driver.switchTo().defaultContent();
			verifyTestPlan(driver);
			driver.switchTo().defaultContent();
			Application.logout(driver);
			Application.closeDriver(driver);	
		}
		public static void createTestPlanMainMethod(WebDriver driver) throws Exception
		{
			Application.switchFrame(driver,"mainframe");
			WebElement testplan = driver.findElement(By.xpath(GeneralFunction.readXpath("testplanlink")));
			testplan.click();
			Application.pageLoad(10000);
			WebElement create = driver.findElement(By.xpath(GeneralFunction.readXpath("create")));
			create.click();
			Application.pageLoad(10000);
			WebElement testplanName = driver.findElement(By.xpath(GeneralFunction.readXpath("testplanname")));
			if(testplanName.isEnabled())
			{
				testplanName.sendKeys(GeneralFunction.readTestData("TestplanName"));
			}
			WebElement active = driver.findElement(By.xpath(GeneralFunction.readXpath("activeCheckbox")));
			active.click();
			WebElement publicAccess = driver.findElement(By.xpath(GeneralFunction.readXpath("publicCheckbox")));
			publicAccess.click();
			WebElement createTestPlan = driver.findElement(By.xpath(GeneralFunction.readXpath("createTestPlan")));
			createTestPlan.click();
			Reporter.log("Successfully created Test Plan");
			//System.out.println("Successfully created Test Plan");
			Application.pageLoad(1000);	
		}
		public static void verifyTestPlan(WebDriver driver) throws Exception
		{
			Application.switchFrame(driver,"titlebar");
			WebElement home = driver.findElement(By.xpath(GeneralFunction.readXpath("homeButton")));
			if(home.isEnabled())
			{
				home.click();
			}
			Application.pageLoad(10000);
			Application.switchFrame(driver,"mainframe");
			WebElement testplan = driver.findElement(By.xpath(GeneralFunction.readXpath("testplanlink")));
			testplan.click();
			Application.pageLoad(10000);
			//WebElement verifyTestPlan = driver.findElement(By.partialLinkText(GeneralFunction.readTestData("TestplanName")));
			WebElement verifyTestPlan = driver.findElement(By.xpath("//a[contains(text(),"+GeneralFunction.readTestData("TestplanName")+")]"));
			if(verifyTestPlan.isDisplayed())
			{
				System.out.println("Verified Testplan Created Successfully");
			}	
			
		}
}
