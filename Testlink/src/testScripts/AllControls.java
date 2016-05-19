package testScripts;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class AllControls {
	

	@Test
	public static void test1() throws InterruptedException, AWTException
	{
		  
		//final Logger log = Logger.getLogger(AllControls.class);
		WebDriver driver = new FirefoxDriver();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		//log.debug("browser is launched with url");
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.id("text1"));
		if(name.isEnabled())
			name.sendKeys("Test");
		else
		{
			WebElement submittable = driver.findElement(By.xpath("//table/tbody/tr/td/form/input[@id='submitButton']"));
			submittable.click();
			name.sendKeys("Test");
		}
		 WebElement lname = driver.findElement(By.id("text2"));
		   if(lname.isEnabled())
			   lname.sendKeys("ltest");
		   else
		   {
		   WebDriverWait wait=new WebDriverWait(driver,15);
		   wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));
		   lname.sendKeys("ltest");
		   }
	   WebElement check1 = driver.findElement(By.id("check1"));
	   if(check1.isSelected())
		   System.out.println("Element check1 already selected");
	   else
	   check1.click();
	   
	   WebElement check2 = driver.findElement(By.id("check2"));
	   if(check2.isSelected())
		   System.out.println("Element check2 already selected");
	   else
	   check2.click();
	   
	   WebElement gender = driver.findElement(By.id("radio2"));
	   gender.click();
	   Select dropdown1 = new Select(driver.findElement(By.id("Carlist")));
	   System.out.println(dropdown1.getFirstSelectedOption().getText());
	   dropdown1.selectByValue("Audi Car");
	   System.out.println(dropdown1.getFirstSelectedOption().getText());
	   
	   WebElement select = driver.findElement(By.xpath("//table/tbody/tr/td[1]/select[@name='FromLB']"));
	   if(select.isEnabled())
	   {
	   //Prepare list of selectable Items
       //List<WebElement> selectableItems = driver.findElements(By.xpath("//table/tbody/tr/td[1]/select[@name='FromLB']/option"));
       
       Select selectItems = new Select(driver.findElement(By.xpath("//table/tbody/tr/td[1]/select[@name='FromLB']")));
       
       if(selectItems.isMultiple())
       {

       selectItems.selectByVisibleText("Mexico");
       selectItems.selectByVisibleText("Spain");
       }
       else
    	   selectItems.selectByVisibleText("India");
       WebElement clickselectItem = driver.findElement(By.xpath("//table/tbody/tr/td/input[@value='->']"));
       clickselectItem.click();
	   }
	   WebElement cfrmpopup = driver.findElement(By.xpath("//button[contains(text(),'Show Me Confirmation')]"));
	   if(cfrmpopup.isEnabled())
	   cfrmpopup.click();
	   Alert a = driver.switchTo().alert();
	   a.accept();
	   WebElement alertmsg = driver.findElement(By.xpath("//input[@value='Show Me Alert']"));
	   alertmsg.click();
	   Alert b= driver.switchTo().alert();
	   System.out.print(b.getText());
	   b.accept();
	   Thread.sleep(5000);
	   WebElement prompt = driver.findElement(By.xpath("//button[contains(text(),'Show Me Prompt')]"));
	   prompt.click();
	   Alert c = driver.switchTo().alert();
	   c.sendKeys("hello");
	   Thread.sleep(5000);
	   c.accept();
	   WebElement file =driver.findElement(By.xpath("//input[@type='file']"));
	   file.click();
	   String fileLocation = System.getProperty("user.dir") + "\\TestData\\" + "TestDataExcelFile.xls";
	   StringSelection filepath = new StringSelection(fileLocation);

	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

	   try {

	   Robot robot = new Robot();

	   robot.keyPress(KeyEvent.VK_CONTROL);

	   robot.keyPress(KeyEvent.VK_V);

	   robot.keyRelease(KeyEvent.VK_V);

	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   Thread.sleep(1000);

	   robot.keyPress(KeyEvent.VK_ENTER);

	   robot.keyRelease(KeyEvent.VK_ENTER);

	   } catch (AWTException e) {e.printStackTrace();}
	   Thread.sleep(5000);
	   /*driver.close();
	   driver.quit();*/
	   
	   
	   
	   
	 
		   
		
		
	}

}
