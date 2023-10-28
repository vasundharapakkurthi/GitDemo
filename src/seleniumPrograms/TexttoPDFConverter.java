package seleniumPrograms;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TexttoPDFConverter {

	public static void main(String[] args) throws InterruptedException, IOException {
		
			//Launching the chrome browser
			String path = System.getProperty("user.dir")+"\\Resources\\ChromeDriver.exe";
			System.setProperty("WebDriver.Chrome.Driver", path);
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			//Navigate to the Text to PDF converter URL
			driver.get("https://www.sodapdf.com/txt-to-pdf/");
			Thread.sleep(1000);
			
			//Click on Choose File button
			driver.findElement(By.xpath("//label[@aria-label=\"Choose file\"]")).click();
			Thread.sleep(1000);
			
			//File upload code
			String a[]=new String[1];
			a[0]="D:\\AutoITCode\\TextFileUpload.exe";
			Runtime.getRuntime().exec(a);
			
			driver.switchTo().defaultContent();
			Thread.sleep(10000);
			/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(2));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='btn-base']"))));*/
			
			driver.findElement(By.xpath("//a[@class='btn-base']")).click();
			Thread.sleep(1000);
			
			
			File f = new File("C:\\Users\\VasundharaP\\Downloads\\sodapdf-converted.pdf");
			
			if(f.exists())
				Assert.assertTrue(true);
			else
				Assert.assertFalse(false);
			
			
			
			
			
	}

}
