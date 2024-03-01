import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class C17_BrokenLinks_HTTPConn {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer = driver .findElement(By.cssSelector("div#gf-BIG"));
		List<WebElement> lst = footer.findElements(By.tagName("a"));
		System.out.println(lst.size());
		SoftAssert ass = new SoftAssert();
		for (WebElement w : lst) {
			String url = w.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int statusCode = conn.getResponseCode();
			if(statusCode>400) {
				System.out.println(url+" --> Broken Link");
				ass.assertTrue(statusCode>400);
			}
		}
		ass.assertAll();
		Thread.sleep(10000);
		driver.quit();
	}

}
