import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C10_WindowHandleExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		//itr is outside set, so 1st call will be for parentId
		String parent = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);
		String usrnme = driver.findElement(By.xpath("//strong/a")).getText();
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.cssSelector("#username")).sendKeys(usrnme);
		Thread.sleep(10000);
		driver.quit();
	}

}
