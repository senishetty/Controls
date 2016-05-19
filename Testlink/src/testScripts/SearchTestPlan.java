package testScripts;


import mainMethods.Application;
import mainMethods.GeneralFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SearchTestPlan {
	@Test
	public static void searchPlan() throws Exception
	{
		WebDriver driver = new FirefoxDriver();
		driver.get(GeneralFunction.readTestData("Url"));
		driver.manage().window().maximize();
		Application.pageLoad(10000);
		Application.loginInToApplication(driver,GeneralFunction.readTestData("Username"),GeneralFunction.readTestData("Password"));
		Application.pageLoad(10000);
		search(driver);
		driver.switchTo().defaultContent();
		Application.pageLoad(10000);
		Application.logout(driver);
		Application.closeDriver(driver);	
			
	}
	public static void search(WebDriver driver) throws Exception
	{
		Application.switchFrame(driver,"mainframe");
		WebElement searchBox = driver.findElement(By.xpath(GeneralFunction.readXpath("searchBox")));
		if(searchBox.isEnabled())
			searchBox.click();
		WebElement searchBoxTypeText = driver.findElement(By.xpath(GeneralFunction.readXpath("searchBoxTypeText")));
		if(searchBoxTypeText.isEnabled())
		searchBoxTypeText.sendKeys("Test");
		Application.selectItemFromDropdown(driver,GeneralFunction.readXpath("searchFromDropdown"),GeneralFunction.readTestData("TestplanName"));		
	}
	

}
