import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class C8_FlentWaitTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		System.out.println(driver.findElement(By.cssSelector("div#finish h4")).isDisplayed());
		driver.findElement(By.cssSelector("div#start button")).click();
		System.out.println(driver.findElement(By.cssSelector("div#finish h4")).isDisplayed());
		//Imp -> Interview -> polling
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			//Imp -> apply method in interview
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("div#finish h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("div#finish h4"));
				}
				else
					return null;
			}
		});
		System.out.println(driver.findElement(By.cssSelector("div#finish h4")).isDisplayed());
		String chk1 = driver.findElement(By.cssSelector("div#finish h4")).getText();
		System.out.println(chk1);
		
		Thread.sleep(5000);
		driver.quit();
	}

}
