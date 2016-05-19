package testScripts;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import mainMethods.Application;
import mainMethods.GeneralFunction;

public class LoginApp {
	public static void main(String args[])throws Exception
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.get(GeneralFunction.readTestData("Url"));
		Thread.sleep(1000);
		Application.loginInToApplication(driver,GeneralFunction.readTestData("Username"),GeneralFunction.readTestData("Password"));
		Thread.sleep(10000);
		Application.logout(driver);
		Application.closeDriver(driver);
		
	}

}
