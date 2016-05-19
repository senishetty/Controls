package mainMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class GeneralFunction {
	public static void main(String args[]) throws BiffException, IOException
	{
		String s2=readTestData("Password");
		System.out.println(s2);
	}
	
	public static String readTestData(String data) throws BiffException, IOException
	{
	//FileInputStream fi=new FileInputStream("C:\\Users\\senishetty\\workspace\\Testlink\\TestData\\TestDataExcelFile.xls");
	Workbook objWorkbook = Workbook.getWorkbook(new File("C:/Users/senishetty/workspace/Testlink/TestData/TestDataExcelFile.xls"));
	Sheet s = objWorkbook.getSheet(0);
	String s1="";
	for (int i = 0; i < s.getRows(); i++)
	 {
		if(data.equals(s.getCell(0,i).getContents()))
		{
			s1=s.getCell(1,i).getContents();
			break;
	    }
		
	 }
	return s1;
	
	}
	public static String readXpath(String data) throws Exception
	{
		System.getProperty("user.dir");
		
		FileInputStream file = new FileInputStream("C:/Users/senishetty/workspace/Testlink/src/resource/utilities/data.properties");
		Properties props=new Properties();
		props.load(file);
		String sValue = props.getProperty(data);
		return sValue;
		
		
	}

}
