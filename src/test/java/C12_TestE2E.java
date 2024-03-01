import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class C12_TestE2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footerDriver = driver.findElement(By.cssSelector("div#gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		WebElement coloumDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
		List<WebElement> lst = coloumDriver.findElements(By.tagName("a"));
		int lstsize = coloumDriver.findElements(By.tagName("a")).size();
		System.out.println(lstsize);
		Actions a = new Actions(driver);
		for(int i=1;i<coloumDriver.findElements(By.tagName("a")).size();i++) {
			a.moveToElement(lst.get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentID = itr.next();
		/*for(int j=1;j<windows.size();j++) {
			String child = itr.next();
			driver.switchTo().window(child);
			String title = driver.getTitle();
			System.out.println(j+". "+title);
			driver.close();
		}*/
		int j=0;
		while(itr.hasNext()) {
			j++;
			driver.switchTo().window(itr.next());
			String title = driver.getTitle();
			System.out.println(j+"--> "+title);
			driver.close();
		}
		Thread.sleep(10000);
		driver.quit();
	}

}