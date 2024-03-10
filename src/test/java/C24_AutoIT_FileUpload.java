import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class C24_AutoIT_FileUpload {
	@Test
	public void Test1() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		String filePath = System.getProperty("user.dir") + "\\target";
		prefs.put("download.default_directory", filePath);
		opt.setExperimentalOption("prefs", prefs);
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://altoconvertpdftojpg.com/");
		WebElement upload =  driver.findElement(By.cssSelector("#browse"));
		//String fileToUp = "C:\\Users\\Mayank\\Downloads\\Relieving_letter.pdf";
		upload.click();
		Thread.sleep(3000);
		System.out.println(System.getProperty("user.dir")+"\\autoscript.exe");
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoscript.exe");
		Thread.sleep(3000);
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submit_btn")));
		driver.findElement(By.cssSelector("#submit_btn")).click();
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("Download")));
		driver.findElement(By.linkText("Download")).click();
		
	}
}
