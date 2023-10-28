package seleniumPrograms;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class FileUpload 
{
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws InterruptedException, IOException
	{
		String downloadPath = "C:\\Users\\VasundharaP\\Downloads";
		
		String path = System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
		System.setProperty("WebDriver.Chrome.Driver",path);
		
		
		//Chrome browser launching
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigating to the Pdf converter URL
		driver.get("https://altoconvertpdftojpg.com/");
		
		//Click on Cookies accept button 
		driver.findElement(By.xpath("//button[contains(@class,'cookie-accept-btn')]")).click();
		Thread.sleep(1000);

		//Click on Browser button 
		driver.findElement(By.xpath("//button[@id=\"browse\"]")).click();
		Thread.sleep(1000);
		
		//Execute Auto IT exe file 
		String[] a = new String[1];
		a[0]="D:\\AutoITCode\\FileUpload.exe";
		Runtime.getRuntime().exec(a); 	
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		
		//Click on Convert Button 
		driver.findElement(By.xpath("//button[@id=\"submit_btn\"]")).click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Finished']")));
		
		driver.findElement(By.xpath("//a[contains(@href,'/download')]")).click();
		Thread.sleep(1000);
		
		File f = new File(downloadPath+"\\Org_Settings_Calendar_Report.zip");
		if(f.exists())
		{
			Assert.assertTrue(true);
		}
	}

}
