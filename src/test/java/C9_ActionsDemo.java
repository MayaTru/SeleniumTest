import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class C9_ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Account & Lists']")));
		a.moveToElement(driver.findElement(By.xpath("//span[text()='Account & Lists']"))).build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("iphone").doubleClick().build().perform();
		Thread.sleep(10000);
		driver.quit();
	}

}
