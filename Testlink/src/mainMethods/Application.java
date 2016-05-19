package mainMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Application{
	public static void loginInToApplication(WebDriver driver,String Username,String Password) throws Exception
	{
		if((driver.getTitle()).equals("TestLink"))
			System.out.println("Testlink Application opened Successfully"); 
		WebElement username = driver.findElement(By.xpath(GeneralFunction.readXpath("username")));
		WebElement password = driver.findElement(By.xpath(GeneralFunction.readXpath("password")));
		WebElement login = driver.findElement(By.xpath(GeneralFunction.readXpath("submitLogin")));
		if(username.isEnabled())
			username.sendKeys(Username);
		pageLoad(10000);
		if(password.isEnabled())
			password.sendKeys(Password);
		pageLoad(10000);
		if(login.isEnabled())
			login.click();
		if((driver.getTitle()).equals("TestLink 1.9.12 (GaGa and the twins)"))
			System.out.println("Login Successful");
	}
	
	public static void logout(WebDriver driver) throws Exception
	{
	
	    switchFrame(driver,"titlebar");
		WebElement logout = driver.findElement(By.xpath(GeneralFunction.readXpath("logout")));
		logout.click();
	}
	public static void closeDriver(WebDriver driver)
	{
		driver.close();
		driver.quit();	
	}
	public static void switchFrame(WebDriver driver,String fname)
	{
			try {
				driver.switchTo().frame(fname);
			}  catch (Exception e) {
				System.out.println("Unable to navigate to frame with name " + fname + e.getStackTrace());
		}
	
	}
	public static void pageLoad(int waitTime) throws InterruptedException
	{
		Thread.sleep(waitTime);
	}
	
	public static  void selectItemFromDropdown(WebDriver driver,String locator,String item)throws Exception
	{
		WebElement searchList = driver.findElement(By.xpath(locator));
	
	if(searchList.isEnabled())
	{
		int flag=0;
		//List<WebElement> searchListElements = driver.findElements(By.xpath(GeneralFunction.readXpath("searchFromDropdownElements")));
		List<WebElement> searchListElements = searchList.findElements(By.tagName("li"));
		for (WebElement element: searchListElements) {
		      if(item.equals(element.getText().trim()))
		      {
		    		  element.click();
		    		  flag = 1;
		              break;
		      }
		    
		}
		  if(flag==0)
	    	  System.out.println("Test Plan Not Found");
	      else
	    	  System.out.print("Test Plan Found");
	
		Thread.sleep(10000);
	}
	}

	
}
