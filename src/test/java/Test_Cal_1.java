import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Cal_1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.path2usa.com/travel-companion/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		//Thread.sleep(1000);
		//js.executeScript("window.scrollBy(750,1000)");
		driver.findElement(By.cssSelector("input#form-field-travel_from")).sendKeys("PNQ");
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']/li[@class='ui-menu-item']/div")));
		driver.findElement(By.xpath("//ul/li[@class='ui-menu-item']/div")).click();
		driver.findElement(By.cssSelector("input#form-field-travel_to")).sendKeys("DEL");
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div")));
		List<WebElement> lst = driver.findElements(By.xpath("//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div"));
		for(int i=0;i<lst.size();i++) {
			String temp = lst.get(i).getText();
			if(temp.equalsIgnoreCase("Indira Gandhi International Airport (DEL) Delhi")) {
				lst.get(i).click();
				break;
			}
		}
		driver.findElement(By.cssSelector("input#form-field-travel_comp_date")).click();
		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='dayContainer']/span")));
		while(!driver.findElement(By.xpath("//div[@class='flatpickr-month']/div/span[@class='cur-month']")).getText().contains("April")) {
			driver.findElement(By.xpath("//div/span[@class='flatpickr-next-month']")).click();
			Thread.sleep(200);
		}
		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='dayContainer']/span")));
		List<WebElement> lst2 = driver.findElements(By.xpath("//div[@class='dayContainer']/span"));
		for(int j=0;j<lst2.size();j++) {
			String temp2 = lst2.get(j).getText();
			if(temp2.equalsIgnoreCase("8")) {
				lst2.get(j).click();
				break;
			}
		}
		Thread.sleep(10000);
		driver.quit();
	}
}
