import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class C14_Scroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=100");
		////div[@class='tableFixHead']/table[@id='product']/tbody/tr/td[4]
		List<WebElement> lst = driver.findElements(By.cssSelector("div.tableFixHead td:nth-child(4)"));
		System.out.println(lst.get(0).getText());
		int total = 0;
		for(int i=0;i<lst.size();i++) {
			String temp = lst.get(i).getText();
			int temp2 = Integer.parseInt(temp);
			total += temp2;
		}
		System.out.println("-->"+total);
		String temp3 = driver.findElement(By.cssSelector("div.totalAmount")).getText();
		String[] temp4 = temp3.split(":");
		int totalex = Integer.parseInt(temp4[1].trim());
		System.out.println("-->"+totalex);
		Assert.assertEquals(total, totalex);
		Thread.sleep(10000);
		driver.quit();
	}

}
