import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class C21_RelativeLocators {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement temp = driver.findElement(By.xpath("//div/input[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(temp)).getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement temp2 = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		driver.findElement(with(By.tagName("input")).below(temp2)).click();
		
	}
}
