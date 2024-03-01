import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class C7_Greencart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] explst = {"Brocolli", "Cucumber", "Carrot"};
		List arraylist = Arrays.asList(explst);
		int j = 0;
		List<WebElement> lst = driver.findElements(By.cssSelector("div.product h4.product-name"));
		for(int i=0;i<lst.size();i++) {
			String prd = lst.get(i).getText();
			String[] t1 = prd.split("-");
			String actprd = t1[0].trim();
			if(arraylist.contains(actprd)){
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				System.out.println(actprd);
				if(j==explst.length) {
					break;
				}
			}
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Explicit wait
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		//w1.until(ExpectedConditions.);
		String chk1 = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println(chk1);
	
		Thread.sleep(15000);
		driver.quit();
	}

}
