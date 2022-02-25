package resources1;

import java.io.File;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public static  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources1\\data.properties");

prop.load(fis);
String browserName=System.getProperty("browser");


if(browserName.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\user\\Downloads\\chromedriver_new\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	/*options.addArguments("headless");*/
	driver= new ChromeDriver(options);
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	
	System.setProperty("webdriver.gecko.driver",
			"C:\\Users\\user\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
	 driver= new FirefoxDriver();
	

}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}
